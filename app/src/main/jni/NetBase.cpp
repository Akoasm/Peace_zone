#include "NetBase.h"
#include "raknet/Kbhit.h"
#include "raknet/RakNetStatistics.h"
#include "raknet/GetTime.h"
#include "raknet/MessageIdentifiers.h"
#include "raknet/MTUSize.h"
#ifdef _WIN32
#include <WinSock2.h>
#include <windows.h>
#include "../NetInterface.h"
#pragma  comment(lib,"pthreadVC2.lib")
#pragma comment(lib,"osnet.lib")
#pragma comment(lib,"Ws2_32")
#else
#include <unistd.h>
#include <arpa/inet.h>
#endif

using namespace sails;

void* RecvCallFunc(void* sender) {
	UDPNetBase* udb = static_cast<UDPNetBase*> (sender);
	udb->RecvData();
	printf("UDP: %p 数据读取线程停止\n", sender);
	return (void*)(0);
}

//���������

UDPNetBase::UDPNetBase() {
	bindPort = 0;
	svrPort = 0;
	netInterface = 0x00;
	IsConnectedServer = false;
	userData = 0x00;
	callFunc = 0x00;
	threadIsExit = true;
	lock = new OSLock();
	printf("UDP New:%p\n", this);
}

UDPNetBase::~UDPNetBase() {
	FreeNet();
	delete lock;
	lock = 0;
	printf("UDP Free:%p\n", this);
}

bool UDPNetBase::InitNet(unsigned int bindPort, int MaxConnectCount) {
	if (bindPort <= 0) {
		return false;
	}
	if (netInterface != 0x00) {
		FreeNet();
	}
	this->bindPort = bindPort;
	netInterface = RakNetworkFactory::GetRakPeerInterface();
	SocketDescriptor socketDescript(bindPort, 0);
	netInterface->SetMaximumIncomingConnections(MaxConnectCount);
	if (netInterface->Startup(MaxConnectCount, 10, &socketDescript, 1)) {
		IsConnectedServer = true;
		if (pthread_create(&recvDataThread, 0, &RecvCallFunc, this) != 0) {
			printf("创建数据处理线程失败");
			return false;
		}
		//recvDataThread = std::thread(RecvCallFunc, this);
		return true;
	}
	return false;
}

bool UDPNetBase::InitNet(std::string svrIP, unsigned int svrPort) {
	if (svrPort <= 0 || svrIP == "") {
		return false;
	}
	if (netInterface != 0x00) {
		FreeNet();
	}
	this->svrIP = svrIP;
	this->svrPort = svrPort;
	netInterface = RakNetworkFactory::GetRakPeerInterface();
	netInterface->SetTimeoutTime(1000*60*5, UNASSIGNED_SYSTEM_ADDRESS);
	SocketDescriptor socketDescriptor(0, 0);
	if (netInterface->Startup(1, 10, &socketDescriptor, 1)) {
		netInterface->SetSplitMessageProgressInterval(10); // Get ID_DOWNLOAD_PROGRESS notifications
		if (netInterface->Connect(svrIP.c_str(), svrPort, 0, 0)) {
			IsConnectedServer = true;
			//            recvDataThread = std::thread(RecvCallFunc, this);
			//            recvDataThread.detach();
			if (pthread_create(&recvDataThread, 0, &RecvCallFunc, this) != 0) {
				printf("创建数据处理线程失败");
				return false;
			}
			return true;
		}
	}
	return false;
}
bool UDPNetBase::SendData(void* dataBuf, unsigned int dataSize) {
	if (svrIP.empty() || svrPort == 0 || dataSize <= 0) {
		return false;
	}
#ifdef _WIN32
	TestContent(dataBuf, dataSize);
#endif
	if (IsConnectedServer) {
		SystemAddress systemAddress(svrIP.c_str(), svrPort);
		return netInterface->Send((const char*)dataBuf, dataSize, LOW_PRIORITY, UNRELIABLE, 0, systemAddress, false);
	}
	return false;
}

