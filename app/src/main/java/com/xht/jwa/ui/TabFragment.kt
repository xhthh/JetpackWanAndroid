package com.xht.jwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.xht.base_lib.base.BaseVmFragment
import com.xht.jwa.R
import com.xht.jwa.databinding.FragmentTabBinding

/**
 * 项目/公众号
 */
class TabFragment : BaseVmFragment<FragmentTabBinding>() {
    private val fragmentList = arrayListOf<Fragment>()

    override fun init(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int = R.layout.fragment_tab
}