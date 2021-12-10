package com.xht.jwa

import android.os.Bundle
import com.xht.base_wa_lib.base.BaseLoadingActivity

/**
 * 主页面
 *      1.用于承载Fragment
 */
class MainActivity : BaseLoadingActivity() {

    override fun init2(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}