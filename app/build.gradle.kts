// app/build.gradle.kts (App level)
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Activate Google Services Plugin to process google-services.json
    id("com.google.gms.google-services")
    // Activate KSP to run Glide annotation processor
    id("com.google.devtools.ksp")
}

android {
    namespace = "vn.edu.vlu.lab10"
    compileSdk = 34

    defaultConfig {
        applicationId = "vn.edu.vlu.lab10"   // MUST match the Package name registered on Firebase
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    // ENABLE View Binding: generates ActivityAuthBinding, ActivityMainBinding, ItemPhotoBinding...
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // --- AndroidX & Material Design 3 ---
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")

    // --- Firebase: BoM manages Firebase library version synchronization ---
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    // When using BoM, DO NOT write the version number for firebase-auth-ktx
    implementation("com.google.firebase:firebase-auth-ktx")

    // --- Coroutines: use await() for Firebase Tasks (optional) ---
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // --- Glide: asynchronous image loading and caching ---
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // Glide annotation compiler, run by KSP
    ksp("com.github.bumptech.glide:ksp:4.16.0")

    // --- Test ---
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
