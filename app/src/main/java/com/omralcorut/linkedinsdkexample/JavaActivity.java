package com.omralcorut.linkedinsdkexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.omralcorut.linkedinsignin.Linkedin;
import com.omralcorut.linkedinsignin.LinkedinLoginViewResponseListener;
import com.omralcorut.linkedinsignin.model.LinkedinToken;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Linkedin.Companion.initialize(getApplicationContext(),
                "LINKEDIN_CLIENT_ID",
                "LINKEDIN_CLIENT_SECRET",
                "LINKEDIN_REDIRECT_URI",
                "RANDOM_STRING",
                Arrays.asList("r_liteprofile", "r_emailaddress"));

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

    }

}
