/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Datos.planEnergia;
import Datos.registro;
import java.time.LocalDateTime;

/**
 *
 * @author kevaalci
 */
public class administrador extends user{

    public administrador(String cedula,String usuario,String contrasena){
        super(cedula,usuario,contrasena);
    }
    // adentro del metodo se pediran las provincias 
    public void registrarPlan(String nombrePlan, double costoKw, double cargoBase, LocalDateTime horaPico){
      planEnergia nuevoPlan = new planEnergia(nombrePlan, costoKw, cargoBase, horaPico);
      //if(.getPlanes())    
    }
}