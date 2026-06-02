package com.easy.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.easy.demo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSystemBars()
        setupViewPager()
        setupBottomNavigation()
        
        loadDemoData()
    }

    private fun setupSystemBars() {
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
    }

    private fun setupViewPager() {
        viewPager = binding.viewPager
        viewPager.isUserInputEnabled = false
        
        viewPager.adapter = object : androidx.fragment.app.FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 3
            override fun createFragment(position: Int): androidx.fragment.app.Fragment {
                return when (position) {
                    0 -> HomeFragment.newInstance()
                    1 -> FavoritesFragment.newInstance()
                    2 -> AboutFragment.newInstance()
                    else -> HomeFragment.newInstance()
                }
            }
        }
    }

    private fun setupBottomNavigation() {
        bottomNav = binding.bottomNav
        
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> viewPager.currentItem = 0
                R.id.nav_favorites -> viewPager.currentItem = 1
                R.id.nav_about -> viewPager.currentItem = 2
            }
            true
        }
    }

    private fun loadDemoData() {
        // Demo 版本：仅创建模拟数据用于界面展示
        // 实际应用中这里会加载真实数据
    }
}