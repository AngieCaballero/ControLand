import org.jetbrains.kotlin.cli.jvm.main

plugins {
    kotlin("kapt")
    id("com.google.devtools.ksp")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
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
                "src/main/res/home",
                "src/main/res/task",
                "src/main/res/docs"
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
    //implementation(Deps.kotlinCoroutines)

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
    implementation(Deps.roomRuntime)
    ksp(Deps.roomCompiler)

    /* Glide */
    implementation (Deps.glide)

    testImplementation(Deps.jUnit)
    androidTestImplementation(Deps.jUnitExt)
    androidTestImplementation(Deps.espresso)
    //implementation(kotlin("reflect"))
}

kapt {
    correctErrorTypes = true
}