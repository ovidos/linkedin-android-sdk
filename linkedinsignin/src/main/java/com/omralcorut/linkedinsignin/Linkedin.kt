package com.omralcorut.linkedinsignin

import android.content.Context
import android.content.Intent
import com.omralcorut.linkedinsignin.helper.Constants
import com.omralcorut.linkedinsignin.model.LinkedinToken
import com.omralcorut.linkedinsignin.ui.LinkedinSignInActivity

class Linkedin {

    companion object {
        var linkedinLoginViewResponseListener: LinkedinLoginViewResponseListener? = null

        fun initialize(context: Context?, clientId: String, clientSecret: String, redirectUri: String, state: String) {
            val editor = context?.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)?.edit()
            editor?.putString(Constants.CLIENT_ID, clientId)
            editor?.putString(Constants.CLIENT_SECRET, clientSecret)
            editor?.putString(Constants.REDIRECT_URI, redirectUri)
            editor?.putString(Constants.STATE, state)
            editor?.apply()
        }

        fun login(context: Context?, listener: LinkedinLoginViewResponseListener) {
            this.linkedinLoginViewResponseListener = listener
            val loginActivity = Intent(context, LinkedinSignInActivity::class.java)
            context?.startActivity(loginActivity)
        }
    }
}

interface LinkedinLoginViewResponseListener {
    fun linkedinDidLoggedIn(linkedinToken: LinkedinToken)
    fun linkedinLoginDidFail(error: String)
}