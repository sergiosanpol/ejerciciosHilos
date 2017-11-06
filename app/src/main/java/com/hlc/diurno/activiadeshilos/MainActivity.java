package com.hlc.diurno.activiadeshilos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void contadorPost(View v){
        Intent contador = new Intent(this, ContadorPost.class);
        startActivity(contador);
    }

    public void contadorRunOnUiThread(View v){
        Intent contador = new Intent(this, ContadorRunOnUiThread.class);
        startActivity(contador);
    }

    public void contadorHandler(View v){
        Intent contador = new Intent(this, ContadorHandler.class);
        startActivity(contador);
    }
}
