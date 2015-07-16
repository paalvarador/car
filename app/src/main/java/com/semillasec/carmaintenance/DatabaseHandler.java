package com.semillasec.carmaintenance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 26/06/15.
 */
public class DatabaseHandler extends SQLiteOpenHelper{
    // All static variables
    // Database version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "maintenanceManager.db";

    // Maintenance table name
    private static final String TABLE_MAINTENANCE = "maintenance";

    // Maintenance Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATE = "date";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_MILIAGE = "miliage";
    private static final String KEY_NEXT_MILIAGE = "next_miliage";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MAINTENANCE_TABLE = "CREATE TABLE " + TABLE_MAINTENANCE + "("
                                            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                            + KEY_NAME + " TEXT, "
                                            + KEY_DATE + " TEXT, "
                                            + KEY_DESCRIPTION + " TEXT, "
                                            + KEY_MILIAGE + " INTEGER, "
                                            + KEY_NEXT_MILIAGE + " INTEGER" + ")";

        db.execSQL(CREATE_MAINTENANCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existedls
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAINTENANCE);

        // Create tables again
        onCreate(db);
    }

    /*
     * All CRUD(Create, Read, Update and Delete) operations
     */

    // Adding new Maintenance
    public boolean addMaintenance(Maintenance maintenance)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, maintenance.get_name()); // Maintenance name
        values.put(KEY_DATE, maintenance.get_date()); // Maintenance date
        values.put(KEY_DESCRIPTION, maintenance.getDescription());
        values.put(KEY_MILIAGE, maintenance.get_miliage());
        values.put(KEY_NEXT_MILIAGE, maintenance.get_miliage_next());


        // Inserting Row
        long result = db.insert(TABLE_MAINTENANCE, null, values);
        //db.close(); // Close database connection

        if(result == -1)
            return false;
        else
            return true;
    }

    // Getting All Maintenance
    public List<Maintenance> getAllMaintenances()
    {
        List<Maintenance> maintenanceList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_MAINTENANCE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                Maintenance maintenance = new Maintenance();
                maintenance.set_id(Integer.parseInt(cursor.getString(0)));
                maintenance.set_name(cursor.getString(1));
                maintenance.set_date(cursor.getString(2));
                maintenance.setDescription(cursor.getString(3));
                maintenance.set_miliage(Integer.parseInt(cursor.getString(4)));
                maintenance.set_miliage_next(Integer.parseInt(cursor.getString(5)));

                // Adding maintenance to List
                maintenanceList.add(maintenance);
            }while(cursor.moveToNext());
        }

        return maintenanceList;
    }
}
