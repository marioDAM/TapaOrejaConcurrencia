package org.mario.bar;

import java.util.ArrayList;
import java.util.List;

public class Cocinero extends Thread{

    //Coge orejas de 5 en 5 cada dos segundos
    //preparan un plato con ellos. Estos platos pueden ser:
    // en salsa, picantona o a la plancha (con la misma probabilidad).
    private int cantidad;
    List<Oreja> misOrejas = new ArrayList<>();
    Cocina cocina;


    public Cocinero(String nombre, Cocina cocina) {
        super(nombre);
        this.cocina = cocina;
        this.cantidad = 5;
    }

    @Override
    public void run() {
        while(true){
            for(int i=0; i<cantidad; i++){
                misOrejas.add(cocina.servir()); 
            }
            try {   //Espero dos segundos antes de coger otras 5 orejas y preparar otro plato
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(misOrejas.size()==5){    
                Plato plato = new Plato();  
                plato.setIdCocinero(this.getName());
                System.out.println(this.getName()+" ha servido el "+plato.toString());
            }
            misOrejas.clear(); 


        }
    }
}
