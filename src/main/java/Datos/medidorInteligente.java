/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Personal.abonado;
import java.util.ArrayList;

/**
 *
 * @author CAELOS JR 2018
 */
public class medidorInteligente extends Medidor{
    private ArrayList<telemetria> telemetrias;
    
    public medidorInteligente(String codigo, String direccion, planEnergia plan, abonado abonado){
        super(codigo,direccion,plan,abonado);
        telemetrias = new ArrayList<>();
    }
    
}
