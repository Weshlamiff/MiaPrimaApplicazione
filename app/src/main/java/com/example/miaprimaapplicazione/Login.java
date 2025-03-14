package com.example.miaprimaapplicazione;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intentreg = getIntent();
        String utenteJson = intentreg.getStringExtra("utente");
        Gson gson = new Gson();
        Utente utente = gson.fromJson(utenteJson, Utente.class);

        EditText editTextUser = findViewById(R.id.txt_Username);
        EditText editTextPassword = findViewById(R.id.txt_Password);
        Button btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(utente == null){
                    Toast.makeText(Login.this, "Utente non trovato", Toast.LENGTH_LONG).show();
                }
                else {
                    if (editTextUser.getText().toString().equals(utente.getUsername()) && editTextPassword.getText().toString().equals(utente.getPassword())) {
                        Toast.makeText(Login.this, "Login effettuato correttamente", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(Login.this, "Username o password errati", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}