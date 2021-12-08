// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("kotlinVersion", "1.5.0")
    }
    val supportLibraryVersion = extra.get("kotlinVersion") as String

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
        classpath(Hilt.plugin)
        classpath(Navigation.navigationSafeArg)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}