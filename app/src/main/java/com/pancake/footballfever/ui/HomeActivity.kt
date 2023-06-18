package com.pancake.footballfever.ui

import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.ActivityHomeBinding
import com.pancake.footballfever.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_home
}