package Datos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayList<Provincia> provinciaPlan;

    
    public planEnergia(String nombrePlan, double costoKw, double cargoBase, ArrayList<LocalTime> horasPico,ArrayList<Provincia> provinciaPlan){
        this.nombrePlan= nombrePlan;
        this.cargo= cargoBase;
        this.costoKW= costoKw;
        this.horasPico= horasPico;
        this.provinciaPlan=provinciaPlan;
    }
    
    public planEnergia(String nombrePlan){
        this.nombrePlan= nombrePlan;
       
    }
    
    /**
     * Implementando los gets de cada constructor del nombre del plan
     * para que se pueda llamar el constructor porque están de forma privada.
     * @return  va a retornar el nombre del plan. 
     */
    
    public String getNombrePlan(){
        return nombrePlan;
    }
    /**
     * Se implementa el get de costoKW para que pueda ser llamado en otra clase
     * @return  el costoKW
     */
    public double getcostoKW(){
        return costoKW;
    }
    /**
     * Se implementa el get de cargo para que pueda ser llamado en otra clase
     * @return retorna el cargo
     */
    public double getCargo(){
        return cargo;
    }
    /**
     * Se implementa el get de las Horas picos para que pueda ser llamado en otra clase
     * @return me retornara las horas picos 
     */
    public ArrayList<LocalTime> getHoras(){
        return horasPico;
    }
    
    /**
     * Se implementa un set del nombrePlan 
     * @param nombrePlan mediante un this se llama la variable nombreplan para que no haya algun con la variable de iniciacion y la local
     */
    public void setNombrePlan(String nombrePlan){
        this.nombrePlan = nombrePlan;
    }
    /**
     * Seimplementa un set de costoKW
     * @param costoKW mediante un this se llama la variable nombreplan para que no haya algun con la variable de iniciacion y la local
     */
    public void setCostoKW(double costoKW){
        this.costoKW = costoKW;
    }
    /**
     * Se implementa un set de cargo
     * @param cargo mediante un this se llama la variable nombreplan para que no haya algun con la variable de iniciacion y la local
     */
    public void setCargoBase(double cargo){
        this.cargo=cargo;
    }
    /**
     * Se implementa un set de las horas picos con formato LocalTime
     * @param horasPico mediante un this se llama la variable nombreplan para que no haya algun con la variable de iniciacion y la local
     */
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
    
    public boolean esProvincia(String posibleProvincia){
        ArrayList<String> Provincias = new ArrayList<>(Arrays.asList("AZUAY", "BOLIVAR", "CANIAR", "CARCHI", "CHIMBORAZO", "COTOPAXI", "EL_ORO", "ESMERALDAS", "GALAPAGOS", 
        "GUAYAS", "IMBABURA", "LOJA", "LOS_RIOS", "MANABI", "MORONA_SANTIAGO", "NAPO","ORELLANA","PASTAZA",
        "PICHINCHA", "SANTA_ELENA", "SANTO_DOMINGO_DE_LOS_TSACHILAS","SUCUMBIOS", "TUNGURAHUA", "ZAMORA_CHINCHIPE"));
        return Provincias.contains(posibleProvincia);
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