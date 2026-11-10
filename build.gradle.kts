// build.gradle.kts (Project level)
// Declare common plugins for the entire project; "apply false" means only loading the version,
// plugin activation will be done in the app module.
plugins {
    // Android Gradle Plugin
    id("com.android.application") version "8.5.2" apply false
    // Kotlin support plugin for Android
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
    // Google Services Plugin: reads google-services.json and generates Firebase config resources
    id("com.google.gms.google-services") version "4.4.2" apply false
    // KSP (Kotlin Symbol Processing): annotation processor for Glide compiler
    id("com.google.devtools.ksp") version "1.9.24-1.0.20" apply false
}
