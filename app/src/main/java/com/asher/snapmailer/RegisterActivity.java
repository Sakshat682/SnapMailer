package com.asher.snapmailer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //To set dialog box on clicking login button
        Button signupbtn = findViewById(R.id.btnRegister);
        signupbtn.setOnClickListener(this);


        TextView btn= findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        TextView logo= findViewById(R.id.logo);

    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                alertDialog();
                break;
        }
    }

    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Details Not filled");
        dialog.setTitle("ERROR!!");
        dialog.setNeutralButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"Please fill your details",Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

}