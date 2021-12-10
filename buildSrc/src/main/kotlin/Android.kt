import javax.swing.text.NavigationFilter

/**
 * 管理AdnroidX相关依赖
 * https://blog.csdn.net/maguifen2012/article/details/118576742
 */
object Android {

    const val appcompat         = "androidx.appcompat:appcompat:1.3.1"
    const val coreKtx           = "androidx.core:core-ktx:1.6.0"
    const val material          = "com.google.android.material:material:1.4.0"

    const val constraintlayout  = "androidx.constraintlayout:constraintlayout:2.1.0"

    val lifecycle = LifeCycle
    object LifeCycle {
        private const val lifecycle_version = "2.2.0"
        const val liveDataKtx   = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
        const val commonJava8   = "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
        const val viewModelKtx  = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    }

    val navigation = Navigation
    object Navigation {
        private const val nav_version = "2.3.5"
        const val fragmentKtx   = "androidx.navigation:navigation-fragment-ktx:$nav_version"
        const val uiKtx         = "androidx.navigation:navigation-ui-ktx:$nav_version"
    }

}