bool UDPNetBase::SendData(long svrIp, unsigned int svrPort, void* dataBuf, unsigned int dataSize) {
	if (bindPort == 0) {
		return false;
	}
	if (IsConnectedServer) {
		in_addr addr;
		addr.s_addr = svrIp;
		SystemAddress systemAddress(inet_ntoa(addr), svrPort);
		// SYSTEM_PRIORITY, UNRELIABLE_SEQUENCED
		return netInterface->Send((const char*)dataBuf, dataSize, LOW_PRIORITY, UNRELIABLE, 0, systemAddress, false);
	}
	return false;
}

void UDPNetBase::FreeNet() {
	IsConnectedServer = false;
#ifdef _WIN32
	if (recvDataThread.p != 0) {
		pthread_cancel(recvDataThread);
		//pthread_join(recvDataThread,0);
		recvDataThread.p = 0;
		recvDataThread.x = 0;
	}
	else {
		while (true) {
			if (threadIsExit) {
				break;
			}
			Sleep(10);
		}
	}
#else
	if (recvDataThread != 0) {

		pthread_kill(recvDataThread,0);
		//pthread_cancel(recvDataThread);

		//pthread_join(recvDataThread,0);
		recvDataThread = 0;
	} else {
		while (true) {
			if (threadIsExit) {
				break;
			}
			sleep(1);
		}
	}
#endif // _WIN32
	if (netInterface != 0x00) {
		netInterface->Shutdown(1);
		RakNetworkFactory::DestroyRakPeerInterface(netInterface);
		netInterface = 0x00;
	}
}

bool UDPNetBase::SendDataToAll(void* dataBuf, unsigned int dataSize) {
	if (bindPort == 0) {
		return false;
	}
	if (IsConnectedServer) {
		SystemAddress systemAddress(svrIP.c_str(), svrPort);
		return netInterface->Send((const char*)dataBuf, dataSize, LOW_PRIORITY, UNRELIABLE, 0, systemAddress, true);
	}
	return false;
}

void UDPNetBase::RecvData() {
	Packet *packet;
	threadIsExit = false;
	while (IsConnectedServer) {
		for (packet = netInterface->Receive();
			packet;
			netInterface->DeallocatePacket(packet),
			packet = netInterface->Receive())
		{
			{
				AutoLock alock(lock);
#ifdef _WIN32
				TestContent(packet->data, packet->length);
#endif
				if (callFunc != 0x00) {
					callFunc((char*)packet->data, (unsigned int)packet->length,
						packet->systemAddress.binaryAddress,
						(unsigned int)packet->systemAddress.port,
						packet->data[0], userData, this);
				}
			}
			if (!IsConnectedServer)
			{
				break;
			}
		}
#ifdef _WIN32
		Sleep(50);
#else
		usleep(500);
#endif
	}
	threadIsExit = true;
}

bool UDPNetBase::SetCallFunc(void* userData, OnDataRecvCallFunc callFunc) {
	AutoLock alock(lock);
	this->userData = userData;
	this->callFunc = callFunc;
	return true;
}

bool UDPNetBase::SendDataToOrtherAll(void* data, unsigned int dataSize, long srcIP, unsigned int srcPort) {
	if (bindPort == 0) {
		return false;
	}
	if (IsConnectedServer) {
		in_addr addr;
		SystemAddress systemAddress(inet_ntoa(addr), svrPort);
		return netInterface->Send((const char*)data, dataSize, LOW_PRIORITY, UNRELIABLE, 0, systemAddress, true);
	}
	return false;
}

OSLock::OSLock() {
	pthread_mutex_init(&mutex, 0);
}

OSLock::~OSLock() {
	pthread_mutex_destroy(&mutex);
}

int OSLock::Lock() {
	return pthread_mutex_lock(&mutex);
}

int OSLock::UnLock() {
	return pthread_mutex_unlock(&mutex);
}

int OSLock::TryLock() {
	return pthread_mutex_trylock(&mutex);
}

AutoLock::AutoLock(OSLock* lock) {
	this->lock = lock;
	if (lock->Lock() == 0) {
		isLock = true;
	}
	else {
		isLock = false;
	}
}

AutoLock::~AutoLock() {
	if (isLock) {
		lock->UnLock();
	}
}
