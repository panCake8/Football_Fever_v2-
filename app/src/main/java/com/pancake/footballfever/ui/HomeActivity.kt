package com.pancake.footballfever.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.ActivityHomeBinding
import com.pancake.footballfever.ui.base.BaseActivity
import com.pancake.footballfever.utilities.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_home

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPrefManager.getInit(applicationContext)
        navController()


    }


    private fun navController() {
        navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        navController = navHostFragment.findNavController()
//        setupActionBarWithNavController(navController)
        binding.navBottom.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun showBottomNavBar(show: Boolean) {
        if (show)
            binding.navBottom.visibility = View.VISIBLE
        else
            binding.navBottom.visibility = View.GONE
    }

}