package com.asher.snapmailer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MyProfileActivity extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.send_email.sharedpreferences", Context.MODE_PRIVATE);
        TextView uname = (TextView) findViewById(R.id.profileUsername);
        uname.setText(sharedPreferences.getString("username","USERNAME"));
        uname = (TextView)findViewById(R.id.profileEmail);
        uname.setText(sharedPreferences.getString("email","EMAIL"));

        Button segbtn= findViewById(R.id.settingsBtn);
        segbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProfileActivity.this, SettingsActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


        Button bttn = findViewById(R.id.googleLogOut);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                        Toast.makeText(MyProfileActivity.this, "signout", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                });
    }

}