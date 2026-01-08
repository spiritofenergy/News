package com.kodex.news.data.repository

import android.content.Context
import androidx.core.content.edit

class LocalAuthManager (
    context: Context
) {
    private val pref = context.getSharedPreferences("name_app_auth_pref", Context.MODE_PRIVATE )

    fun rememberAuth(id: String){
        pref.edit(commit = true){putString("id", id)}
    }
    fun isLoggedIn(): Boolean{
        return pref.getString("id", null) != null
    }
    fun signOut(){
            pref.edit(commit = true){remove("id") }
    }
}
