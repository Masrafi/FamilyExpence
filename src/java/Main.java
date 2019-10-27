package com.example.lenovo.familyexpence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.familyexpence.employeedb.EmployeeDataSource;


public class Main extends AppCompatActivity {
    private EditText nameET, desgET, salaryET;
    private EmployeeDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameET = findViewById(R.id.empNameInput);
        desgET = findViewById(R.id.empDesignationInput);
        // salaryET = findViewById(R.id.empSalaryInput);
        dataSource = new EmployeeDataSource(this);
    }

    public void saveEmployee(View view) {
        String name = nameET.getText().toString();
        String desg = desgET.getText().toString();
        // String salary = salaryET.getText().toString();  , Double.parseDouble(salary)

        Employee employee=new Employee(name,desg);
        boolean status=dataSource.insertNewEmployee(employee);
        //Employee employee = new Employee(name, desg);
        //boolean status = dataSource.insertNewEmployee(employee);
        if(status){
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, EmployeeListActivity.class));
        }else{
            Toast.makeText(this, "failed to save", Toast.LENGTH_SHORT).show();
        }
    }
}

