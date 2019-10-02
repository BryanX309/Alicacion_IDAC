package com.example.my_application;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    private static String LOGIN_REQUEST_URL="http://192.168.1.45/Login.php";
    private Map<String, String> params;
    LoginRequest(String nombre, String contra, Response.Listener<String> Listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL,Listener,null);

        params= new HashMap<>();
        params.put("nombre", nombre);
        params.put("contra", contra);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
