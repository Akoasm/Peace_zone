/*
 * oslogic.h
 *
 *  Created on: 2016-9-5
 *      Author: sails
 */

#ifndef OSLOGIC_H_
#define OSLOGIC_H_


#include <jni.h>
#include <android/log.h>
#include "NetInterface.h"

#define TAG "sails-log" // 这个是自定义的LOG的标识
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__) // 定义LOGD类型
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__) // 定义LOGI类型
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,TAG ,__VA_ARGS__) // 定义LOGW类型
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // 定义LOGE类型
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,TAG ,__VA_ARGS__) // 定义LOGF类型
#ifdef __cplusplus
extern "C"
{
#endif

	/*
	 * 库使用说明。
	 * 1、根据NetInterFace创建客户端。
	 * CreateClient(服务端IP,服务端开放端口)
	 * 2、设置返回回调函数。
	 * SetCallFunc(回调的函数,CreateClient返回的句柄)
	 * 3、发送消息命令
	 * SendData系列函数
	 * 4、处理完毕后释放句柄
	 * FreeNet
	 *
	 *
	 *
	 *
	 * */


	JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved)
	{
		LOGD("JNI_OnLoad Call");
		return JNI_VERSION_1_4;
	}

	JNIEXPORT jstring JNICALL Java_com_sails_oslib_MainActivity_HelloWorld(JNIEnv* env,jobject obj);

#ifdef __cplusplus
}
#endif

#endif /* OSLOGIC_H_ */
