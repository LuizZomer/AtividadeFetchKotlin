package com.example.composecharactersbase.helpers

import android.content.Context
import android.content.SharedPreferences

object PrefsManager {
    private const val PREFS_NAME = "character_prefs"
    private const val KEY_FAVORITES = "favorites"

    fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveFavorite(context: Context, id: Int) {
        val prefs = getPrefs(context)
        val favorites = getFavoriteSet(context).toMutableSet()
        favorites.add(id.toString())
        prefs.edit().putStringSet(KEY_FAVORITES, favorites).apply()
    }

    fun removeFavorite(context: Context, id: Int) {
        val prefs = getPrefs(context)
        val favorites = getFavoriteSet(context).toMutableSet()
        favorites.remove(id.toString())
        prefs.edit().putStringSet(KEY_FAVORITES, favorites).apply()
    }

    fun isFavorite(context: Context, id: Int): Boolean {
        return getFavoriteSet(context).contains(id.toString())
    }

    private fun getFavoriteSet(context: Context): Set<String> {
        return getPrefs(context).getStringSet(KEY_FAVORITES, emptySet()) ?: emptySet()
    }
}
