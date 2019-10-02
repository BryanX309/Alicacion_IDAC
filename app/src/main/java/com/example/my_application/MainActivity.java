package com.example.my_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tvRegistrar;
    EditText etUsuario, etPassword;
    Button btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRegistrar = findViewById(R.id.txtReg);
        etUsuario= findViewById(R.id.txtNombre);
        etPassword= findViewById(R.id.txtPassword);
        btnLog = findViewById(R.id.btnAgregar);

        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrir = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(abrir);
            }
        });


    }
}
