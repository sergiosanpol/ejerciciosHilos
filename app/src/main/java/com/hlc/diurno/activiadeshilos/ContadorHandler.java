package com.hlc.diurno.activiadeshilos;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ContadorHandler extends AppCompatActivity {

    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_handler);

        textView = (TextView) findViewById(R.id.textViewHandler);
    }

    /*clase Handler utilizada para actualizar la UI de la actividad principal*/
    static Handler UIactualiza = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            byte[] buffer = (byte[]) msg.obj;
            //convierte el array de byte a string
            String strRecibido = new String(buffer);
            //Muestra el texto recibido en el TextView
            textView.setText(strRecibido);
        }
    };

    public void startCounter(View view) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                // actualizar actividad principal
                    ContadorHandler.UIactualiza.obtainMessage(0,String.valueOf(i).getBytes()).sendToTarget();
                // --- introducir un retraso
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Log.d("Threading" , e.getLocalizedMessage());
                    }
                }
            }
        }).start();
    }

}
