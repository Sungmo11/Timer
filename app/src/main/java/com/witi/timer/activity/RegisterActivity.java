package com.witi.timer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.witi.timer.R;
import com.witi.timer.model.UserAccount;

import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_next;
    private EditText et_id, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_next = findViewById(R.id.btn_next);
        et_id = findViewById(R.id.et_id);
        et_password = findViewById(R.id.et_password);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register2Activity.class);
                intent.putExtra("id", et_id.getText().toString());
                intent.putExtra("pw", et_password.getText().toString());
                startActivity(intent);
            }
        });

    }
}
