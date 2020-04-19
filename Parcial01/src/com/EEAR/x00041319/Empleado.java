package com.EEAR.x00041319;

import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre;
    protected String puesto;
    protected double salario;
    protected ArrayList<Documento> documentos;

    public Empleado(String nombre, String puesto, double salario){
        this.nombre=nombre;
        this.puesto=puesto;
        this.salario=salario;
        documentos=new ArrayList<>();
    }
    public void addDocumentos(Documento documento){
        try{
            boolean existe = false;

            for(Documento a : documentos){
                if(a.getNumero().equals(documento.getNumero()))
                    existe = true;
            }

            if(existe)
                throw new AlreadyExistAppException("Ya existe un documento con ese numero");

            documentos.add(documento);
        }
        catch(AlreadyExistAppException ex){
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void removeDocumento(String nombre) throws NotFoundException {
        Documento aux = null;
        for(Documento doc : documentos){
            if(doc.getNombre().equals(nombre))
                aux = doc;
        }
        if(aux != null)
            documentos.remove(aux);
        else
            throw new NotFoundException("Aplicacion no encontrada, no es posible desinstalar");
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
