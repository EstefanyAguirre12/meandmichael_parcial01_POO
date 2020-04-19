package com.EEAR.x00041319;

import java.util.List;

public class Empresa {

    private String nombre;
    List<Empleado> planilla;

    public void Empresa(String name){
        this.nombre =nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado empleados ){

    planilla.add(empleados);

    }

    public void quitEmpelado(String empleado) throws NotFoundException {

            Empleado aux = null;
        for(Empleado emp : planilla){
            if(emp.getNombre().equals(nombre))
                aux = emp;
        }
        if(aux != null)
            planilla.remove(aux);
        else
            throw new NotFoundException("Aplicacion no encontrada, no es posible desinstalar");
    }
}
