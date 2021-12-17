/**
 * 管理第三方库依赖
 */
object ThirdParty {

    const val aviUi = "com.wang.avi:library:2.1.3"

    const val okhttp = "com.squareup.okhttp3:okhttp:4.9.0"
    const val rxjava = "io.reactivex.rxjava2:rxjava:2.2.14"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"

    const val cookieJar = "com.github.franmontiel:PersistentCookieJar:v1.0.1"
    const val baseQuickAdapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.50"


    const val banner = "cn.bingoogolapple:bga-banner:2.2.7"

    val glide = Glide
    object Glide {
        const val glide = "com.github.bumptech.glide:glide:4.11.0"
        const val transformations = "jp.wasabeef:glide-transformations:4.1.0"
    }

    val smart = Smart
    object Smart {
        private const val smart_version = "1.1.2"
        const val smart = "com.scwang.smartrefresh:SmartRefreshLayout:$smart_version"
        const val head = "com.scwang.smartrefresh:SmartRefreshHeader:$smart_version"
    }

    val retrofit = Retrofit
    object Retrofit {
        private const val retrofit_version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
        const val scalars = "com.squareup.retrofit2:converter-scalars:$retrofit_version"
        const val gson = "com.squareup.retrofit2:converter-gson:$retrofit_version"
    }
}