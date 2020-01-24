package com.witi.timer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.witi.timer.R;
import com.witi.timer.request.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText et_id, et_password;
    private Button btn_login, btn_register;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        // 로그인 버튼클릭시
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> map = new HashMap<>();
                map.put("email", et_id.getText().toString());
                map.put("password", et_password.getText().toString());

                JSONObject parameter = new JSONObject(map);  // map에 담은 데이터를 JSONObject로 변환시켜준다.

                Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {   // request후 response로받은 JSON객체를 model에 맞춰 끼운다.
                            Intent intent = new Intent(getApplicationContext(), StudyTraceActivity.class);
                        try {
                            if (response.getString("status").equals("SUCCESS")){
                                intent.putExtra("email", response.getString("email"));
                                intent.putExtra("password", response.getString("password"));
                                intent.putExtra("status", response.getString("status"));
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(), "아이디 잘못적음!", Toast.LENGTH_LONG).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

            LoginRequest loginRequest = new LoginRequest(parameter, responseListener);
            requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(loginRequest);
            }
        });

        // 회원가입 버튼 클릭시
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

    }
}
