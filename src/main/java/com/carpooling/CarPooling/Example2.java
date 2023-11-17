package com.carpooling.CarPooling;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Example2 {

    public static void main(String[] args) {
        try {
            // URL del servicio RESTful
            String apiUrl = "http://localhost:8080/login";

            // Crear un objeto URL
            URL url = new URL(apiUrl);

            // Abrir una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la solicitud
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            // Habilitar la escritura de datos en el cuerpo de la solicitud
            connection.setDoOutput(true);

            // Datos que enviarás en el cuerpo de la solicitud (pueden ser JSON, XML, u otro formato)
            String getData = "{\"nombre\": \"Brayan\", \"contraseña\": \"hola1234\"}";

            // Obtener el flujo de salida para escribir los datos en el cuerpo de la solicitud
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                byte[] getDataBytes = getData.getBytes(StandardCharsets.UTF_8);
                wr.write(getDataBytes);
            }

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Imprimir la respuesta
                System.out.println("Respuesta del servidor: " + response.toString());
            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}