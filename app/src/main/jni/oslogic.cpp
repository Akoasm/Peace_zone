#include "oslogic.h"

JNIEXPORT jstring JNICALL Java_com_sails_oslib_MainActivity_HelloWorld(JNIEnv* env,jobject obj)
{
	LOGD("Call the C ++");
	return env->NewStringUTF( "Hello from JNI !  Compiled with ABI .");
}

