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

#define TAG "sails-log" // ������Զ����LOG�ı�ʶ
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__) // ����LOGD����
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__) // ����LOGI����
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,TAG ,__VA_ARGS__) // ����LOGW����
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // ����LOGE����
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,TAG ,__VA_ARGS__) // ����LOGF����
#ifdef __cplusplus
extern "C"
{
#endif

	/*
	 * ��ʹ��˵����
	 * 1������NetInterFace�����ͻ��ˡ�
	 * CreateClient(�����IP,����˿��Ŷ˿�)
	 * 2�����÷��ػص�������
	 * SetCallFunc(�ص��ĺ���,CreateClient���صľ��)
	 * 3��������Ϣ����
	 * SendDataϵ�к���
	 * 4��������Ϻ��ͷž��
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
