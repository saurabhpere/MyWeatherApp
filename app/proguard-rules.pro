# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep class com.myweatherapp.resource.** { *; }
-keep class com.myweatherapp.data.** { *; }
-keep class com.myweatherapp.data.request.CurrentWeatherRequest { *; }

# Retrofit
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response

 # With R8 full mode generic signatures are stripped for classes that are not
 # kept. Suspend functions are wrapped in continuations where the type argument
 # is used.
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# Gson
-keepattributes Signature
-keepattributes Exceptions
-keepattributes InnerClasses
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

-keep class androidx.lifecycle.LiveData { *; }
# OkHttp
-keep class okhttp3.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**

# OkHttp Logging Interceptor
-keep class okhttp3.logging.** { *; }
#------------  Sqlcipher------------
# SQLCipher
-keep class net.sqlcipher.** {
    *;
}

# SQLite
-keep class androidx.sqlite.** {
    *;
}

# Keep SQLite Custom Functions (modify as needed)
-keep class net.zetetic.database.sqlcipher.** {
    *;
}

# Google Play Services Location
-keep class com.google.android.gms.** { *; }
-keep interface com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**

# Keep Hilt generated code
-keep class dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories { *; }
-keep class dagger.hilt.android.internal.testing.TestApplicationComponentManager { *; }
-keep class dagger.hilt.android.testing.BindValueComponentManager { *; }
-keep class dagger.hilt.android.testing.HiltTestApplication { *; }

# Keep classes annotated with @HiltAndroidApp
-keep class your.package.name.HiltApplication { *; }

# Keep generated Hilt components
-keep class dagger.hilt.android.** { *; }
-keep class * implements dagger.hilt.android.components.ApplicationComponent { *; }
-keep class * implements dagger.hilt.android.components.ActivityComponent { *; }
-keep class * implements dagger.hilt.android.components.FragmentComponent { *; }

# Keep classes annotated with @EntryPoint
-keep class your.package.name.*EntryPoint { *; }

# Keep generated Hilt component interfaces
-keep,allowobfuscation interface * extends dagger.hilt.android.components.ApplicationComponent
-keep,allowobfuscation interface * extends dagger.hilt.android.components.ActivityComponent
-keep,allowobfuscation interface * extends dagger.hilt.android.components.FragmentComponent

# Keep Hilt component methods
-keepclassmembers,allowobfuscation class * {
    @dagger.hilt.android.scopes.ActivityScoped *;
    @dagger.hilt.android.scopes.FragmentScoped *;
    @dagger.hilt.android.scopes.ViewModelScoped *;
}

# Keep Hilt generated factory classes
-keepclassmembers,allowobfuscation class * {
    @dagger.hilt.android.internal.lifecycle.*Factory *;
}

# Coil-Compose library
-keep class androidx.coil.compose.** { *; }

