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

-dontwarn com.amazonaws.mobile.auth.**
-dontwarn com.clevertap.android.**
-dontwarn com.google.android.exoplayer2.**
-dontwarn okhttp3.internal.platform.**
-keepattributes LineNumberTable,SourceFile
-renamesourcefileattribute SourceFile
#-keep class com.google.gson.annotations.*


#-keep class * extends com.google.protobuf.GeneratedMessageLite { *; }
#-keep class com.google.gson.reflect.TypeToken
#-keep class * extends com.google.gson.reflect.TypeToken
-keep public class * implements java.lang.reflect.Type
# -keep,allowobfuscation,allowshrinking interface retrofit2.Call
# -keep,allowobfuscation,allowshrinking class retrofit2.Response
 -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

-if class *
-keepclasseswithmembers class <1> {
  <init>(...);
  #@com.google.gson.annotations.SerializedName <fields>;
}


-keepclassmembers,allowobfuscation class * {
 # @com.google.gson.annotations.SerializedName <fields>;
}
#--------------------------------fix problemnav
-keep class androidx.navigation.fragment.NavHostFragment
-keepnames class * extends android.os.Parcelable
-keepnames class * extends java.io.Serializable