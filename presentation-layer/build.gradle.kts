plugins {
    id("com.android.library")
    kotlin("android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
//        versionCode = ConfigData.versionCode
//        versionName = ConfigData.versionName
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // other modules
    implementation(project(":domain-layer"))
    implementation(project(":data-layer"))
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
    implementation(Deps.viewBinding)

    // Dependencies for Testing
    testImplementation(Testing.jUnit)
    androidTestImplementation(Testing.extJUnit)
//    testImplementation(Testing.jUnit)
//    testImplementation(Testing2.mockitoCore)
//    androidTestImplementation(Testing2.testRunner)
//    androidTestImplementation(Testing2.mockito)
//    androidTestImplementation(Testing2.espresso)
//    kaptTest(Testing2.databinding)

    // Dependencies for Hilt
    implementation(Hilt.hilt)
    implementation(Hilt.hiltNavigationGraph)
    kapt(Hilt.hiltCompiler)
    kapt(Hilt.hiltAndroidXCompiler)

    //Navigation component
    implementation(Navigation.navigationFrg)
    implementation(Navigation.navigationUI)
    implementation(Navigation.navigationFrgKtx)
    implementation(Navigation.navigationUIKtx)
    implementation(Navigation.navigationDynFeature)

    implementation(SplashScreen.splash)

    // Anko
    implementation(KotlinAnko.anko)

    // Ktx
    implementation(Deps.fragmentKtx)

    //ViewModel and LifeCycle
    implementation(ViewModelLifeCycle.lifeCycleCommonJava)
    implementation(ViewModelLifeCycle.lifCycleViewModel)
    implementation(ViewModelLifeCycle.lifeCycleLiveData)
    implementation(ViewModelLifeCycle.lifeCycleRuntime)

    //Intuit
    implementation(Intuit.sdp)
    implementation(Intuit.ssp)

//    implementation("com.algolia:instantsearch-androidx:1.14.0")
}