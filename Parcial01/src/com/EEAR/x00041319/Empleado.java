package com.EEAR.x00041319;

import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre;
    protected String puesto;
    protected double salario;
    protected ArrayList<Documento> documentos;
    public Empleado(){
    }
    public Empleado(String nombre, String puesto, double salario){
        this.nombre=nombre;
        this.puesto=puesto;
        this.salario=salario;
        documentos=new ArrayList<>();
    }
    public void addDocumentos(Documento documento){

    }
    public void removeDocumento(String nombre) {

    }
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
