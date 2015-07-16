package com.semillasec.carmaintenance;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class SettingsActivity extends Activity {

    public static final String PREFS = "settingsPrefs";
    private EditText etMarca;
    private EditText etModelo;
    private EditText etClase;
    private EditText etTipo;
    private EditText etPlaca;
    private EditText etAnio;
    private EditText etColor;
    private EditText etKmActual;
    private EditText etKmActualEstimado;
    private EditText etKmEstimado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        etMarca = (EditText) findViewById(R.id.etMarca);
        etModelo = (EditText) findViewById(R.id.etModelo);
        etClase = (EditText) findViewById(R.id.etClase);
        etTipo = (EditText) findViewById(R.id.etTipo);
        etPlaca = (EditText) findViewById(R.id.etPlaca);
        etAnio = (EditText) findViewById(R.id.etAnio);
        etColor = (EditText) findViewById(R.id.etColor);
        etKmActual = (EditText) findViewById(R.id.etKmActual);
        etKmActualEstimado = (EditText) findViewById(R.id.etKmActualEstimado);
        etKmEstimado = (EditText) findViewById(R.id.etKmEstimado);

        SharedPreferences preferences = getSharedPreferences(PREFS, 0);

        etMarca.setText(preferences.getString("marca", etMarca.getHint().toString()));
        etModelo.setText(preferences.getString("modelo", etModelo.getHint().toString()));
        etClase.setText(preferences.getString("clase", etClase.getHint().toString()));
        etTipo.setText(preferences.getString("tipo", etTipo.getHint().toString()));
        etPlaca.setText(preferences.getString("placa", etPlaca.getHint().toString()));
        etAnio.setText(preferences.getString("anio", etAnio.getHint().toString()));
        etColor.setText(preferences.getString("color", etColor.getHint().toString()));
        etKmActual.setText(preferences.getString("kmactual", etKmActual.getHint().toString()));
        etKmActualEstimado.setText(preferences.getString("kmactualestimado", etKmActualEstimado.getHint().toString()));
        etKmEstimado.setText(preferences.getString("kmestimado", etKmEstimado.getHint().toString()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences preferences = getSharedPreferences(PREFS, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("marca", etMarca.getText().toString());
        editor.putString("modelo", etModelo.getText().toString());
        editor.putString("clase", etClase.getText().toString());
        editor.putString("tipo", etTipo.getText().toString());
        editor.putString("placa", etPlaca.getText().toString());
        editor.putString("anio", etAnio.getText().toString());
        editor.putString("color", etColor.getText().toString());
        editor.putString("kmactual", etKmActual.getText().toString());
        editor.putString("kmactualestimado", etKmActualEstimado.getText().toString());
        editor.putString("kmestimado", etKmEstimado.getText().toString());
        editor.apply();
    }
}
