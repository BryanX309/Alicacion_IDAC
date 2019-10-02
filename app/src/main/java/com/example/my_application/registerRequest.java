package com.example.my_application;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class registerRequest extends StringRequest {

    private static String REGISTER_REQUEST_URL="http://192.168.1.45/Register.php";
    private Map<String, String> params;
    registerRequest(String nombre, String contra, String curso, Response.Listener<String> Listener){
        super(Method.POST, REGISTER_REQUEST_URL,Listener,null);

        params= new HashMap<>();
        params.put("nombre", nombre);
        params.put("contra", contra);
        params.put("curso", curso);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
