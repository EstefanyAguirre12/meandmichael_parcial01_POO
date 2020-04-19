package com.EEAR.x00041319;

public final class  CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    public CalculadoraImpuestos(){
    }
    public static double calcularPago(Empleado em){
        double restante=0, x=0, pago=0;
        if (em instanceof PlazaFija){
            totalAFP=em.salario*0.0625;
            totalISSS=em.salario*0.03;
            restante=em.salario-totalISSS-totalAFP;
            x=restante;
            if(x<=472){
                em.salario=x;
            }else if(x>=472.01 && x<=895.24){
                totalRenta=0.1*(x-472)+17.67;
            }else if(x>=895.25 && x<=2038.10){
                totalRenta=0.2*(x-895.24)+60;
            }else if(x>=2038.11){
                totalRenta=0.3*(x-2038.10)+288.57;
            }
            pago=restante-totalRenta;
        }
        else if(em instanceof ServicioProfesional) {
            totalRenta=0.1*em.salario;
            pago =em.salario-totalRenta;
        }
        return pago;
    }
    public static String mostrarTotales(){
        return "Total Renta: " + totalRenta + ", Total AFP: " + totalAFP+ ", Total ISSS: " + totalISSS;
    }
}
