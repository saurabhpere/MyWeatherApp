#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_myweatherapp_resource_Keys_apiKey(JNIEnv *env, jobject thiz) {
    std::string api_key = "place your key here";
    return env->NewStringUTF(api_key.c_str());
}