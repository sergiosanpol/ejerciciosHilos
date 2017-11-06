package com.hlc.diurno.activiadeshilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContadorPost extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_post);

        textView = (TextView) findViewById(R.id.textViewPost);
    }

    public void startCounter(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 1000;i++){
                    final int cont = i;
                    // actualizar la interfaz de usuario (bloque Runnable adicional para el método .post())
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(cont));
                        }
                    });
                    // pausa para dar tiempo a que se muestre el valor antes de pasar al siguiente
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }
                }
            }
        }).start();
    }
}
