package org.mario.bar;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    List<Oreja> misOrejas = new ArrayList<>();
    private boolean disponibilidad;

    public synchronized void producir(Oreja oreja) {
        while (disponibilidad && !misOrejas.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        misOrejas.add(oreja);
        System.out.println(oreja.getIdGranja() + " ha almacenado la oreja " + oreja.getIdOreja());
        //No es necesario pero se pone
        if (misOrejas.size() == 15) {
            disponibilidad = true;
            notifyAll();
        }
    }

    public synchronized Oreja distribuir() {
        while (!disponibilidad && misOrejas.size() < 11) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Oreja oreja = misOrejas.remove(0);
        if (misOrejas.size() == 0) {
            disponibilidad = false;
            notifyAll();
        }
        return oreja;
    }
}
