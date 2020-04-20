package com.EEAR.x00041319;

public final class  CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    public CalculadoraImpuestos(){
    }
    public static double calcularPago(Empleado em){
        double restante=0, x=0, pago=0, AFP, ISSS, Renta;
        if (em instanceof PlazaFija){
            AFP=em.salario*0.0625;
            ISSS=em.salario*0.03;
            totalAFP=totalAFP+AFP;
            totalISSS=totalISSS+ISSS;
            restante=em.salario-totalISSS-totalAFP;
            x=restante;
            if(x<=472){
                Renta=0;
            }else if(x>=472.01 && x<=895.24){
                Renta=0.1*(x-472)+17.67;
                totalRenta=Renta+totalRenta;
            }else if(x>=895.25 && x<=2038.10){
                Renta=0.2*(x-895.24)+60;
                totalRenta=Renta+totalRenta;
            }else if(x>=2038.11){
                Renta=0.3*(x-2038.10)+288.57;
                totalRenta=Renta+totalRenta;
            }
            pago=restante-totalRenta;
        }
        else if(em instanceof ServicioProfesional) {
            Renta=0.1*em.salario;
            totalRenta=Renta+totalRenta;
            pago =em.salario-totalRenta;
        }
        return pago;
    }
    public static String mostrarTotales(){
        return "Total Renta: " + totalRenta + ", Total AFP: " + totalAFP+ ", Total ISSS: " + totalISSS;
    }
}
