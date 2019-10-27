package com.example.lenovo.familyexpence.employeedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.lenovo.familyexpence.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataSource {
    private EmployeeHelperDB helperDB;
    private SQLiteDatabase db;

    public EmployeeDataSource(Context context){
        helperDB = new EmployeeHelperDB(context);
    }

    public void open(){
        db = helperDB.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public boolean insertNewEmployee(Employee employee){
        this.open();
        ContentValues values = new ContentValues();
        values.put(EmployeeHelperDB.TBL_EMP_COL_NAME, employee.getName());
        values.put(EmployeeHelperDB.TBL_EMP_COL_DESG, employee.getDesignation());
        // values.put(EmployeeHelperDB.TBL_EMP_COL_SALARY, employee.getSalary());
        long insertedRow = db.insert(EmployeeHelperDB.EMPLOYEE_TABLE, null, values);
        this.close();
        if(insertedRow > 0){
            return true;
        }
        return false;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        this.open();
        Cursor cursor = db.rawQuery("SELECT * FROM "+EmployeeHelperDB.EMPLOYEE_TABLE, null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for(int i = 0; i < cursor.getCount(); i++){
                int id = cursor.getInt(cursor.getColumnIndex(EmployeeHelperDB.TBL_EMP_COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(EmployeeHelperDB.TBL_EMP_COL_NAME));
                String designation = cursor.getString(cursor.getColumnIndex(EmployeeHelperDB.TBL_EMP_COL_DESG));
                //double salary = cursor.getDouble(cursor.getColumnIndex(EmployeeHelperDB.TBL_EMP_COL_SALARY));
                Employee e = new Employee(id, name, designation);
                employeeList.add(e);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return employeeList;
    }

    public boolean deleteEmployee(int rowId){
        this.open();
        int deletedRow = db.delete(EmployeeHelperDB.EMPLOYEE_TABLE,
                EmployeeHelperDB.TBL_EMP_COL_ID+" = "+rowId,
                null);
        this.close();
        if(deletedRow > 0){
            return true;
        }
        return false;
    }
}
