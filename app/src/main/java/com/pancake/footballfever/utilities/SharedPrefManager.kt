package com.pancake.footballfever.utilities

import android.content.Context
import android.content.SharedPreferences

object SharedPrefManager {

    private var sharedPreference: SharedPreferences? = null

    private const val SHARED_PREFERENCE_Name = "sharedPreference"
    private const val IS_SELECT_FAVORITE_TEAMS = "favoriteTeams"

    fun getInit(context: Context): SharedPreferences {
        sharedPreference =
            context.getSharedPreferences(SHARED_PREFERENCE_Name, Context.MODE_PRIVATE)
        return sharedPreference!!
    }

    var isSelectFavoriteTeams: Boolean?
        get() = sharedPreference?.getBoolean(IS_SELECT_FAVORITE_TEAMS, false)
        set(value) {
            sharedPreference?.edit()?.putBoolean(IS_SELECT_FAVORITE_TEAMS, value!!)?.apply()
        }
}