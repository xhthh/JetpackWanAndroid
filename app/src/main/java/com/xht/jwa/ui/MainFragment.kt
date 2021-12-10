package com.xht.jwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.xht.base_lib.base.BaseVmFragment
import com.xht.jwa.R
import com.xht.jwa.databinding.FragmentMainBinding

/**
 * 主页面 ViewPager + Fragment + BottomNavigationView
 */
class MainFragment:BaseVmFragment<FragmentMainBinding>() {
    private val fragmentList = arrayListOf<Fragment>()

    override fun init(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int = R.layout.fragment_main
}