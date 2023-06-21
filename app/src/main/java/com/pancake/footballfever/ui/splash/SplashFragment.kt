package com.pancake.footballfever.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.utilities.SharedPrefManager


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (SharedPrefManager.isSelectFavoriteTeams == false) {
                val nav = SplashFragmentDirections.actionSplashFragmentToSelectCountryFragment()
                findNavController().navigate(nav)
            } else {
                val nav = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                findNavController().navigate(nav)
            }
        }, 3000)
    }
}