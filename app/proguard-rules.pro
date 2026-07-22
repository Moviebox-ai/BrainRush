# BrainRush ProGuard / R8 rules

-keep class com.aaryo.brainrush.** { *; }
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.firebase.**
-dontwarn com.google.android.gms.**

# Hilt
-keep class dagger.hilt.** { *; }
-keep @dagger.hilt.android.HiltAndroidApp class * { *; }
-keep @dagger.hilt.android.AndroidEntryPoint class * { *; }

# Room
-keep class * extends androidx.room.RoomDatabase { *; }
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao interface * { *; }

# Kotlin coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}

# Compose
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# Lottie
-keep class com.airbnb.lottie.** { *; }

# Coil
-keep class coil.** { *; }

# AdMob
-keep public class com.google.android.gms.ads.** { public *; }

# Crash reporting: keep line numbers for stack traces
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception
