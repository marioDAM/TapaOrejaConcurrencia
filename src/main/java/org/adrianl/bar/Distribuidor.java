package org.adrianl.bar;

import java.util.ArrayList;
import java.util.List;

public class Distribuidor extends Thread{
    //Saca diez orejas cada tres segundos y las lleva a la cocina
    private int cantidad;
    private Almacen almacen;
    private Cocina cocina;
    private List<Oreja> misOrejas = new ArrayList<>();

    public Distribuidor(String nombre, Almacen almacen, Cocina cocina) {
        super(nombre);
        this.almacen = almacen;
        this.cocina = cocina;
        this.cantidad = 10;
    }


    @Override
    public void run() {
        while(true){    
            for(int i=0; i<cantidad; i++){ 
                Oreja oreja = almacen.distribuir();
                oreja.setIdDistribuidor(this.getName());
                misOrejas.add(oreja);
                cocina.entregar(oreja);
            }
            try {  
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName()+" ha llevado a la cocina sus "+cantidad+" orejas");
            misOrejas.forEach(System.out::println);
            misOrejas.clear();



        }
    }
}
