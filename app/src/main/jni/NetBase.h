#pragma once
#include "raknet/RakPeerInterface.h"
#include "raknet/RakNetworkFactory.h"
#include <string>
#include <pthread.h>
#include "NetInterface.h"

namespace sails {

	class OSLock {
	public:
		OSLock();
		virtual ~OSLock();
		int Lock();
		int TryLock();
		int UnLock();

	private:
		pthread_mutex_t mutex;
	};

	class AutoLock {
	public:
		AutoLock(OSLock* lock);
		virtual ~AutoLock();
	private:
		OSLock* lock;
		bool isLock;

	};
}

class UDPNetBase {
private:
	//缁戝畾绔彛
	unsigned int bindPort;
	//杩炴帴鐨勬湇鍔″櫒绔彛
	unsigned int svrPort;
	//鏄惁杩炴帴鍒版湇鍔＄銆傛垨鑰呭凡鍚姩鏈嶅姟
	bool IsConnectedServer;
	std::string svrIP;
	RakPeerInterface *netInterface;
	pthread_t recvDataThread;
	bool threadIsExit;
	sails::OSLock* lock;
	void* userData;
	OnDataRecvCallFunc callFunc;
public:
	UDPNetBase();
	~UDPNetBase();

public:
	bool InitNet(unsigned int bindPort, int MaxConnectCount = 1);
	bool InitNet(std::string svrIP, unsigned int svrPort);
	bool SendData(void* dataBuf, unsigned int dataSize);
	bool SendDataToAll(void* dataBuf, unsigned int dataSize);
	bool SendData(long svrIp, unsigned int svrPort, void* dataBuf, unsigned int dataSize);
	//鍙戦�佹暟鎹粰闄や簡褰撳墠婧愬鎴风浠ュ鐨勬墍鏈夊鎴风
	bool SendDataToOrtherAll(void* data, unsigned int dataSize, long srcIP, unsigned int srcPort);
	void FreeNet();
	void RecvData();
	//璁剧疆鍥炶皟鍑芥暟
	bool SetCallFunc(void* userData, OnDataRecvCallFunc callFunc);

protected:
private:
};
