#include <string>
#include <jni.h>
#include "NetInterface.h"
#include "NetBase.h"


#ifdef _WIN32
#include <windows.h>
#if _DEBUG
#pragma comment(lib,"osnetd.lib")
#else
#pragma comment(lib,"osnet.lib")
#endif
#endif

void * CreateServer(unsigned int bindPort, int MaxConnectCount) {
	UDPNetBase* handle = new UDPNetBase();
	if (!handle->InitNet(bindPort, MaxConnectCount)) {
		handle->FreeNet();
		handle = 0x00;
	}
	return handle;
}

void * CreateClient(const char* svrIp, unsigned int svrPort) {

	printf("IP:%s Port:%d\n", svrIp, svrPort);
	if (svrIp == "" || strlen(svrIp) < 7)
	{
		printf("IP Error\n");
		return 0;
	}
	if (svrPort < 1024 || svrPort >65536)
	{
		printf("Port Error\n");
		return 0;
	}

	UDPNetBase* handle = new UDPNetBase();
	if (!handle->InitNet(std::string(svrIp), svrPort)) {
		handle->FreeNet();
		handle = 0x00;
	}

	return handle;
}

void FreeNet(void* netHandle) {
	UDPNetBase* handle = static_cast<UDPNetBase*> (netHandle);
	if (handle != 0x00) {
		//handle->FreeNet();
		delete handle;
		handle = 0x00;
	}
}

bool SendData(void* netHandle, void* data, unsigned int dataSize) {
	UDPNetBase* handle = static_cast<UDPNetBase*> (netHandle);
	if (handle != 0x00) {


		return handle->SendData(data, dataSize);
	}
	else
	{
		printf("Send Data Failed\n");
	}
	return false;
}

bool SendDataToClient(void * netHandle, void * data, unsigned int dataSize, long cliIp, unsigned int cliPort) {
	UDPNetBase* handle = static_cast<UDPNetBase*> (netHandle);
	if (handle != 0x00) {
		return handle->SendData(cliIp, cliPort, data, dataSize);
	}
	return false;
}

bool SendDataToAll(void * netHandle, void* data, unsigned int dataSize) {
	UDPNetBase* handle = static_cast<UDPNetBase*> (netHandle);
	if (handle != 0x00) {
		return handle->SendDataToAll(data, dataSize);
	}
	return false;
}

bool SendDataToOrtherAll(void* netHandle, void* data, unsigned int dataSize, long srcIP, unsigned int srcPort) {
	UDPNetBase* handle = static_cast<UDPNetBase*> (netHandle);
	if (handle != 0x00) {
		return handle->SendDataToOrtherAll(data, dataSize, srcIP, srcPort);
	}
	return false;
}

bool SetCallFunc(void* netHandle, void* userData, OnDataRecvCallFunc callFunc) {
	UDPNetBase* handle = static_cast<UDPNetBase*> (netHandle);
	if (handle != 0x00) {
		return handle->SetCallFunc(userData, callFunc);
	}
	return false;

}
