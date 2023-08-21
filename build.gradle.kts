// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.gradle)
        classpath(BuildPlugins.kotlinGradle)
        classpath(BuildPlugins.safeargsNav)
    }
}

plugins {
    id("com.android.application") version Versions.androidApplication apply false
    id("com.android.library") version Versions.androidLibrary apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlin apply false
    id("com.google.dagger.hilt.android") version Versions.daggerHilt apply false
}

tasks.register ("clean", Delete::class) {
    delete(rootProject.buildDir)
}