package com.example.miaprimaapplicazione;

import java.util.Date;

public class Utente {
    private String nome;
    private String cognome;

    private String username;
    private String password;

    public Utente(String nome, String cognome, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;

        this.username = username;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
