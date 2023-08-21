import org.jetbrains.kotlin.cli.jvm.main

plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.controlandandroid"
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        applicationId = "com.example.controlandandroid"
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets.getByName("main") {
        res.srcDirs(
            listOf(
                "src/main/res/task"
            )
        )
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding {
            enable = true
        }
    }
}

dependencies {

    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)

    /* View */
    implementation(Deps.material)
    implementation(Deps.material3)
    implementation(Deps.constraintLayout)

    /* Lifecycle */
    implementation(Deps.lifecycleViewModel)
    implementation(Deps.lifecycleLiveData)

    /* Coroutines */
    implementation(Deps.kotlinCoroutines)

    /* Fragment */
    implementation(Deps.fragment)
    implementation(Deps.navigationFragment)
    implementation(Deps.navigation)

    /* Dagger hilt */
    implementation(Deps.daggerHilt)
    kapt(Deps.daggerHiltCompiler)

    /* Retrofit */
    implementation(Deps.retrofit)
    implementation(Deps.converterGson)

    /* Room */
    implementation(Deps.room)
    kapt(Deps.roomCompiler)

    testImplementation(Deps.jUnit)
    androidTestImplementation(Deps.jUnitExt)
    androidTestImplementation(Deps.espresso)
}

kapt {
    correctErrorTypes = true
}