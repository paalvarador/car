package com.semillasec.carmaintenance;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Date;


public class MaintenanceActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        DatabaseHandler handler = new DatabaseHandler(this);
        SQLiteDatabase db = handler.getWritableDatabase();


        Log.d("Message: ", "Se creo la puta base de datos");

        /**
         * CRUD Operations
         */
        // Inserting Maintenance
        Log.d("Insert: ", "Inserting...");
        ContentValues values = new ContentValues();
        values.put("name", "Limpieza de inyectores"); // Maintenance name
        values.put("date", "12/05/2015"); // Maintenance date
        values.put("description", "Se hízo la limpieza por que estaba fallando el movil");
        values.put("miliage", 125256);
        values.put("next_miliage", 135256);

        long result = db.insert("maintenance", null, values);


        db.close();
        //handler.addMaintenance(new Maintenance("Limpieza de inyectores", "12/02/2015", "Se hizo la limpieza por que estaba fallando algo", 117250, 200020));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_maintenance, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
