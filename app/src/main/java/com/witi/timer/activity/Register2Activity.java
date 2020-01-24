package com.witi.timer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.witi.timer.R;
import com.witi.timer.model.UserAccount;
import com.witi.timer.model.UserProfile;
import com.witi.timer.request.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register2Activity extends AppCompatActivity {

    private Button btn_start;
    private EditText et_school, et_grade, et_major;
    private UserAccount userAccount;
    private UserProfile userProfile;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Intent backintent = getIntent();
//      Log.e("intent : id = ", intent.getStringExtra("id"));
        final String email = backintent.getStringExtra("id");
//      Log.e("intent : pw = ", intent.getStringExtra("pw"));
        final String password = backintent.getStringExtra("pw");

        btn_start = findViewById(R.id.btn_start);
        et_school = findViewById(R.id.et_school);
        et_grade = findViewById(R.id.et_grade);
        et_major = findViewById(R.id.et_major);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map = new HashMap<>();
                map.put("email", email);
                map.put("password", password);
                map.put("school", et_school.getText().toString());
                map.put("grade", et_grade.getText().toString());
                map.put("major", et_major.getText().toString());

                JSONObject jsonObject = new JSONObject(map);

                Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.e("Register response : ", response.getString("status"));
                            Intent intent = new Intent(getApplicationContext(), StudyTraceActivity.class);
                            intent.putExtra("status", response.getString("status"));
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(jsonObject, responseListener);
                requestQueue = Volley.newRequestQueue(Register2Activity.this);
                requestQueue.add(registerRequest);
            }
        });
    }
}
