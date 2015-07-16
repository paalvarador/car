package com.semillasec.carmaintenance;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class MaintenanceActivity extends ActionBarActivity {
    Button bTipo, bFecha;
    EditText etNombre, etFecha, etDescripcion, etKm, etSigKm;
    Button bRegistrar;
    int year_base, month_base, day_base;
    protected static int DIALOG_ID = 1;
    DatabaseHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        dbHandler = new DatabaseHandler(this);



        etNombre = (EditText) findViewById(R.id.etType);
        etFecha = (EditText) findViewById(R.id.etDate);
        etDescripcion = (EditText) findViewById(R.id.etDescription);
        etKm = (EditText) findViewById(R.id.etMiliage);
        etSigKm = (EditText) findViewById(R.id.etNextMiliage);

        // Se llenan las variables con la fecha actual
        final Calendar calendar = Calendar.getInstance();

        year_base = calendar.get(Calendar.YEAR);
        month_base = calendar.get(Calendar.MONTH);
        day_base = calendar.get(Calendar.DAY_OF_MONTH);

        bTipo = (Button) findViewById(R.id.bType);
        bTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaintenanceActivity.this, TypeMaintenanceActivity.class);
                startActivityForResult(intent, 1);
            }
        });



        bFecha = (Button) findViewById(R.id.bDate);
        bFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });

        bRegistrar = (Button) findViewById(R.id.bSave);
        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Maintenance maintenance = new Maintenance();
                maintenance.set_name(etNombre.getText().toString());
                maintenance.setDescription(etDescripcion.getText().toString());
                maintenance.set_date(etFecha.getText().toString());
                maintenance.set_miliage(Integer.valueOf(etKm.getText().toString()));
                maintenance.set_miliage_next(Integer.valueOf(etSigKm.getText().toString()));

                if(dbHandler.addMaintenance(maintenance) == true){
                    Toast.makeText(MaintenanceActivity.this, "Datos registrados correctamente", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MaintenanceActivity.this, "No se registraron los datos", Toast.LENGTH_LONG).show();
                }

                finish();
            }
        });



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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Se chequea cual es la respuesta de la otra activity
        if(resultCode == RESULT_OK){
            etNombre.setText(data.getStringExtra("result"));
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DIALOG_ID){
            return new DatePickerDialog(this, dpickerListener, year_base, month_base, day_base);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_base = year;
            month_base = monthOfYear;
            day_base = dayOfMonth;

            String selectedDate = year_base + "/" + month_base + "/" + day_base;

            etFecha.setText(selectedDate);
        }
    };


}
