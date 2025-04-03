package com.example.miaprimaapplicazione;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class ApiClient {
    private static final String URL = "https://g0ptrkwkej5fhqfl.myfritz.net/ProtezioneCivile/BACKEND/";
    private static final OkHttpClient client = new OkHttpClient();

    // Metodo per eseguire la richiesta di login
    public static String login(String email, String password) {
        try {
            // Creazione del JSON body
            JSONObject json = new JSONObject();
            json.put("email", email);
            json.put("psw", password);

            // Creazione del body della richiesta
            RequestBody requestBody = RequestBody.create(
                    json.toString(),
                    MediaType.get("application/json; charset=utf-8")
            );

            // Creazione della richiesta POST
            Request request = new Request.Builder()
                    .url(URL + "/login.php")
                    .post(requestBody)
                    .header("Content-Type", "application/json")
                    .build();

            // Esecuzione della richiesta in modo sincrono
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    return response.body().string();
                } else {
                    return "Errore: " + response.code();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore durante la richiesta: " + e.getMessage();
        }
    }

    /*
    public static String register(Utente utente) {
        try {
            // Creazione del JSON body
            JSONObject json = new JSONObject();
            json.put("Nome", utente.getNome());
            json.put("Cognome", utente.getCognome());
            json.put("DataNascita", utente.getDatanascita());
            json.put("PasswordHash", utente.getPassword());
            json.put("Ruolo", utente.getRuolo());
            json.put("Email", utente.getEmail());
            json.put("Username", utente.getUsername());

            // Creazione del body della richiesta
            RequestBody requestBody = RequestBody.create(
                    json.toString(),
                    MediaType.get("application/json; charset=utf-8")
            );

            // Creazione della richiesta POST
            Request request = new Request.Builder()
                    .url(URL + "/addUtenti.php")
                    .post(requestBody)
                    .header("Content-Type", "application/json")
                    .build();

            // Esecuzione della richiesta in modo sincrono
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    return response.body().string();
                } else {
                    return "Errore: " + response.code();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore durante la richiesta: " + e.getMessage();
        }
    }
    */
}
