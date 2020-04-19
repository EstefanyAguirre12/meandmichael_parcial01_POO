package com.EEAR.x00041319;

public class Documento {
    private String nombre;
    private String numero;

    public Documento(String nombre, String numero){
        this.nombre=nombre;
        this.numero=numero;
    }
    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }
}
