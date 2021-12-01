/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.time.LocalDateTime;

/**
 *
 * @author CAELOS JR 2018
 */
public class telemetria {
    private String codigo;
    private LocalDateTime fecha;
    private double consumo;
    
    /**
     * Se implementa un constructor del cual recibe un codigo de tipo String, una fecha de formato LocalDateTime y consumo del mes en double
     * @param codigo mediante un this se llama la variable nombreplan para que no haya algun con la variable de iniciacion y la local
     * @param fecha mediante un this se llama la variable nombreplan para que no haya algun con la variable de iniciacion y la local
     * @param consumo mediante un this se llama la variable nombreplan para que no haya algun con la variable de iniciacion y la local
     */
    public telemetria(String codigo, LocalDateTime fecha, double consumo){
        this.codigo = codigo;
        this.fecha = fecha;
        this.consumo = consumo;
    }
    
    /**
     * Se implementa un get consumo para que pueda ser llamada en otra clase debido a que est de forma privada
     * @return  me retorna el consumo del mes 
     */
    public double getconsumo(){
        return consumo;
    }
    /**
     * Se implementa un get fecha con formato LocalDateTime
     * @return retorna la fecha
     */
    public LocalDateTime getFecha(){
        return fecha;
    }
}
