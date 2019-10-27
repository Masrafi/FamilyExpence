package com.example.lenovo.familyexpence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExPage extends AppCompatActivity {

    private Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_page);

        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdd();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmployeeListActivity();
            }
        });
    }
    public void openEmployeeListActivity(){
        Intent intent=new Intent(this,EmployeeListActivity.class);
        startActivity(intent);
    }
    public void openAdd(){
        Intent intent=new Intent(this,Add.class);
        startActivity(intent);
    }
}
