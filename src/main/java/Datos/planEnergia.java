package Datos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author kevaalci
 */
//en el formato el tipo de dato de cargo es double
//en el formato el tipo de dato de horas es LocalDateTime
//hay que agregar el enum de provincias
public class planEnergia {
    private String nombrePlan;
    private double costoKW;
    private double cargo;
    private ArrayList<LocalTime> horasPico;
    
    public planEnergia(String nombrePlan, double costoKw, double cargoBase, ArrayList<LocalTime> horasPico){
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
    public ArrayList<LocalTime> getHoras(){
        return horasPico;
    }
    public void setNombrePlan(String nombrePlan){
        this.nombrePlan = nombrePlan;
    }
    public void setCostoKW(double costoKW){
        this.costoKW = costoKW;
    }
    public void setHoras(ArrayList<LocalTime> horas){
        this.horasPico= horas;
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