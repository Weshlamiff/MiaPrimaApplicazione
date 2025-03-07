package com.example.miaprimaapplicazione;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

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
                //uso del log
                Log.d("Registrazione", editTextNome.getText().toString() + " " + editTextCognome.getText().toString());
                Toast.makeText(Register.this, editTextNome.getText().toString() + " " + editTextCognome.getText().toString() + " registrato correttamente", Toast.LENGTH_LONG).show();
            }
        });

    }
}