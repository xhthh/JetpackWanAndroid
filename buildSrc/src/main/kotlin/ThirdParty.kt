/**
 * 管理第三方库依赖
 */
object ThirdParty {

    const val aviUi = "com.wang.avi:library:2.1.3"

    const val okhttp = "com.squareup.okhttp3:okhttp:4.9.0"
    const val rxjava = "io.reactivex.rxjava2:rxjava:2.2.14"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"

    const val cookieJar = "com.github.franmontiel:PersistentCookieJar:v1.0.1"


    val retrofit = Retrofit
    object Retrofit {
        private const val retrofit_version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
        const val scalars = "com.squareup.retrofit2:converter-scalars:$retrofit_version"
        const val gson = "com.squareup.retrofit2:converter-gson:$retrofit_version"
    }
}