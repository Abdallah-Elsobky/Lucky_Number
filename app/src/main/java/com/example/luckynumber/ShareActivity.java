package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShareActivity extends AppCompatActivity {

    Button share;
    TextView lucky_tv;
    String name;
    String lucky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_share);
        share = findViewById(R.id.Second_btn_share);
        lucky_tv = findViewById(R.id.Second_tv_lucky);
        Intent intent = getIntent();
        lucky = intent.getStringExtra("lucky");
        name=intent.getStringExtra("name");
        lucky_tv.setText(lucky);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_TEXT,"Hi "+name+", your lucky number is "+lucky+".");
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent1, "Share Via"));
                }
            }
        });
    }
}