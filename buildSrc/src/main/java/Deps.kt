object Versions {
    const val build_tools="30.0.3"
    const val min_sdk = 23
    const val target_sdk = 30
    const val compile_sdk = 30
    const val kotlin = "1.4.21"
    const val androidx_test = "1.2.0"
    const val espressoVersion = "3.1.0"
    const val fragment_version = "1.2.5"
    const val androidx_test_ext = "1.1.1"
    const val buildToolsVersion = "29.0.2"
    const val junit = "4.12"
    const val coroutines = "1.3.9-native-mt"
    const val koin = "2.2.2"
    const val lifecycle = "2.2.0"
    const val core_testing = "1.1.1"
    const val glide = "4.11.0"
    const val jetSec = "1.0.0-rc03"
    const val mockk_version = "1.10.5"
    const val retrofit_version = "2.9.0"
    const val gson = "2.8.6"
    const val okhttp_logging = "3.11.0"
    const val room = "2.2.6"
    const val shimmer = "0.5.0"
    const val swipe_refresh = "1.1.0"
    const val dagger_version="2.36"
}

object Deps {
    const val app_compat_x = "androidx.appcompat:appcompat:1.1.0"
    const val material_x = "com.google.android.material:material:1.1.0"
    const val core_ktx = "androidx.core:core-ktx:1.2.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
    const val junit = "junit:junit:${Versions.junit}"
    const val mockk = "io.mockk:mockk:${Versions.mockk_version}"
    const val mockk_android = "io.mockk:mockk-android:${Versions.mockk_version}"

    const val jectSec = "androidx.security:security-crypto:${Versions.jetSec}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipe_refresh}"

    object AndroidXTest {
        const val core = "androidx.test:core:${Versions.androidx_test}"
        const val junit = "androidx.test.ext:junit:${Versions.androidx_test_ext}"
        const val runner = "androidx.test:runner:${Versions.androidx_test}"
        const val rules = "androidx.test:rules:${Versions.androidx_test}"
        const val fragmentTesting =
            "androidx.fragment:fragment-testing:${Versions.fragment_version}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val espressoContrib =
            "androidx.test.espresso:espresso-contrib:${Versions.espressoVersion}"
    }

    object AndroidArch {
        const val lifecycle_viewmodel = "android.arch.lifecycle:viewmodel:${Versions.lifecycle}"
        const val lifecycle_livedata = "android.arch.lifecycle:livedata:${Versions.lifecycle}"
        const val lifecycle_extension = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    }

    object AndroidX {
        const val lifecycle_extensions =
            "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
        const val lifecycle_viewmodel_extensions =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    }

    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        const val core = "android.arch.core:core-testing:${Versions.core_testing}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glide_processor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
        const val retrofit_gson =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    }

    object OkHttp {
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging}"
    }

    object Room {
        const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
        const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
        const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    }

    object Facebook {
        const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
    }

    object Dagger{
        const val dagger = "com.google.dagger:dagger:${Versions.dagger_version}"
        const val compiler ="com.google.dagger:dagger-compiler:${Versions.dagger_version}"
    }
}