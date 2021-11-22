package Datos;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author kevaalci
 */
//en el formato el tipo de dato de cargo es double
//en el formato el tipo de dato de horas es LocalDateTime
public class planEnergia {
    private String nombrePlan;
    private double costoKW;
    private double cargo;
    private ArrayList<LocalDateTime> horasPico;
    
    public planEnergia(String nombrePlan, double costoKw, double cargoBase, ArrayList<LocalDateTime> horasPico){
        this.nombrePlan= nombrePlan;
        this.cargo= cargoBase;
        this.costoKW= costoKw;
        this.horasPico= horasPico;
        
    }
    
    public planEnergia(String nombrePlan){
        this.nombrePlan= nombrePlan;
       
    }
    
    public String getNombrePlan(){
        return nombrePlan;
    }
    public double getcostoKW(){
        return costoKW;
    }
    public double getCargo(){
        return cargo;
    }
    public LocalDateTime horas(){
        return horas;
    }
    public void setNombrePlan(String nombrePlan){
        this.nombrePlan = nombrePlan;
    }
    public void setCostoKW(double costoKW){
        this.costoKW = costoKW;
    }
    public void setHoras(LocalDateTime horas){
        this.horas= horas;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof planEnergia){
            planEnergia a = (planEnergia)obj;
            if (nombrePlan.equals(a.nombrePlan)){
                return true;
            }
            else{
                return false;
            }
        }
        else
            return false;
    }
}