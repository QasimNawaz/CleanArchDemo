package com.clean.data_layer.local

import com.clean.domain_layer.model.User
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefs @Inject constructor(
    private val spm: SharedPrefManager,
    private val gson: Gson
) {

    fun setToken(token: String) {
        spm.setStringValue(SHARED_PREF_TOKEN, token)
    }

    fun getToken() = spm.getStringValue(SHARED_PREF_TOKEN, null)

    fun setUser(user: User) {
        setToken(user.token!!)
        spm.setStringValue(SHARED_PREF_USER, gson.toJson(user))
    }

    fun getUser() = gson.fromJson(spm.getStringValue(SHARED_PREF_USER), User::class.java) ?: null

    companion object {
        const val SHARED_PREF_TOKEN = "SHARED_PREF_TOKEN"
        const val SHARED_PREF_USER = "SHARED_PREF_USER"
    }
}