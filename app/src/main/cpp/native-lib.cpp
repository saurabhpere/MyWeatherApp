#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_myweatherapp_resource_Keys_apiKey(JNIEnv *env, jobject thiz) {
    std::string api_key = "Place your api key";
    return env->NewStringUTF(api_key.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_myweatherapp_resource_Constants_getBaseUrl(JNIEnv *env, jobject thiz) {
    std::string api_key = "https://api.openweathermap.org/data/2.5/";
    return env->NewStringUTF(api_key.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_myweatherapp_resource_Constants_getImageUrl(JNIEnv *env, jobject thiz) {
    std::string api_key = "https://openweathermap.org/img/wn/";
    return env->NewStringUTF(api_key.c_str());
}