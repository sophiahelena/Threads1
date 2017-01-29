package com.exercisis.helena.threads1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int valor;
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

        // hacer que el hilo1 sea de tipo Daemon
        // aunque queden procesos de tipo daemon la app se cerraria porque no le importa que se sigan ejecutanto
        // los procesos tipo Daemon
        hilo1.setDaemon(true);
        hilo1.setPriority(Thread.MIN_PRIORITY);

        // le digo que empiece a ejecutarse la acció
        hilo1.start();

        // Interrumpir un hilo o quitarlo: metodo Interupt()
        hilo1.interrupt();



        // HILO 2
        // La clase Hilo2 implementa Runnable y para instanciarla tengo que crear una instancia de
        // Thread y le pasamos por parámetro una instancia de la clase Hilo2
        Thread hilo2 = new Thread(new Hilo2());
        // ahora hago que el hilo2 ejecute el proceso que tengo en el run()
        hilo2.setDaemon(true);
        hilo2.setPriority(10); // 10 es lo mismo que Thread.MAX_PRIORITY. Las prioridades van del 0 (minima prioridad) al 10 (máxma prioridad)
        hilo2.start();
    }

    /**
     * Método tipo Sinchonized
     * Se usa para evitar que si 2 hilos acceden a la misma variable hayan errores
     * Synchronized se encarga de encolar las acciones
     */
    public synchronized void incrementa(int incremento){
        this.valor+=incremento;
    }

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
