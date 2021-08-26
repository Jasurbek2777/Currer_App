package uz.juo.currerapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.juo.currerapp.ui.fragments.AllOrderFragment
import uz.juo.currerapp.ui.fragments.MyOdersFragment
import uz.juo.currerapp.ui.fragments.UserProfileFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> {
                AllOrderFragment.newInstance(position.toString(), "")
            }
            1 -> {
                MyOdersFragment.newInstance(position.toString(), "")
            }
            2 -> {
                UserProfileFragment.newInstance(position.toString(), "")
            }
            else -> {
                MyOdersFragment.newInstance(position.toString(), "")
            }
        }


}