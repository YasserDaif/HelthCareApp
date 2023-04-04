package com.example.helthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserName, edEmail, edPassword, edConfPassword;
    Button btnRegister;
    TextView tvHaveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUserName = findViewById(R.id.editTextRegUserName);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfPassword = findViewById(R.id.editTextRegConfPassword);
        btnRegister = findViewById(R.id.buttonRegRegister);
        tvHaveAccount = findViewById(R.id.textViewRegAUser);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = edUserName.getText().toString();
                String Email = edEmail.getText().toString();
                String Password = edPassword.getText().toString();
                String ConfPassword = edConfPassword.getText().toString();

                if (UserName.length()==0 || Email.length() ==0 || Password.length()==0 || ConfPassword.length()==0){
                    Toast.makeText(getApplicationContext(), "Please Fill all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Password.compareTo(ConfPassword)==0){
                        if (isValid(Password)){
                            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "Please Enter a Valid Password", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        tvHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    public static boolean isValid(String passwordhere){
        int f1=0, f2=0, f3=0;
        if (passwordhere.length() >= 8) {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }

            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
        }
        return false;
    }
}