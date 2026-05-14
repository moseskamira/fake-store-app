plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.pay.productsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pay.productsapp"
        minSdk = 24
        //noinspection OldTargetApi
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Gson
    implementation(libs.converter.gson)
    implementation(libs.androidx.runtime.livedata)
//    kapt(libs.glide.compiler)

    // Testing
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
}

//dependencies {
//
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//    //Retrofit
//    implementation(libs.retrofit)
//    implementation(libs.converter.gson)
//
//    // OkHttp
//    implementation(libs.okhttp)
//    implementation(libs.logging.interceptor)
//
//
//    implementation (libs.androidx.constraintlayout)
//    implementation (libs.androidx.recyclerview)
//
//
//
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//
//    implementation(platform(libs.androidx.compose.bom))
//
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//
//    implementation(libs.androidx.material3)
//
//    // Retrofit
//    implementation(libs.retrofit)
//    implementation(libs.converter.gson)
//
//    // OkHttp
//    implementation(libs.okhttp)
//    implementation(libs.logging.interceptor)
//
//    // Gson
//    implementation(libs.gson)
//
//    // Glide
//    implementation(libs.glide)
//    kapt(libs.glide.compiler)
//
//    // Testing
//    testImplementation(libs.junit)
//
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//
//    debugImplementation(libs.androidx.ui.tooling)
//
//
//
////    implementation (libs.material)
////    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
////    implementation "org.jetbrains.kotlin:kotlin-stdlib:1.9.23"
////    implementation 'com.squareup.retrofit2:retrofit:2.4.0'
////    implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
////    implementation 'com.github.bumptech.glide:glide:4.9.0'
////    implementation 'com.github.bumptech.glide:glide:4.15.1'
////    kapt 'com.github.bumptech.glide:compiler:4.15.1'
////    implementation 'de.hdodenhof:circleimageview:3.0.0'
////    implementation 'com.google.code.gson:gson:2.12.0'
////    testImplementation 'junit:junit:4.13.2'
////    testImplementation 'org.mockito:mockito-core:4.11.0'
////    testImplementation 'org.powermock:powermock-module-junit4:2.0.9'
////    testImplementation 'org.powermock:powermock-api-mockito2:2.0.9'
////    androidTestImplementation 'androidx.test:runner:1.7.0'
////    androidTestImplementation 'androidx.test:rules:1.7.0'
////    androidTestImplementation 'androidx.test.espresso:espresso-core:3.7.0'
////    androidTestImplementation 'androidx.test.espresso:espresso-intents:3.7.0'
////    androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.7.0'
////    androidTestImplementation 'androidx.test.espresso:espresso-idling-resource:3.7.0'
////    androidTestImplementation 'androidx.test.uiautomator:uiautomator:2.3.0'
//}