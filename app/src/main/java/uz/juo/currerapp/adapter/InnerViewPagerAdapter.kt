package uz.juo.currerapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.juo.currerapp.ui.fragments.InnerRvFragment
import uz.juo.currerapp.ui.fragments.ReadyOrdersFragment

class InnerViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 1    ) {
            InnerRvFragment()
        } else {
            ReadyOrdersFragment()
        }
    }
}