package uz.juo.currerapp.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.juo.currerapp.R
import uz.juo.currerapp.adapter.InnerViewPagerAdapter
import uz.juo.currerapp.databinding.FragmentMyOdersBinding
import uz.juo.currerapp.databinding.TabItemBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyOdersFragment : Fragment() {
    private var param1: String? = null
    lateinit var categoryList: ArrayList<String>
    lateinit var binding: FragmentMyOdersBinding
    private var param2: String? = null
    lateinit var adapter: InnerViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyOdersBinding.inflate(inflater, container, false)
        adapter = InnerViewPagerAdapter(requireActivity())
        binding.viewpager.adapter = adapter
        loadCategory()
        TabLayoutMediator(binding.tab, binding.viewpager) { tab, pos ->
            tab.text = categoryList[pos]
        }.attach()
        setTabs()
        binding.tab.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var customView=tab?.customView
                var item=TabItemBinding.bind(customView!!)
                item.tabTv.setTextColor(Color.parseColor("#2D3A45"))
                item.root.setBackgroundResource(R.drawable.item_tab_backgraund)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var customView=tab?.customView
                var item=TabItemBinding.bind(customView!!)
                item.tabTv.setTextColor(Color.parseColor("#8D9BA8"))
                item.root.setBackgroundResource(R.drawable.item_tab_selected_backgraund)

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        binding.viewpager.isUserInputEnabled=false
        return binding.root
    }

    private fun loadCategory() {
        categoryList = ArrayList()
        categoryList.add("Mening zakazlarim")
        categoryList.add("Tayyor zakazlar")
    }

    private fun setTabs() {
        for (i in 0 until binding.tab.tabCount) {
            var item: TabItemBinding = TabItemBinding.inflate(LayoutInflater.from(requireContext()))
            item.tabTv.text = categoryList[i]
            binding.tab.getTabAt(i)?.customView = item.root
            if (i == 0 ) {
                item.tabTv.setTextColor(Color.parseColor("#2D3A45"))
                item.root.setBackgroundResource(R.drawable.item_tab_backgraund)
            } else {
                item.tabTv.setTextColor(Color.parseColor("#8D9BA8"))
                item.root.setBackgroundResource(R.drawable.item_tab_selected_backgraund)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyOdersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}