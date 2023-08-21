object BuildPlugins {
    val gradle by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlinGradle by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val safeargsNav by lazy { "androidx.navigation.safeargs:androidx.navigation.safeargs.gradle.plugin:${Versions.navigation}" }
}

object Deps {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }

    /* View */
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val material3 by lazy { "androidx.compose.material3:material3:${Versions.material3}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }

    /* Lifecycle */
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val lifecycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }

    /* Coroutines */
    val kotlinCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutine}" }

    /* Fragment */
    val fragment by lazy { "androidx.fragment:fragment-ktx:${Versions.fragment}" }
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
    val navigation by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }

    /* Dagger hilt */
    val daggerHilt by lazy { "com.google.dagger:hilt-android:${Versions.daggerHilt}" }
    val daggerHiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}" }

    /* Retrofit */
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }

    /* Room */
    val room by lazy { "androidx.room:room-ktx:${Versions.room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }

    /* testing */
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val jUnitExt by lazy { "androidx.test.ext:junit:${Versions.jUnitExt}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
}