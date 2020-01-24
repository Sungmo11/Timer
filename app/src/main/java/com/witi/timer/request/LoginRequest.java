package com.witi.timer.request;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

// 로그인 Request를 만든 클래스
public class LoginRequest extends JsonObjectRequest {

    // Login 요청을 보낼 서버 URL
    private static final String URL = "http://ec2-15-165-108-138.ap-northeast-2.compute.amazonaws.com:8080/test/loginTest";

    public LoginRequest(@Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener) {
        super(Method.POST, URL, jsonRequest, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error != null) {
                Log.e("LoginError : ", error.getMessage());
                } else {
                    Log.e("LoginError : ", "error가 null값 입니다.");
                }
            }
        });
    }
}
