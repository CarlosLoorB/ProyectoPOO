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
    
    public telemetria(String codigo, LocalDateTime fecha, double consumo){
        this.codigo = codigo;
        this.fecha = fecha;
        this.consumo = consumo;
    }
    
}
