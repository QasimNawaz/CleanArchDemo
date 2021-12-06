/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

/**
 * To define dependencies
 */
object Deps {
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val annotation by lazy { "androidx.annotation:annotation:${Versions.androidxAnnotations}" }
    val legacySupport by lazy { "androidx.legacy:legacy-support-v4:${Versions.androidxLegacySupport}" }
    val recyclerView by lazy { "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}" }
    val cardView by lazy { "androidx.cardview:cardview:${Versions.cardViewVersion}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gsonVersion}" }
    val fragmentKtx by lazy { "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}" }
    val ktxCore by lazy { "androidx.core:core-ktx:${Versions.ktxCore}" }
    val viewBinding by lazy { "androidx.databinding:viewbinding:${Versions.viewBinding}" }

}

object Coroutines {
    val core by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCoreVersion}" }
    val android by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidVersion}" }
    val playService by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesPlayService}" }
}

object Retrofit {
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}" }
    val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit2Version}" }
    val interceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitInterceptor}" }
}

object Room {
    val runtime by lazy { "androidx.room:room-runtime:${Versions.roomVersion}" }
    val ktx by lazy { "androidx.room:room-ktx:${Versions.roomVersion}" }
    val compiler by lazy { "androidx.room:room-compiler:${Versions.roomVersion}" }
}

object ViewModelLifeCycle {
    val lifeCycleCommonJava by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.lifeCycle}" }
    val lifeCycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}" }
    val lifCycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}" }
    val lifeCycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}" }
}

object Hilt {
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}" }
    val plugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}" }
    val hiltAndroidXCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltAndroidXCompiler}" }
    val hiltNavigationGraph by lazy { "androidx.hilt:hilt-navigation-fragment:${Versions.hiltNavGraph}" }
}

object Glide {
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glideVersion}" }
    val compiler by lazy { "com.github.bumptech.glide:compiler:${Versions.glideCompilerVersion}" }
}

object Testing {
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val extJUnit by lazy { "androidx.test.ext:junit:${Versions.androidxTestVersion}" }
}

object Testing2 {
    val mockitoCore by lazy { "org.mockito:mockito-core:${Versions.mockitoCore}" }
    val mockito by lazy { "org.mockito:mockito-android:${Versions.mockito}" }
    val espresso by lazy { "com.android.support.test.espresso:espresso-core:${Versions.espresso}" }
    val testRunner by lazy { "com.android.support.test:runner:${Versions.testRunner}" }
    val databinding by lazy { "androidx.databinding:databinding-compiler:${Versions.dataBindingCompiler}" }
}

object KotlinAnko {
    val anko by lazy { "org.jetbrains.anko:anko:${Versions.ankoVersion}" }
}

object Shimmer {
    val shimmer by lazy { "com.facebook.shimmer:shimmer:${Versions.shimmer}" }
}

object Paging {
    val paging by lazy { "androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}" }
}

object Navigation {
    val navigationFrg by lazy { "androidx.navigation:navigation-fragment:${Versions.navVersion}" }
    val navigationUI by lazy { "androidx.navigation:navigation-ui:${Versions.navVersion}" }
    val navigationFrgKtx by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}" }
    val navigationUIKtx by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }
    val navigationDynFeature by lazy { "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navVersion}" }
    val navigationSafeArg by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}" }
}

object Timber {
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
}

object Intuit {
    // ssp library for dynamic font
    val ssp by lazy { "com.intuit.ssp:ssp-android:${Versions.intuit}" }

    //sdp library for dynamic size
    val sdp by lazy { "com.intuit.sdp:sdp-android:${Versions.intuit}" }
}

object EasyPermissions {
    val easyPermissions by lazy { "com.vmadalin:easypermissions-ktx:${Versions.easyPermissions}" }
}

object DataStore {
    val dataStore by lazy { "androidx.datastore:datastore-preferences:${Versions.datastore}" }
}

object SplashScreen {
    val splash by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }
}
