package com.semillasec.carmaintenance;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;
import java.sql.SQLOutput;

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
    void addMaintenance(Maintenance maintenance)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, maintenance.get_name()); // Maintenance name
        values.put(KEY_DATE, maintenance.get_date()); // Maintenance date
        values.put(KEY_DESCRIPTION, maintenance.getDescription());
        values.put(KEY_MILIAGE, maintenance.get_miliage());
        values.put(KEY_NEXT_MILIAGE, maintenance.get_miliage_next());


        // Inserting Row
        //db.insert(TABLE_MAINTENANCE, null, values);
        //db.close(); // Close database connection
    }
}
