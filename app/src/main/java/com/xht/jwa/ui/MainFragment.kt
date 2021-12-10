package com.xht.jwa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.xht.base_lib.base.BaseVmFragment
import com.xht.base_lib.common.doSelected
import com.xht.base_lib.common.initFragment
import com.xht.jwa.R
import com.xht.jwa.databinding.FragmentMainBinding
import com.xht.jwa.ui.home.HomeFragment
import com.xht.jwa.ui.mine.MineFragment

/**
 * 主页面 ViewPager + Fragment + BottomNavigationView
 */
class MainFragment : BaseVmFragment<FragmentMainBinding>() {
    private val fragmentList = arrayListOf<Fragment>()

    /**
     * 首页
     */
    private val homeFragment by lazy { HomeFragment() }

    /**
     * 广场
     */
    private val squareFragment by lazy { SquareFragment() }

    /**
     * 项目
     */
    private val projectFragment by lazy { TabFragment() }

    /**
     * 公众号
     */
    private val publicNumberFragment by lazy { TabFragment() }

    /**
     * 我的
     */
    private val mineFragment by lazy { MineFragment() }

    init {
        fragmentList.apply {
            add(homeFragment)
            add(projectFragment)
            add(squareFragment)
            add(publicNumberFragment)
            add(mineFragment)
        }
    }

    override fun init(savedInstanceState: Bundle?) {
        binding.vpHome.initFragment(childFragmentManager, fragmentList).run {
            //全部缓存,避免切换回重新加载
            offscreenPageLimit = fragmentList.size
        }
        binding.vpHome.doSelected {
            binding.btnNav.menu.getItem(it).isChecked = true
        }
        //初始化底部导航栏
        binding.btnNav.run {
            setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> {
                        binding.vpHome.setCurrentItem(0, false)
                    }
                    R.id.menu_project -> binding.vpHome.setCurrentItem(1, false)
                    R.id.menu_square -> binding.vpHome.setCurrentItem(2, false)
                    R.id.menu_official_account -> binding.vpHome.setCurrentItem(3, false)
                    R.id.menu_mine -> binding.vpHome.setCurrentItem(4, false)
                }
                // 这里注意返回true,否则点击失效
                true
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_main
}