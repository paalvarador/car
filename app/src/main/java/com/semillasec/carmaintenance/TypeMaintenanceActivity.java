package com.semillasec.carmaintenance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TypeMaintenanceActivity extends ActionBarActivity {
    ListView listView;
    AdapterTypeMaintenance typeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_maintenance);

        listView = (ListView)findViewById(R.id.listView);

        ArrayList<TypeMaintenance> items = new ArrayList<TypeMaintenance>();
        TypeMaintenance typeMaintenance;

        // Agregando los datos
        typeMaintenance = new TypeMaintenance(getResources().getDrawable(R.drawable.cambio_aceite),
                "Cambio de aceite", "El cambio de aceite se realiza cada 3000 kilometros o 5000 kilómetros");
        items.add(typeMaintenance);
        typeMaintenance = new TypeMaintenance(getResources().getDrawable(R.drawable.cambio_bujias),
                "Cambio de bujias", "El cambio de bujias generalmente se lo hace al año o 100000 kilómetros");
        items.add(typeMaintenance);
        typeMaintenance = new TypeMaintenance(getResources().getDrawable(R.drawable.cambio_neumaticos),
                "Cambio de neumáticos", "Generalmente el cambio de neumáticos se lo realiza cada 150000 kilometros");
        items.add(typeMaintenance);


        typeAdapter = new AdapterTypeMaintenance(this, items);

        listView.setAdapter(typeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = view.getContext();
                TextView textViewItem = ((TextView) view.findViewById(R.id.title));
                String result = textViewItem.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_type_maintenance, menu);
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
