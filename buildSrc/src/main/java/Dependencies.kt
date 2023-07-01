object Dependencies {

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.10.0"
        const val appCompat = "androidx.appcompat:appcompat:1.6.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val material = "com.google.android.material:material:1.9.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.5.7"
    }

    object Navigation {
        private const val version = "2.5.3"

        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:2.9.0"
        const val converter = "com.squareup.retrofit:converter-gson:2.9.0"
        const val coreAdapter = "com.squareup.retrofit:adapter-rxjava:2.0.0"
        const val rxJavaAdapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0"
    }

    object OkHttp {
        const val core = "com.squareup.okhttp3:logging-interceptor:4.10.0"
    }

    object PhoneInputText {
        const val core = "com.fredporciuncula:phonemoji:1.5.2"
    }

    object UnitTesting {
        object JUnit {
            const val core = "junit:junit:4.13.2"
        }

        object KotlinX {
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1"
        }
    }

    object AndroidTesting {
        object JUnit {
            const val core = "junit:junit:4.13.2"
            const val ui = "androidx.test.ext:junit:1.1.5"
        }

        object Espresso {
            const val core = "androidx.test.espresso:espresso-core:3.5.1"
        }

        object AndroidX {
            const val core = "androidx.test:core-ktx:1.5.0"
        }

        object Barista {
            const val core = "com.adevinta.android:barista:4.2.0"
        }
    }
}