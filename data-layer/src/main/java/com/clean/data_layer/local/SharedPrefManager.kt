package com.clean.data_layer.local

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import com.google.gson.reflect.TypeToken


class SharedPrefManager @Inject constructor(
    @ApplicationContext context: Context,
) {

    val sharedPreferences: SharedPreferences = context.getSharedPreferences("clean_arch_pref", Activity.MODE_PRIVATE)

    fun getStringValue(key: String, default: String? = null) =
        sharedPreferences.getString(key, default) ?: default

    fun setStringValue(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getLongValue(key: String, default: Long = 0L) =
        sharedPreferences.getLong(key, default)

    fun setLongValue(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    fun getIntValue(key: String, default: Int = 0) =
        sharedPreferences.getInt(key, default)

    fun setIntValue(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun getBoolValue(key: String, default: Boolean = false) =
        sharedPreferences.getBoolean(key, default)

    fun setBoolValue(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    inline fun <reified T> setList(
        gson: Gson,
        key: String,
        list: List<T>?
    ) {
        val json = gson.toJson(list)
        sharedPreferences.edit().putString(key, json).apply()
    }

    inline fun <reified T> getList(
        gson: Gson,
        key: String
    ): List<T>? {
        val json = sharedPreferences.getString(key, null) ?: return null
        return gson.fromJson(json, object : TypeToken<List<T?>?>() {}.type)
    }
}