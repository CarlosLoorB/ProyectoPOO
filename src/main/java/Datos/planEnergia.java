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
    
    /**
     * Implementando los gets de cada constructor del nombre del plan, los costos de los kilovateos que ha consumido, 
     * el cargo base es de tipo double, las horas pico son con formato LocalDateTime
     * para que se pueda llamar el constructor porque están de forma privada.
     * @return  va a retornar el nombre del plan, el costoKw, cargo base con el que comienza el plan, lista de las horaspico 
     */
    
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
    public void setCargoBase(double cargo){
        this.cargo=cargo;
    }
    public void setHoras(ArrayList<LocalTime> horasPico){
        this.horasPico= horasPico;
    }
    
    /** 
     * / Se verifica que los planes no tengan los mismos nombres 
     * @param obj al utilizar equals obtendré que verificar mi instancia de tipo objeto 
     * @return me retorna un booleano indicandome si el planEnergia tiene el mismo nombre
     */
    
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
    
    /**
     * Se creo un enum de provincias debido a que es un dato especial y no se repite ya que
     * las provincias ya estan definidas y no se podrán cambiar 
     */
    public enum Provincia{
        AZUAY, BOLIVAR, CANIAR, CARCHI, CHIMBORAZO, COTOPAXI, EL_ORO, ESMERALDAS, GALAPAGOS, 
        GUAYAS, IMBABURA, LOJA, LOS_RIOS, MANABI, MORONA_SANTIAGO, NAPO,ORELLANA,PASTAZA,
        PICHINCHA, SANTA_ELENA, SANTO_DOMINGO_DE_LOS_TSACHILAS,SUCUMBIOS, TUNGURAHUA, ZAMORA_CHINCHIPE
        
    }
    
}