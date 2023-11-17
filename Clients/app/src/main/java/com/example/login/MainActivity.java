package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.interfaces.LoginAPI;
import com.example.login.models.Login;
import com.example.login.network.RetrofitClient;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button mLogin;
    private Button mRegister;
    private TextView checkCred;

    private Boolean check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogin = (Button) findViewById(R.id.btnLogin);

        mLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
                }
        });
        mRegister = (Button) findViewById(R.id.btnRegister);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = findViewById(R.id.editTextText);
                String name = editText.getText().toString();

                EditText editTextpass = findViewById(R.id.editTextTextPassword);
                String password = editTextpass.getText().toString();
//
//                LoginAPI loginAPI = RetrofitClient.getRetrofit().create(LoginAPI.class);
//                final Login login = new Login(name, password);
//                Call<Login> call = loginAPI.login(login);
//
//                final Boolean[] respuesta = {false};
//
//                call.enqueue(new Callback<Login>() {
//                    @Override
//                    public void onResponse(Call<Login> call, Response<Login> response) {
//                        if(response.body().getStatus() == 200){
//                            Toast.makeText(MainActivity.this, response.body().getStatus_Message(), Toast.LENGTH_SHORT).show();
//                            respuesta[0] = true;
//                        }else{
//                            Toast.makeText(MainActivity.this, response.body().getStatus_Message(), Toast.LENGTH_SHORT).show();
//                            respuesta[0] = true;
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<Login> call, Throwable t) {
//                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                        respuesta[0] = false;
//                    }
//                });
                if(XML.ingresar(name, password)){
                    editText.setText("si");
                }
                else{
                    editText.setText("no");
                }

                if (XML.ingresar(name, password)){
                    System.out.println("Llego aqui");
                    Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void find(String name, String pass){

        LoginAPI loginAPI = RetrofitClient.getRetrofit().create(LoginAPI.class);
        final Login login = new Login(name, pass);
        Call<Login> call = loginAPI.login(login);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body().getStatus() == 200){
                    Toast.makeText(MainActivity.this, response.body().getStatus_Message(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, response.body().getStatus_Message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
