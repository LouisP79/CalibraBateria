package com.servicios.sigma.calibrabateria.Controlador;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.servicios.sigma.calibrabateria.Modelo.Calibrador;
import com.servicios.sigma.calibrabateria.R;


public class Calibra_Bateria extends ActionBarActivity implements View.OnClickListener{

    //atributos
    private Button btn_Calibrar;
    private Calibrador calibrador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibra__bateria);

        this.calibrador = new Calibrador();
        this.btn_Calibrar = (Button) findViewById(R.id.btn_Calibrar);
        AgregarEscuchador();
    }

    public void AgregarEscuchador(){
        this.btn_Calibrar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calibra__bateria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_Salir:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Calibrar:
                    boolean error = this.calibrador.Calibrar();
                    if(error == false){
                        Mensaje_Nube("Calibración Exitosa, Reiniciando...");
                        try{
                            Process p = Runtime.getRuntime().exec("su -c reboot");
                            p.waitFor();
                        }catch (Exception e){
                            Mensaje_Nube("Reinicia tu equipo manualmente por favor");
                        }
                    }else{
                        Mensaje_Nube("Algo salió mal, Revise si su equipo está rooteado");
                    }
                break;

        }
    }

    //****************************************************************************
    //****************************************************************************
    //Muestra un mensaje en una nuve negra por pocos segundos
    public void Mensaje_Nube(String val){
        Toast toast = Toast.makeText(this, val, Toast.LENGTH_SHORT);
        toast.show();
    }
}
