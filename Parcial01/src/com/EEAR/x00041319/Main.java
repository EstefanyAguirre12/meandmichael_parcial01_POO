package com.EEAR.x00041319;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NotFoundException {
	// write your code here
        byte opcion = 0;
        String empresa, nombre, puesto, documento, numerodocumento, otro, nombreempleado;
        double salario;
        int extension, mesescontrato;

        System.out.println("Ingrese el nombre de la empresa: ");
        empresa = sc.nextLine();

        Empresa emp = new Empresa(empresa);
        PlazaFija p = null;
        ServicioProfesional s = null;

        do{
            Menu();
            System.out.println("Opcion: ");
            opcion = sc.nextByte();
            sc.nextLine();
        switch (opcion){
            case 1:
                System.out.println("¿Que tipo de empleado desea ingresar?");
                System.out.println("1. Plaza Fija");
                System.out.println("2. Servicio Profesional");
                byte tipo = sc.nextByte();
                sc.nextLine();
                switch (tipo){
                    case 1:
                        System.out.print("Nombre: "); nombre = sc.nextLine();
                        System.out.print("Puesto: "); puesto = sc.nextLine();
                        System.out.print("Salario: "); salario = sc.nextDouble();
                        System.out.print("Extension: "); extension = sc.nextInt();sc.nextLine();

                        p=new PlazaFija(nombre, puesto, salario, extension);
                        emp.addEmpleado(p);
                        do{
                            System.out.print("Documento: "); documento = sc.nextLine();
                            System.out.print("Numero de documento: "); numerodocumento = sc.nextLine();
                            p.addDocumentos(new Documento(documento, numerodocumento));
                            System.out.println("¿Desea ingresar otro?(S/N)");
                            otro = sc.nextLine();
                        }while (otro.equals("S"));

                        break;
                    case 2:
                        System.out.print("Nombre: "); nombre = sc.nextLine();
                        System.out.print("Puesto: "); puesto = sc.nextLine();
                        System.out.print("Salario: "); salario = sc.nextDouble();
                        System.out.print("Meses de contrato: "); mesescontrato = sc.nextInt();sc.nextLine();

                        s=new ServicioProfesional(nombre, puesto, salario, mesescontrato);
                        emp.addEmpleado(s);
                        do{
                            System.out.print("Documento: "); documento = sc.nextLine();
                            System.out.print("Numero de documento: "); numerodocumento = sc.nextLine();
                            s.addDocumentos(new Documento(documento, numerodocumento));
                            System.out.println("¿Desea ingresar otro?(S/N)");
                            otro = sc.nextLine();
                        }while (otro.equals("S"));

                        break;
                }
                break;

            case 2:
                String aux2="", aux3="";

                System.out.println("Ingrese el nombre del empleado: "); nombreempleado = sc.nextLine();
                System.out.println("Ingrese el numero de documento: "); numerodocumento = sc.nextLine();

                for (Empleado aux:emp.getPlanilla()) {
                    if(nombreempleado.equals(aux.getNombre())){
                        aux2=aux.getNombre();
                    }
                }

                for (Documento aux: p.getDocumentos()) {
                    if(numerodocumento.equals(aux.getNumero())){
                        aux3=aux.getNumero();
                    }
                }

                if (aux3==""){
                    for (Documento aux: s.getDocumentos()) {
                        if(numerodocumento.equals(aux.getNumero())){
                            aux3=aux.getNumero();
                        }
                    }

                    if(aux2=="" && aux3==""){
                        System.out.println("Empleado o documento no encontrado");
                    }else{
                        emp.quitEmpelado(aux2);
                        s.removeDocumento(aux3);
                        System.out.println("empleado despedido");
                    }
                }

                else if(aux2=="" && aux3==""){
                    System.out.println("Empleado o documento no encontrado");
                }else{
                    emp.quitEmpelado(aux2);
                    p.removeDocumento(aux3);
                    System.out.println("empleado despedido");
                }

                break;

            case 3:
                String cadena = "";

                for (Empleado aux:emp.getPlanilla()) {
                    cadena+="\nEmpleado: "+aux.getNombre()+" Cargo: "+aux.getPuesto()+" Salario: "+aux.getSalario()+" ";
                    if(aux instanceof PlazaFija){
                        cadena+="Plaza Fija"+"\nDocumentos: " ;
                    }
                    else{
                        cadena+="Servicio Profesional"+"\nDocumentos: ";
                    }
                    for (Documento aux1:aux.getDocumentos()) {
                        cadena+="Nombre: "+aux1.getNombre()+" Numero: "+aux1.getNumero()+" ";
                    }
                }
                System.out.println(cadena);
                break;

            case 4:
                System.out.println("Ingrese el nombre del empleado: ");
                String n = sc.nextLine();
                for (Empleado aux:emp.getPlanilla()) {
                    if(aux.getNombre().equals(n)){
                        System.out.println(CalculadoraImpuestos.calcularPago(aux));
                    }
                }
                break;
            case 5:
                System.out.println(CalculadoraImpuestos.mostrarTotales());
                break;

            case 6:
                break;



        }


        }

        while (opcion !=6);


    }

    static void Menu(){
        System.out.println("1. Agregar empleado");
        System.out.println("2. Despedir empleado");
        System.out.println("3. Ver lista de empleado");
        System.out.println("4. Calcular sueldo");
        System.out.println("5. Mostrar totales");
        System.out.println("6. Salir");
    }
}
