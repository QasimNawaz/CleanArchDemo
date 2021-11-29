plugins {
    id("com.android.library")
    kotlin("android")
    id("androidx.navigation.safeargs.kotlin")
//    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}

android {
    compileSdkVersion(ConfigData.compileSdkVersion)

    defaultConfig {
        minSdkVersion(ConfigData.minSdkVersion)
        targetSdkVersion(ConfigData.targetSdkVersion)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // other modules
    implementation(project(":domain-layer"))
    implementation(Deps.kotlin)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)

    // Dependencies for Android Support
    implementation(Deps.annotation)
    implementation(Deps.legacySupport)
    implementation(Deps.recyclerView)
    implementation(Deps.cardView)
    implementation(Deps.ktxCore)
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")


    // Dependencies for Testing
//    testImplementation(Testing.jUnit)
//    androidTestImplementation(Testing.extJUnit)
    testImplementation(Testing.jUnit)
    testImplementation(Testing2.mockitoCore)
    androidTestImplementation(Testing2.testRunner)
    androidTestImplementation(Testing2.mockito)
    androidTestImplementation(Testing2.espresso)
    // Dependencies for Hilt
    implementation(Hilt.hilt)
    implementation(Hilt.hiltNavigationGraph)
    kapt(Hilt.compiler)
    kapt(Hilt.viewModelCompiler)
}