package com.example.lenovo.familyexpence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExpage();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEarnPage();
            }
        });
    }
    public void openExpage(){
        Intent intent=new Intent(this,ExPage.class);
        startActivity(intent);
    }

    public void openEarnPage(){
        Intent aaa=new Intent(this,EarnPage.class);
        startActivity(aaa);
    }


    public void expence(View view) {
        Toast.makeText(this, "Expence Click", Toast.LENGTH_SHORT).show();
    }

    public void earn(View view) {
        Toast.makeText(this, "Earn Click", Toast.LENGTH_SHORT).show();

    }
}
