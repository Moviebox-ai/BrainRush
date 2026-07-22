plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android { namespace = "com.aaryo.brainrush"; compileSdk = 35
    defaultConfig { applicationId = "com.aaryo.brainrush"; minSdk = 24; targetSdk = 35; versionCode = 1; versionName = "1.0.0"; testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" }
    buildTypes { release { isMinifyEnabled = true; proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro") } }
    buildFeatures { compose = true; buildConfig = true }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.12.01"))
    implementation("androidx.core:core-ktx:1.15.0"); implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7"); implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.compose.ui:ui"); implementation("androidx.compose.ui:ui-tooling-preview"); debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.material3:material3"); implementation("androidx.navigation:navigation-compose:2.8.5")
    implementation("com.google.dagger:hilt-android:2.52"); ksp("com.google.dagger:hilt-compiler:2.52"); implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("androidx.room:room-runtime:2.6.1"); implementation("androidx.room:room-ktx:2.6.1"); ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.datastore:datastore-preferences:1.1.1"); implementation("io.coil-kt:coil-compose:2.7.0"); implementation("com.airbnb.android:lottie-compose:6.6.2")
    implementation(platform("com.google.firebase:firebase-bom:33.7.0")); implementation("com.google.firebase:firebase-auth-ktx"); implementation("com.google.firebase:firebase-firestore-ktx"); implementation("com.google.firebase:firebase-config-ktx"); implementation("com.google.firebase:firebase-crashlytics-ktx"); implementation("com.google.firebase:firebase-analytics-ktx"); implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.android.gms:play-services-ads:23.6.0")
    testImplementation("junit:junit:4.13.2")
}
