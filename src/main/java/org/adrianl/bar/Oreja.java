package org.adrianl.bar;



public class Oreja {

    private int idOreja;
    private static int id;
    private String idGranja;
    private String idDistribuidor;
    private String tipo;    //Puede ser normal o con pimenton

    public Oreja() {
        selecTipo();
        idOreja = id;
        id++;
    }

    public int getIdOreja() {
        return idOreja;
    }

    public void setIdOreja(int idOreja) {
        this.idOreja = idOreja;
    }

    public String getIdGranja() {
        return idGranja;
    }

    public void setIdGranja(String idGranja) {
        this.idGranja = idGranja;
    }

    public String getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(String idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void selecTipo(){
        int select = (int) (Math.random()*100+1);
        if(select>=50){
            tipo = "pimenton";
        }
        if(select<50){
            tipo = "normal";
        }
    }

    @Override
    public String toString() {
        return "Oreja: " +
                "idOreja=" + idOreja +
                ", idGranja='" + idGranja + '\'' +
                ", idDistribuidor='" + idDistribuidor + '\'' +
                ", tipo='" + tipo;
    }
}
