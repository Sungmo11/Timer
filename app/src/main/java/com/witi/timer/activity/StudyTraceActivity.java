package com.witi.timer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.witi.timer.R;

public class StudyTraceActivity extends AppCompatActivity {

    TextView tv_scrollviewtest;
    Button btn_studytrace, btn_mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studytrace);

        tv_scrollviewtest = findViewById(R.id.tv_scrollviewtest);
        btn_studytrace = findViewById(R.id.btn_studytrace);
        btn_mypage = findViewById(R.id.btn_mypage);

        btn_studytrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "공부흔적!", Toast.LENGTH_LONG).show();
            }
        });

        btn_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "마이페이지!", Toast.LENGTH_LONG).show();
            }
        });
    }



    public void testClick(View view) {
        startActivity(new Intent(getApplicationContext(), StopwatchActivity.class));
    }

    // scrollView test
    public void testscroll(View view) {
        switch (view.getId()){
            case R.id.btn_scrolltest1:
                tv_scrollviewtest.setText("테스트1");
                break;
            case R.id.btn_scrolltest2:
                tv_scrollviewtest.setText("테스트2");
                break;
            case R.id.btn_scrolltest3:
                tv_scrollviewtest.setText("테스트3");
                break;
            case R.id.btn_scrolltest4:
                tv_scrollviewtest.setText("테스트4");
                break;
            case R.id.btn_scrolltest5:
                tv_scrollviewtest.setText("테스트5");
                break;
            case R.id.btn_scrolltest6:
                tv_scrollviewtest.setText("테스트6");
                break;

        }
    }
}
