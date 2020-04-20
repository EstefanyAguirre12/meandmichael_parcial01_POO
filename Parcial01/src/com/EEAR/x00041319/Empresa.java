package com.EEAR.x00041319;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    List<Empleado> planilla= new ArrayList();;

    public Empresa(String name){
        this.nombre =nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado empleados ){
        try{
            boolean existe = false;

            for(Empleado a : planilla){
                if(a.getNombre().equals(empleados.getNombre()))
                    existe = true;
            }

            if(existe)
                throw new AlreadyExistException("Ya existe un empleado con ese nombre");

            planilla.add(empleados);
        }
        catch(AlreadyExistException ex){
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void quitEmpelado(String empleado) {
        if(planilla.removeIf(s->s.getNombre().equals(empleado))) {
            System.out.println("Empleado despedido con exito");
        }
    }
}
