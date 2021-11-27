/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Personal.abonado;
import java.time.LocalDate;

/**
 *
 * @author CAELOS JR 2018
 */
public class medidorAnalogico extends Medidor {
    
    public medidorAnalogico(String codigo, String direccion, planEnergia plan, abonado abonado){
        super(codigo,direccion,plan,abonado);
    }
    
    public void registrarMedicion(double ultValor){
        super.ultMedida=LocalDate.now();
        double valorPasado = super.ultValor;
        double consumoActual = ultValor - valorPasado;
        super.consumo= consumoActual;
        super.ultValor=ultValor;
    }
}
