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
    private ArrayList<telemetria> telemetrias;
    
    /**
     * Se implementa un constructor que reciba un codigo, una direccion, un tipo de plan que se deriva de la clase Medidor
     * planEnergia, un abonado que se deriva de la clase abonado
     * @param codigo  se lo nombra de la clase de Medidor mediante un super
     * @param direccion se lo nombra de la clase de Medidor mediante un super
     * @param plan se lo nombra de la clase de Medidor mediante un super
     * @param abonado se lo nombra de la clase de Medidor mediante un super
     * por medio de un this.telemetricas debido a que esta de forma privada el arreglo de lista.
     */
    public medidorAnalogico(String codigo, String direccion, planEnergia plan, abonado abonado){
        super(codigo,direccion,plan,abonado);
        this.telemetrias = new ArrayList<>();
    }
    
    /**
     * Se implementa el constructor registrarMedicion del cual le llega el ultimo valor
     * @param ultValor 
     */
    public void registrarMedicion(double ultValor){
        super.ultMedida=LocalDate.now();
        double valorPasado = super.ultValor;
        double consumoActual = ultValor - valorPasado;
        super.consumo= consumoActual;
        super.ultValor=ultValor;
    }
    
    /**
     * Se implementa un get de telemetria debido a que esta de forma privada y pueda ser nombrado en otra clase 
     * @return me retorna la telemetrica.
     */
    public ArrayList<telemetria> getTelemetria() {
        return telemetrias;
    }
}
