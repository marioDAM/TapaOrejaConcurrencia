package org.mario.bar;


public class Granja extends Thread{

    private int cantidad;//Produce 15 orejas cada 1 segundo

    private Almacen almacen;

    public Granja(String nombre,Almacen almacen) {
        super(nombre);
        this.almacen = almacen;
        this.cantidad = 15;
    }

    @Override
    public void run() {
        while(true){    //Siempre produce
            for(int i=0; i<cantidad;i++) {  //Produce 15 orejas
                Oreja oreja = new Oreja();
                oreja.setIdGranja(getName());
                almacen.producir(oreja);    //Las lleva al Almacen
            }
            System.out.println(getName() + " ha producido sus "+cantidad+" orejas");
            try {   //Las 15 orejas las produce cada segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           

        }


    }
}
