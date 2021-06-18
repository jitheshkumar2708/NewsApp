plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Versions.compile_sdk)
    buildToolsVersion(Versions.build_tools)

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId("com.assignment.mvvm")
        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)
        versionCode(1)
        versionName("1.0")

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("debug") {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://newsapi.org/\"")
            buildConfigField("String", "API_KEY", "\"98d68aa739bb44f7a60bc8d7c3355aaf\"")
        }

        getByName("release") {
            minifyEnabled(true)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://newsapi.org/\"")
            buildConfigField("String", "API_KEY", "\"98d68aa739bb44f7a60bc8d7c3355aaf\"")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Deps.core_ktx)
    implementation(Deps.app_compat_x)
    implementation(Deps.material_x)
    implementation(Deps.constraintlayout)
    implementation(Deps.app_compat_x)
    implementation(Deps.recyclerView)
    implementation(Deps.material_x)
    implementation(Deps.app_compat_x)
    implementation(Deps.core_ktx)
    implementation(Deps.constraintlayout)

    // Dagger
    implementation(Deps.Dagger.dagger)
    kapt (Deps.Dagger.compiler)

    // Glide
    implementation(Deps.Glide.glide)
    annotationProcessor(Deps.Glide.glide_processor)

    implementation(Deps.jectSec)
    implementation(Deps.Coroutines.core)
    implementation(Deps.Coroutines.android)
    implementation(Deps.Coroutines.common)

    implementation(Deps.AndroidX.lifecycle_viewmodel_extensions)
    implementation(Deps.AndroidX.lifecycle_extensions)

    implementation(Deps.AndroidArch.lifecycle_extension)
    implementation(Deps.AndroidArch.lifecycle_livedata)
    implementation(Deps.AndroidArch.lifecycle_viewmodel)
    implementation(Deps.Facebook.shimmer)
    implementation(Deps.swipeRefresh)

    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.retrofit_gson)
    implementation(Deps.gson)
    implementation(Deps.Coroutines.common)
    implementation(Deps.OkHttp.logging)
    implementation(Deps.Room.room_runtime)
    implementation(Deps.Room.room_ktx)
    implementation(Deps.AndroidArch.lifecycle_livedata)

    kapt(Deps.Room.room_compiler)

    testImplementation(Deps.junit)
    testImplementation(Deps.AndroidXTest.core)
    testImplementation(Deps.Coroutines.test)
    testImplementation(Deps.AndroidXTest.fragmentTesting)
    testImplementation(Deps.AndroidXTest.junit)
    testImplementation(Deps.AndroidXTest.runner)
    testImplementation(Deps.mockk)

    testImplementation(Deps.junit)
    testImplementation(Deps.mockk)

    androidTestImplementation(Deps.AndroidXTest.core)
    androidTestImplementation(Deps.AndroidXTest.junit)
    androidTestImplementation(Deps.AndroidXTest.runner)
    androidTestImplementation(Deps.AndroidXTest.espresso)
    androidTestImplementation(Deps.AndroidXTest.espressoContrib)
    androidTestImplementation(Deps.junit)
    androidTestImplementation(Deps.mockk_android)
}