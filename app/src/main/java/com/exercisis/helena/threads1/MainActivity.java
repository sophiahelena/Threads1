package com.exercisis.helena.threads1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tiposDeHilos();

    }

    /**
     * Forma más sencilla de crear un Thread
     * Crearé una instancia de Thread directamente
     */
    private void tiposDeHilos() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //AQuí realizamos el proceso lento
            }
        }).start();
    }
}
