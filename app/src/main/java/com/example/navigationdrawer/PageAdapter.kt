package com.example.navigationdrawer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
/*import com.example.navbar.FirstFragment*/
/*import com.example.navbar.SecondFragment*/
/*import com.example.navbar.ThirdFragment*/

class PageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return FirstFragment()
            }
            1 -> {
                return SecondFragment()
            }
            2 -> {
                return FirstFragment()
            }
            else -> {
                return FirstFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }
            2 -> {
                return "Tab 3"
            }
        }
        return super.getPageTitle(position)
    }

}