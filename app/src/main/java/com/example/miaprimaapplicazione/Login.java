package com.example.miaprimaapplicazione;

import android.content.Intent;
import android.os.AsyncTask;
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

        EditText editTextEmail = findViewById(R.id.txt_Email);
        EditText editTextPassword = findViewById(R.id.txt_Password);
        Button btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (!username.isEmpty() && !password.isEmpty()) {
                    new LoginTask().execute(username, password);
                } else {
                    Toast.makeText(Login.this, "Inserisci username e password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // AsyncTask per eseguire la richiesta di login in background
    private class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return ApiClient.login(params[0], params[1]); // Chiama il metodo della classe ApiClient
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Gson gson = new Gson();
            Risposta risposta = gson.fromJson(result, Risposta.class);
            Log.d("Risposta", risposta.getToken() + " " + risposta.getRole() + " " + risposta.getUser());
            if (risposta.getToken() != null) {
                Toast.makeText(Login.this, "Login effettuato con successo", Toast.LENGTH_SHORT).show();

            }
        }
    }
}