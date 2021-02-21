package com.example.iisuniv.campusiis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton feedback = (ImageButton)findViewById(R.id.imageButton4);
        feedback.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://docs.google.com/forms/d/e/1FAIpQLSdkM6CFGj1a3ZdNN7PZm9V_dcCpnNQK80xNmKf5Md-ZXH2Ayw/viewform";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        ImageButton maps = (ImageButton)findViewById(R.id.imageButton);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MapsActivity.class));
            }
        });
    }
}
