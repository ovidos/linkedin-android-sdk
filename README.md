# Linkedin Android SDK (Unofficial)

LinkedinSDK allows you to get linkedin access token inside your Android application. 

# Installation

To install the SDK:

Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

Add the dependency:

`implementation 'com.github.ovidos:linkedin-android-sdk:0.1.5'`

For login flow to work, LinkedinSignInActivity needs to be added to AndroidManifest.xml:

`<activity android:name="com.omralcorut.linkedinsignin.ui.LinkedinSignInActivity"/>`

Also, you need to add internet permission to AndroidManifest.xml:

`<uses-permission android:name="android.permission.INTERNET" />`

# Authentication 

Linkedin SDK is allows you to authenticate with OAuth2 authentication. This means that, you are allowed to manage other people's account that are authorized with your application.

# Getting Started

First of all you need to retrieve Client ID, Client Secret and Redirect Uri from Linkedin. To add Client ID, Client Secret and Redirect Uri into your application:

1. Open your Application Class and add the following

// Kotlin

	Linkedin.initialize(context = applicationContext,
            	clientId = "LINKEDIN_CLIENT_ID",
            	clientSecret = "LINKEDIN_CLIENT_SECRET",
            	redirectUri = "LINKEDIN_REDIRECT_URI",
            	state = "RANDOM_STRING",
            	scopes = listOf("r_liteprofile", "r_emailaddress"))
              
// Java

	Linkedin.Companion.initialize(getApplicationContext(),
                	"LINKEDIN_CLIENT_ID",
                	"LINKEDIN_CLIENT_SECRET",
                	"LINKEDIN_REDIRECT_URI",
                	"RANDOM_STRING",
                	Arrays.asList("r_liteprofile", "r_emailaddress"));
            
"State" is a unique string of your choice designed to protect against CSRF attacks.

2. To authorize a user for your application: 

// Kotlin

	Linkedin.login(this, object : LinkedinLoginViewResponseListener {
          	override fun linkedinDidLoggedIn(linkedinToken: LinkedinToken) {
              	// Success
          	}
          	override fun linkedinLoginDidFail(error: String) {
              	// Fail
          	}
})
          
 // Java
 
	Linkedin.Companion.login(this, new LinkedinLoginViewResponseListener() {
          	@Override
          	public void linkedinDidLoggedIn(@NotNull LinkedinToken linkedinToken) {
              	// Success
          	}

          	@Override
          	public void linkedinLoginDidFail(@NotNull String error) {
              	// Fail
          	}
	});
        
