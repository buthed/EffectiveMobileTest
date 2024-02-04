object Version {
    const val core = "1.10.1"
    const val kotlinBomPlatform = "1.8.0"
    const val appCompat = "1.6.1"
    const val androidMaterial = "1.11.0"

    const val lifecycleRuntime = "2.6.1"

    // Jetpack Compose
    const val composeActivity = "1.7.2"
    const val composeMaterial = "1.5.4"
    const val composeNavigation = "2.6.0"
    const val composeBomPlatform = "2023.08.00"

    // Hilt
    const val hiltAndroid = "2.44.2"
    const val hiltCompiler = "2.44.2"
    const val hiltNavigationCompose = "1.0.0"

    // Retrofit
    const val retrofit2 = "2.9.0"
    const val retrofit2Converter = "2.9.0"

    // Room
    const val room = "2.6.1"

    // Google accompanist
    const val pager = "0.20.0"

    // Tests
    const val testJunit = "4.13.2"
    const val junit = "1.1.5"
    const val espresso = "3.5.1"
}

object Deps {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val kotlinBomPlatform = "org.jetbrains.kotlin:kotlin-bom:${Version.kotlinBomPlatform}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
}

object LifecycleScope {
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntime}"
}

object JetpackCompose {
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial = "androidx.compose.material:material:${Version.composeMaterial}"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Version.composeNavigation}"
    const val composeBomPlatform = "androidx.compose:compose-bom:${Version.composeBomPlatform}"
}

object DaggerHilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hiltAndroid}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.hiltCompiler}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Version.hiltNavigationCompose}"
}

object Retrofit2 {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Version.retrofit2}"
    const val retrofit2Converter = "com.squareup.retrofit2:converter-gson:${Version.retrofit2Converter}"
}

object Room {
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
}

object GoogleAccompanist {
    const val pager = "com.google.accompanist:accompanist-pager:${Version.pager}"
}

object TestImplementation {
    const val junit = "junit:junit:${Version.testJunit}"
}

object AndroidTestImplementation {
    const val junit =  "androidx.test.ext:junit:${Version.junit}"
    const val espresso =  "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val junit4 =  "androidx.compose.ui:ui-test-junit4"
}

object DebugImplementation {
    const val toolingUi = "androidx.compose.ui:ui-tooling"
    const val manifestTest = "androidx.compose.ui:ui-test-manifest"
}