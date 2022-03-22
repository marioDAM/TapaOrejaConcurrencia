package org.mario.bar;

import java.util.ArrayList;
import java.util.List;

public class Cocina {

    private List<Oreja> misOrejas = new ArrayList<>();
    private boolean disponibilidad = false;

    public synchronized void entregar(Oreja oreja){
        while(disponibilidad && !misOrejas.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        misOrejas.add(oreja);
        //No es necesario
        if(misOrejas.size()==5) {   
            disponibilidad = true;
            notifyAll();
        }
    }

    public synchronized Oreja servir(){
        while(!disponibilidad && misOrejas.size()<6){  
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Oreja oreja = misOrejas.remove(0);  
        if(misOrejas.size()==0) { 
            disponibilidad = false;
            notifyAll();
        }
        return oreja;
    }

}
