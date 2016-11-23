#pragma once
#include <string.h>
#include <cstdlib>
//数据回调函数指针
#ifdef _WIN32
typedef  void(_stdcall *OnDataRecvCallFunc)(char* dataBuf, unsigned int dataSize, long srcIP, unsigned int srcPort, char dataType, void* sender, void* handle);
#else
typedef  void(*OnDataRecvCallFunc)(char* dataBuf, unsigned int dataSize, long srcIP, unsigned int srcPort, char dataType, void* sender, void* handle);
#endif
extern "C"
{
#ifdef _WIN32
#define LIB_OSNET_API __declspec(dllexport)
	//创建�?个UDP服务接口
	LIB_OSNET_API void* CreateServer(unsigned int bindPort, int MaxConnectCount);
	//创建�?个UDP客户端接
	LIB_OSNET_API void* CreateClient(const char* svrIp, unsigned int svrPort);
	//释放接口
	LIB_OSNET_API void FreeNet(void* netHandle);
	//发�?�数据�?�发送数据给服务
	LIB_OSNET_API bool SendData(void* netHandle, void* data, unsigned int dataSize);
	//发�?�数据，发�?�给指定的客户端
	LIB_OSNET_API bool SendDataToClient(void* netHandle, void* data, unsigned int dataSize, long cliIp, unsigned int cliPort);
	//发�?�数据给�?有客户端
	LIB_OSNET_API bool SendDataToAll(void* netHandle, void* data, unsigned int dataSize);
	//定义数据接收函数
	LIB_OSNET_API bool SetCallFunc(void* netHandle, void* userData, OnDataRecvCallFunc callFunc);
	//发�?�数据给除了当前源客户端以外的所有客户端
	LIB_OSNET_API bool SendDataToOrtherAll(void* netHandle, void* data, unsigned int dataSize, long srcIP, unsigned int srcPort);


	LIB_OSNET_API void TestString(const char* Str);

	//GBK转UTF8
	LIB_OSNET_API const char* GbkToUtf8(const char* value);
	//UTF8转GBK
	LIB_OSNET_API const char* Utf8ToGBK(const char* value);


	LIB_OSNET_API void TestContent(void* data, int size);

#else
	//创建�?个UDP服务接口
	void* CreateServer(unsigned int bindPort,int MaxConnectCount = 1);
	//创建�?个UDP客户端接口

	void* CreateClient(const char* svrIp, unsigned int svrPort);
	//释放接口
	void FreeNet(void* netHandle);
	//发送数据给服务器
	bool SendData(void* netHandle,void* data, unsigned int dataSize);
	//发送数据给指定的客户端
	bool SendDataToClient(void* netHandle, void* data, unsigned int dataSize, long srcIP, unsigned int cliPort);
	//发送数据给所有客户端
	bool SendDataToAll(void* netHandle, void* data, unsigned int dataSize);
	//发送数据给除了当前源客户端以外的所有客户端
	bool SendDataToOrtherAll(void* netHandle, void* data, unsigned int dataSize,long srcIP,unsigned int srcPort);
	//设置数据回调函数
	bool SetCallFunc(void* netHandle,void* userData,OnDataRecvCallFunc callFunc);


#endif
}


