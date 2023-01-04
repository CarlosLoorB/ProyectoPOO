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
    

    
    
}
