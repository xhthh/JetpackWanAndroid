package com.xht.jwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.xht.base_lib.base.BaseVmFragment
import com.xht.jwa.R
import com.xht.jwa.databinding.FragmentMainBinding
import com.xht.jwa.databinding.FragmentSquareBinding

/**
 * 广场
 */
class SquareFragment:BaseVmFragment<FragmentSquareBinding>() {
    private val fragmentList = arrayListOf<Fragment>()

    override fun init(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int = R.layout.fragment_square
}