package com.exercisis.helena.threads1;

import android.content.Context;
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
     * Crearé una instancia de la clase Thread directamente
     */
    private void tiposDeHilos() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //AQuí realizamos el proceso lento
            }
        }).start();

        // HILO1
        //Creo una instancia del Hilo1, como la clase Hilo1 extiende de Threa la instancio directamente
        Hilo1 hilo1 = new Hilo1();

        // le digo que empiece a ejecutarse la acció
        hilo1.start();

        // HILO 2
        // La clase Hilo2 implementa Runnable y para instanciarla tengo que crear una instancia de
        // Thread y le pasamos por parámetro una instancia de la clase Hilo2
        Thread hilo2 = new Thread(new Hilo2());
        // ahora hago que el hilo2 ejecute el proceso que tengo en el run()
        hilo2.start();
    }

    //
    public class HiloDatos extends Thread{
        //Para que pueda manejar los datos de la ventana o Activity tenemso que pasarle
        // el contexto de la correspondiente Activity
        Context mContext;

        // Creo el constructor y le paso el contexto
        // para poder modificar los datos de la apllicación
        public HiloDatos(Context context){
            this.mContext = context;

            // ahora le digo que esto empiece a ejecutarse
            this.run();
        }

        // Sobreescribo el método run
        @Override
        public void run() {
            super.run();
            // aquí el proceso lento
        }
    }


}
