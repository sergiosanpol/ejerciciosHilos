package com.hlc.diurno.activiadeshilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContadorRunOnUiThread extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_run_on_ui_thread);

        textView = (TextView) findViewById(R.id.textViewRunOnUiThread);
    }

    public void startCounter(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 1000;i++){
                    final int cont = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(cont));

                        }
                    });
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }
                }
            }
        }).start();
    }

}
