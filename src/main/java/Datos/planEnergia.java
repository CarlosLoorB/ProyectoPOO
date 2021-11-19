package Datos;

import java.time.LocalDateTime;

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
    private LocalDateTime horas;
    
    public planEnergia(String nombrePlan, double costoKw, double cargoBase, LocalDateTime horaPico){
        this.nombrePlan= nombrePlan;
        this.cargo= cargoBase;
        this.costoKW= costoKw;
        this.horas= horaPico;
        
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
    
}