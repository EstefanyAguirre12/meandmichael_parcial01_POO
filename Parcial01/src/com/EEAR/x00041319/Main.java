package com.EEAR.x00041319;

import java.util.Scanner;
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        byte opcion = 0;

        do{

            Menu();
            System.out.println("Opcion: ");
            opcion = sc.nextByte();
            sc.nextLine();

        switch (opcion){

            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
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
