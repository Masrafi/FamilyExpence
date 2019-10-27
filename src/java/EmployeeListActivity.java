package com.example.lenovo.familyexpence;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.familyexpence.employeedb.EmployeeDataSource;

import java.util.List;

public class EmployeeListActivity extends AppCompatActivity implements PersonAdapter.ItemDeleteListener {
    private RecyclerView rv;
    private PersonAdapter adapter;
    private EmployeeDataSource dataSource;
    private LinearLayoutManager llm;
    private List<Employee>employeeList;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        dataSource = new EmployeeDataSource(this);
        fab = findViewById(R.id.fab);
        employeeList = dataSource.getAllEmployees();
        rv = findViewById(R.id.employeeRV);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //glm = new GridLayoutManager(this, 2);
        adapter = new PersonAdapter(this,employeeList);

        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmployeeListActivity.this,
                        Main.class));
            }
        });
    }

    @Override
    public void onItemDelete(int rowId) {
        boolean status = dataSource.deleteEmployee(rowId);
        if(status){
            Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show();
            adapter.updateList(dataSource.getAllEmployees());
        }else{
            Toast.makeText(this, "failed to delete", Toast.LENGTH_SHORT).show();
        }
    }
}
