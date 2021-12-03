/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Personal.abonado;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author CAELOS JR 2018
 */
public class medidorAnalogico extends Medidor {
     
    /**
     * Se implementa un constructor que reciba un codigo, una direccion, un tipo de plan que se deriva de la clase Medidor
     * planEnergia, un abonado que se deriva de la clase abonado
     * @param codigo  se lo nombra de la clase de Medidor mediante un super
     * @param direccion se lo nombra de la clase de Medidor mediante un super
     * @param plan se lo nombra de la clase de Medidor mediante un super
     * @param abonado se lo nombra de la clase de Medidor mediante un super
     */
    public medidorAnalogico(String codigo, String direccion, planEnergia plan, abonado abonado){
        super(codigo,direccion,plan,abonado);
    }
    
    /**
     * Se implementa el constructor registrarMedicion del cual le llega el ultimo valor de tipo double
     * Se llama de la clase Medidor con un super a ultMedida el que dara la fecha y hora actual.
     * se crea una nueva variable llamada valorPasado del cual será el ultValor del cual se lo llama por medio de un super.
     * se crea la variable consumoActual lo cual representara el el ultimo valor del cual ingresa menos el valor pasado.
     * Se llama de la clase la variable de consumo con el super y este representara el consumo actual 
     * @param ultValor sera el ultimo valor que se va a generar 
     */
    public void registrarMedicion(double ultValor){
        super.ultMedida=LocalDate.now();
        double valorPasado = super.ultValor;
        double consumoActual = ultValor - valorPasado;
        super.consumo= consumoActual;
        super.ultValor=ultValor;
    }
    
    /**
     * Se implementa el metodo abstracto de la clase de Medidor para calcular el valor que se va a cancelar para el medidor analogico
     * del cual el total sera el cargo del plan mas el consumo de kilovateos que se realizo en el tipo de plan por el consumo.
     * @param planes llamado de la clase de planEnergia
     * @param cargoPlan es el cargo que recibio del plan solicitado 
     * @return retornara un valor de tipo double.
     */
    public double calcularTotalAnalogico(planEnergia plan, double cargoPlan){
        double total = cargoPlan + (plan.getcostoKW()*consumo);
        return total;
    }
    
    /**
     * Se implementa el metodo abstracto de la clase Medidor para calcular el valor total del medidor inteligente
     * @param planes llamado de la clase de planEnergia 
     * @param dthora es de tipo entero 
     * @param h es la hora y de tipo entero
     * @param t es la lista de arreglos del cual tiene el metodo de telemetria del cual se ingresa un codigo, fecha y consumo
     * @param consumoAnte es el consumo anterior del cual se genero y se guardo
     * @param totalPico es el total de las horas picos 
     * @param totalNP es el total del nuevo precio que se generará.
     * @return  retornara un valor de tipo double
     */
    public double calcularTotalInteligente(planEnergia plan, int dthora, int h, telemetria t, double consumoAnte, double totalPico, double totalNP){
        return 0;
    }
    
    
}
