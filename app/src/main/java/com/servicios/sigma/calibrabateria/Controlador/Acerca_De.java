package com.servicios.sigma.calibrabateria.Controlador;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.servicios.sigma.calibrabateria.R;


public class Acerca_De extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca__de);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_acerca__de, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_calibra:
                Intent intent2 =
                        new Intent(this, Calibra_Bateria.class);
                startActivity(intent2);
                finish(); // La cerramos.
                return true;
            case R.id.action_Salir:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
