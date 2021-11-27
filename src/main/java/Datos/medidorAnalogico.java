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
    
    public medidorAnalogico(String codigo, String direccion, planEnergia plan, abonado abonado){
        super(codigo,direccion,plan,abonado);
        this.telemetrias = new ArrayList<>();
    }
    
    public void registrarMedicion(double ultValor){
        super.ultMedida=LocalDate.now();
        double valorPasado = super.ultValor;
        double consumoActual = ultValor - valorPasado;
        super.consumo= consumoActual;
        super.ultValor=ultValor;
    }
    
  
    public ArrayList<telemetria> getTelemetria() {
        return telemetrias;
    }
}
