plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK_VERSION)
    buildToolsVersion = Versions.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = "com.supremehyo.multitest"
        minSdkVersion(Versions.MIN_SDK_VERSION)
        targetSdkVersion(Versions.TARGET_SDK_VERSION)
        vectorDrawables.useSupportLibrary = true
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation (Kotlin.KOTLIN_STDLIB)

    implementation (AndroidX.CORE_KTX)
    implementation (AndroidX.APP_COMPAT)

    implementation (Google.MATERIAL)

    testImplementation (UnitTest.JUNIT)

    androidTestImplementation (AndroidTest.ANDROID_JUNIT)
    androidTestImplementation (AndroidTest.ESPRESSO_CORE)

    //멀티모듈 관리
    implementation(project(":ui"))
}