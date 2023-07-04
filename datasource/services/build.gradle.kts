plugins {
    id(Plugins.Library.dependency)
    id(Plugins.Android.dependency)
}

android {
    namespace = Config.servicesModulePackageName
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        @Suppress("UnstableApiUsage")
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    viewBinding.enable = true
}

dependencies {
    // Basic
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.fragment)
    // Retrofit, i don't use here buildSrc, throw some error faced with retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")
    // OkHttp
    implementation(Dependencies.OkHttp.core)
    // Faker
    implementation(Dependencies.Faker.core)
    // Modules
    implementation(project(":core"))
}