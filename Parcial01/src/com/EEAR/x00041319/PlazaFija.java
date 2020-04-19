package com.EEAR.x00041319;

public class PlazaFija extends Empleado {

    private int extension;

    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }
}
