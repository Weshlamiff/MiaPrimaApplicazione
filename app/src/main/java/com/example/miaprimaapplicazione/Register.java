package com.example.miaprimaapplicazione;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        //Collegamento con elementi grafici
        EditText editTextNome = findViewById(R.id.txt_nome);
        EditText editTextCognome = findViewById(R.id.txt_cognome);
        CalendarView calendar = findViewById(R.id.calendar);
        EditText editTextUser = findViewById(R.id.txt_user);
        EditText editTextPassword = findViewById(R.id.txt_password);
        Button btnRegister = findViewById(R.id.btn_register);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNome.getText().toString().isEmpty() || editTextCognome.getText().toString().isEmpty() || editTextUser.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Compilare tutti i campi", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (editTextPassword.getText().toString().length() < 8) {
                    Toast.makeText(Register.this, "La password deve avere almeno 8 caratteri", Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    Utente utente = new Utente(editTextNome.getText().toString(), editTextCognome.getText().toString(),editTextUser.getText().toString(), editTextPassword.getText().toString());
                    Gson gson = new Gson();
                    String utenteJson = gson.toJson(utente);
                    Log.d("utenteJson", utenteJson);

                    Intent intent = new Intent(Register.this, Login.class);
                    intent.putExtra("utente", utenteJson);
                    startActivity(intent);

                    //uso del log
                    Log.d("Registrazione", utente.getNome() + " " + utente.getCognome() +  " " + utente.getUsername() + " " + utente.getPassword());
                    Toast.makeText(Register.this, editTextNome.getText().toString() + " " + editTextCognome.getText().toString() + " registrato correttamente", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}