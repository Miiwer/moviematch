package com.earsnot.moviematch.Views.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.earsnot.moviematch.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_LOGIN = 100;
    private Button mBtnLogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
//        login();
    }

    private void initUI() {
        mBtnLogin = findViewById(R.id.loginBtnLogin);
        mBtnLogin.setOnClickListener(v -> login());
    }

    private void login() {
        if(mAuth==null){
            mAuth = FirebaseAuth.getInstance();
        }
        if(mAuth.getCurrentUser() != null) {
            goToMainActivity();
            Toast.makeText(this, "no logged in user",Toast.LENGTH_SHORT).show();
        }
        else {
            List<AuthUI.IdpConfig> loginProviders = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build()
            );
            startActivityForResult(
                    AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(loginProviders)
                    .build(), REQUEST_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_LOGIN){
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK){
                String uid = mAuth.getCurrentUser().getUid();
                Toast.makeText(this, "User logged in"+ uid,Toast.LENGTH_SHORT).show();
                goToMainActivity();
            }

            if (resultCode == RESULT_CANCELED){
                Toast.makeText(this,"Cancelled sign-in process", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}