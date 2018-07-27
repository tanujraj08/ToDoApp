package com.tanuj.todoapp.utils;

import android.content.Context;
import android.widget.Toast;

import com.tanuj.todoapp.database.DBHelper;



public class CommonUtilities {

    // A Singleton Class Creates Object if not created
    public static DBHelper getDBObject(Context context){
        DBHelper dbHelper = DBHelper.getInstance(context);
        return dbHelper;
    }
}
