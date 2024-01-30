#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_myweatherapp_resource_Keys_apiKey(JNIEnv *env, jobject thiz) {
    std::string api_key = "MTE4MDQ2ZWQyM2QzOTE3ZmI4NjYyOGMwZTQ3YzdhODU=";
    return env->NewStringUTF(api_key.c_str());
}