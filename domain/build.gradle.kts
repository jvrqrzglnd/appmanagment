plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ksp)
    //kotlin("jvm") version "2.0.20" // or kotlin("multiplatform") or any other kotlin plugin
    kotlin("plugin.serialization") version "2.0.20"
    //id("kotlinx-serialization")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    //implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.javax.inject)
    //implementation(libs.kotlinx.serialization.json.v151)
    implementation(libs.kotlinx.serialization.json.v173)
}