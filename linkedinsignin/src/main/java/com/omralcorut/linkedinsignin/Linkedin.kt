package com.omralcorut.linkedinsignin

import android.content.Context
import android.content.Intent
import com.omralcorut.linkedinsignin.helper.Constants
import com.omralcorut.linkedinsignin.model.LinkedinToken
import com.omralcorut.linkedinsignin.ui.LinkedinSignInActivity
import java.net.URLEncoder

class Linkedin {

    companion object {
        var linkedinLoginViewResponseListener: LinkedinLoginViewResponseListener? = null

        fun initialize(context: Context?, clientId: String, clientSecret: String, redirectUri: String, state: String, scopes: List<String>) {
            val editor = context?.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)?.edit()
            editor?.putString(Constants.CLIENT_ID, clientId)
            editor?.putString(Constants.CLIENT_SECRET, clientSecret)
            editor?.putString(Constants.REDIRECT_URI, redirectUri)
            editor?.putString(Constants.STATE, state)
            editor?.putString(Constants.SCOPE, getScopes(scopes))
            editor?.apply()
        }

        fun login(context: Context?, listener: LinkedinLoginViewResponseListener) {
            this.linkedinLoginViewResponseListener = listener
            val loginActivity = Intent(context, LinkedinSignInActivity::class.java)
            context?.startActivity(loginActivity)
        }

        private fun getScopes(scopes: List<String>): String {
            var scopesString: String = ""
            for (scope in scopes) {
                scopesString += "$scope&"
            }
            scopesString = scopesString.dropLast(1)
            return scopesString
        }
    }
}

interface LinkedinLoginViewResponseListener {
    fun linkedinDidLoggedIn(linkedinToken: LinkedinToken)
    fun linkedinLoginDidFail(error: String)
}