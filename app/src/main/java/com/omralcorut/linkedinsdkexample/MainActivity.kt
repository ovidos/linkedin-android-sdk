package com.omralcorut.linkedinsdkexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omralcorut.linkedinsignin.Linkedin
import com.omralcorut.linkedinsignin.LinkedinLoginViewResponseListener
import com.omralcorut.linkedinsignin.model.LinkedinToken

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Linkedin.initialize(context = applicationContext,
            clientId = "LINKEDIN_CLIENT_ID",
            clientSecret = "LINKEDIN_CLIENT_SECRET",
            redirectUri = "LINKEDIN_REDIRECT_URI",
            state = "RANDOM_STRING",
            scopes = listOf("r_liteprofile", "r_emailaddress"))

        Linkedin.login(this, object : LinkedinLoginViewResponseListener {
            override fun linkedinDidLoggedIn(linkedinToken: LinkedinToken) {
                // Success
            }

            override fun linkedinLoginDidFail(error: String) {
                // Fail
            }
        })
    }
}
