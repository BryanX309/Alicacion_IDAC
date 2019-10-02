package com.example.my_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private Spinner sp1, sp2, sp3;
    private TextView tv1;
    EditText etNombre, etContra;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        tv1= findViewById(R.id.txtCurso);
        sp1= findViewById(R.id.spAnio);
        sp2= findViewById(R.id.spGrado);
        sp3= findViewById(R.id.spSeccion);

        etNombre=findViewById(R.id.txtNombre);
        etContra=findViewById(R.id.txtContra);

        agregar =findViewById(R.id.btnAgregar);

        String [] anio ={"1", "2", "3"};
        String [] grado = {"Ciclo", "Administración", "Informática", "Humanidades", "Promoción ", "Salud", "Turismo", "Contaduría"};
        String [] seccion = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.list_item_anio, anio);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.list_item_anio, grado);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, R.layout.list_item_anio, seccion);

        sp1.setAdapter(adapter1);
        sp2.setAdapter(adapter2);
        sp3.setAdapter(adapter3);

        agregar.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        String text1 = sp1.getSelectedItem().toString();
        String text2 = sp2.getSelectedItem().toString();
        String text3 = sp3.getSelectedItem().toString();


        tv1.setText(text1+ " " +text2+" "+text3);

        final String nombre = etNombre.getText().toString();
        final String contra = etContra.getText().toString();
        final String curso = tv1.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success){
                        Intent intent= new Intent(Registro.this,MainActivity.class);
                        Registro.this.startActivity(intent);

                    }else{
                        AlertDialog.Builder builder= new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Error Registro")
                                .setNegativeButton("Reintentar", null)
                                .create().show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        registerRequest registerRequest= new registerRequest(nombre,contra,curso,respoListener);
        RequestQueue queue= Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);

     }
}
