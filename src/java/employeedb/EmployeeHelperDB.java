package com.example.lenovo.familyexpence.employeedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeHelperDB extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "employee_db";
    public static final int DATABASE_VERSION = 1;

    public static final String EMPLOYEE_TABLE = "tbl_employee";
    public static final String TBL_EMP_COL_ID = "_empid";
    public static final String TBL_EMP_COL_NAME = "emp_name";
    public static final String TBL_EMP_COL_DESG = "emp_desg";
    public static final String TBL_EMP_COL_SALARY = "emp_salary";

    public static final String CREATE_TBL_EMPLOYEE =
            "CREATE TABLE "+EMPLOYEE_TABLE
                    +"("+TBL_EMP_COL_ID+" INTEGER PRIMARY KEY, "
                    +TBL_EMP_COL_NAME+" TEXT, "
                    +TBL_EMP_COL_DESG+" TEXT, "
                    +TBL_EMP_COL_SALARY+" REAL);";

    public EmployeeHelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL_EMPLOYEE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
