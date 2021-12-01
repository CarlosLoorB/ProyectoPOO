/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Personal.abonado;
import Personal.operario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author CAELOS JR 2018
 */
public class medidorInteligente extends Medidor{
    private ArrayList<telemetria> telemetrias;
    
    /**
     * Se implementa un constructor que recibe un codigo, una dirección, un tipo de plan un abonado que se deriva de la clase Medidor
     * @param codigo se lo nombra de la clase de Medidor mediante un super
     * @param direccion se lo nombra de la clase de Medidor mediante un super
     * @param plan se lo nombra de la clase de Medidor mediante un super
     * @param abonado se lo nombra de la clase de Medidor mediante un super
     * Por medio de telemetrias crea una lista nueva de arreglos.
     */
    public medidorInteligente(String codigo, String direccion, planEnergia plan, abonado abonado){
        super(codigo,direccion,plan,abonado);
        telemetrias = new ArrayList<>();
    }
    /**
     * Se implementa un constructor que recibe la fecha en formato LocalDateTime, un codigo y el consumo del mes 
     * @param fecha telemetrica añadira la fecha
     * @param codigo telemetrica añadira el codigo
     * @param consumo telemetrica añadira el consumo final del mes
     * t será agregada a la lista de arreglos de temetrias que tiene primero va el codigo, fecha y consumo.
     */
    public void registrarTelemetria(LocalDateTime fecha, String codigo, double consumo){
        telemetria t = new telemetria(codigo, fecha, consumo);
        telemetrias.add(t);
    }
    
    /**
     * Se implementa un get de temetria para que pueda ser nombrada en otra clase
     * @return retornara la lista de arreglo telemetrias
     */
    public ArrayList<telemetria> getTelemetria(){
        return telemetrias;
    }
    
    /**
     * Se implementa un set de telemetria del cual recibe la lista de arreglo de telemetrias
     * @param telemetrias  por un this se inicializa para que tanto la temetrica por defecto y la local no tenga ningun inconveniente 
     * al ser nombrada.
     */
    public void setTelemetria(ArrayList<telemetria> telemetrias){
        this.telemetrias=telemetrias;
    }
    
    /**
     * Se crea un constructor que registra la medicion llamada registrarMedi del cual recibe el ultimo valor 
     * @param ultValor 
     */
    public void registrarMedi(double ultValor){
        super.ultMedida=LocalDate.now();
        double valorPasado = super.ultValor;
        double consumoActual = ultValor - valorPasado;
        super.consumo= consumoActual;
        super.ultValor=ultValor;
    }
}
