package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button be_lucky;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        be_lucky = findViewById(R.id.Main_btn_lucky);
        name = findViewById(R.id.Main_et_name);
        be_lucky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter Valid Name 😡",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,ShareActivity.class);
                    intent.putExtra("lucky",""+Math.round(Math.random() * 10));
                    String nam = name.getText().toString();
                    intent.putExtra("name",nam);
                    Toast.makeText(MainActivity.this,"You are lucky 🙂",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
    }
}