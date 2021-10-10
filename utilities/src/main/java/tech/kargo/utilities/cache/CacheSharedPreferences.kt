package tech.kargo.utilities.cache

import android.content.Context
import androidx.core.content.edit

class CacheSharedPreferences(var context: Context) {

    private val sharedPreferencesKey = "K-Pocker"

    fun saveString(key: String, value: String) {
        val sharedPreferences = context.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        sharedPreferences.edit(true, action = {
            this.putString(key, value)
        })
    }

    fun getString(key: String) : String {
        val sharedPreferences = context.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, "")!!
    }

    fun clear(key: String) {
        val sharedPreferences = context.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        sharedPreferences.edit(true, action = {
            this.remove(key)
        })
    }

}