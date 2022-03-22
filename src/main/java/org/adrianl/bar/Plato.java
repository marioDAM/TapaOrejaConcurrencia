package org.adrianl.bar;

public class Plato {

    private int idPlato;
    private static int id;
    private String idCocinero;
    private String tipo;

    public Plato() {
        idPlato = id;
        id++;
        selecTipo();
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Plato.id = id;
    }

    public String getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(String idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void selecTipo(){
        int select = (int) (Math.random()*100+1);
        if(select>=67){
            tipo = "salsa";
        }
        if(select>33 && select<67){
            tipo = "picantona";
        }
        if(select<=33){
            tipo = "plancha";
        }
    }

    @Override
    public String toString() {
        return "Plato{" +
                "idPlato=" + idPlato +
                ", idCocinero='" + idCocinero + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
