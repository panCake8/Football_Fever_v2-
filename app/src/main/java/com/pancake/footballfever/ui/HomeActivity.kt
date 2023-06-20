package com.pancake.footballfever.ui

import android.os.Bundle
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.ActivityHomeBinding
import com.pancake.footballfever.ui.base.BaseActivity
import com.pancake.footballfever.utilities.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPrefManager.getInit(applicationContext)
    }
}