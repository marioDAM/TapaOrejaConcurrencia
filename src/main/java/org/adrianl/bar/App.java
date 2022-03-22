package org.adrianl.bar;

public class App {

    public static void main(String[] args) {
        //Tres Granjas
        //Dos Distribuidores
        //Dos Cocineros
        Almacen almacen = new Almacen();
        Cocina cocina = new Cocina();

        Granja g1 = new Granja("Granja 1", almacen);
        Granja g2 = new Granja("Granja 2", almacen);
        Granja g3 = new Granja("Granja 3", almacen);


        Distribuidor d1 = new Distribuidor("Distribuidor 1", almacen, cocina);
        Distribuidor d2 = new Distribuidor("Distribuidor 2", almacen, cocina);

        Cocinero c1 = new Cocinero("Cocinero 1", cocina);
        Cocinero c2 = new Cocinero("Cocinero 2", cocina);

        g1.start();
        g2.start();
        g3.start();

        d1.start();
        d2.start();

        c1.start();
        c2.start();

        try {
            g1.join();
            g2.join();
            g3.join();

            d1.join();
            d2.join();

            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}