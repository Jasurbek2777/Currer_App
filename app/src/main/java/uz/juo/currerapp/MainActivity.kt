package uz.juo.currerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import uz.juo.currerapp.databinding.ActivityMainBinding
import uz.juo.currerapp.ui.fragments.LanguageSettingFragment
import androidx.fragment.app.Fragment
import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.ui.navigateUp
import com.google.android.material.internal.ContextUtils.getActivity


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        binding.navView.setNavigationItemSelectedListener(this);
        val drawerLayout: DrawerLayout = binding.drawerLayout
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        binding.appBarMain.online.setOnClickListener {
            binding.appBarMain.online.setBackgroundResource(R.drawable.tab_item_back)
            binding.appBarMain.online.setTextColor(Color.parseColor("#20D472"))
            binding.appBarMain.offline.setTextColor(Color.parseColor("#FFFFFF"))
            var gradientDrawable = binding.appBarMain.linear.background.mutate() as GradientDrawable
            gradientDrawable.setColor(Color.parseColor("#20D472"))
            binding.appBarMain.offline.setBackgroundResource(R.drawable.tab_item_back_unselected)

            var gradientDrawable2 =
                binding.appBarMain.offline.background.mutate() as GradientDrawable
            gradientDrawable2.setColor(Color.parseColor("#20D472"))
        }
        binding.appBarMain.offline.setOnClickListener {
            binding.appBarMain.offline.setBackgroundResource(R.drawable.tab_item_back)
            binding.appBarMain.offline.setTextColor(Color.parseColor("#F23454"))
            binding.appBarMain.online.setTextColor(Color.parseColor("#FFFFFF"))
            var gradientDrawable = binding.appBarMain.linear.background.mutate() as GradientDrawable
            gradientDrawable.setColor(Color.parseColor("#F23454"))
            binding.appBarMain.offline.setBackgroundResource(R.drawable.tab_item_back)
            binding.appBarMain.online.setBackgroundResource(R.drawable.tab_item_back_unselected)
            var gradientDrawable2 =
                binding.appBarMain.online.background.mutate() as GradientDrawable
            gradientDrawable2.setColor(Color.parseColor("#F23454"))
        }
        binding.appBarMain.image.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        navController = findNavController(R.id.nav_host_fragment_content_main)

    }

    override fun onResume() {
        super.onResume()
        supportActionBar!!.show()
    }

    @SuppressLint("ResourceType")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.history -> {
                binding.drawerLayout.close()
                navController.navigate(R.id.orderHistoryFragment)
            }
            R.id.settings -> {
                binding.drawerLayout.close()
                navController.navigate(R.id.settingsFragment)
            }
            R.id.language -> {
                binding.drawerLayout.close()
                navController.navigate(R.id.languageSettingFragment)
            }
        }
        return true

    }

    override fun onBackPressed() {
        super.onBackPressed()
        navController.navigate(R.id.nav_home)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
