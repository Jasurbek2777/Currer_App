package uz.juo.currerapp.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationBarView
import uz.juo.currerapp.R
import uz.juo.currerapp.adapter.ViewPagerAdapter
import uz.juo.currerapp.databinding.FragmentHomeBinding
import androidx.recyclerview.widget.ItemTouchHelper

import androidx.recyclerview.widget.RecyclerView
import uz.juo.currerapp.databinding.TabItemBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    lateinit var adapter: ViewPagerAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        adapter = ViewPagerAdapter(requireActivity())
        _binding!!.viewpager.adapter = adapter
        binding.bottomNavigationView2.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.all -> {
                    binding.bottomNavigationView2.menu.findItem(R.id.all).isChecked = true
                    binding.bottomNavigationView2.menu.findItem(R.id.all)
                        .setIcon(R.drawable.ic_curier_home_selected)
                    binding.bottomNavigationView2.menu.findItem(R.id.mine)
                        .setIcon(R.drawable.ic_image_curier)
                    binding.viewpager.currentItem = 0
                }
                R.id.mine -> {
                    binding.bottomNavigationView2.menu.findItem(R.id.mine).isChecked = true
                    binding.bottomNavigationView2.menu.findItem(R.id.all)
                        .setIcon(R.drawable.ic_curier_home)
                    binding.bottomNavigationView2.menu.findItem(R.id.mine)
                        .setIcon(R.drawable.ic_curier_list)
                    binding.viewpager.currentItem = 1
                }
                R.id.profil -> {
                    findNavController().navigate(R.id.userProfileFragment)
                    binding.bottomNavigationView2.menu.findItem(R.id.all).isChecked = true
                    binding.bottomNavigationView2.menu.findItem(R.id.all)
                        .setIcon(R.drawable.ic_curier_home_selected)
                    binding.bottomNavigationView2.menu.findItem(R.id.mine)
                        .setIcon(R.drawable.ic_image_curier)
                    binding.viewpager.currentItem = 0
                }
            }
            true
        }
        binding.viewpager.isUserInputEnabled = false;
        requireActivity().onBackPressedDispatcher
                .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.viewpager.currentItem == 0) {
                    requireActivity().finish()
                }
            }
        }
        )

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavigationView2.menu.findItem(R.id.all).isChecked = true
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}