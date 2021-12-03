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

    
    /**
     * Se crea el constructor de planEnergia que recibe el nombre del plan, el costo de kilovatios por hora,
     * el cargo base, una lista de arreglos de las horas picos y una lista de arreglos de las provincias
     * @param nombrePlan se implementa un this para tomar la  variable inicializa nombrePlan del cual esta de forma privada 
     * y la local nombrePlan no tenga algun incomendiente al ser llamada 
     * @param costoKw se implementa un this para tomar la  variable inicializa costoKW de forma privada y la local costoKw
     * no tenga algun incomendiente al ser llamada y realice la accion correspondida
     * @param cargoBase se implementa un this con la variable inicializa cargo y la local cargoBase no tenga algun incomendiente al ser llamada y realice la accion correspondida
     * @param horasPico se implementa un this para tomar la  variable inicializa y la local no tenga algun incomendiente al ser llamada y realice la accion correspondida
     * @param provinciaPlan se implementa un this para tomar la  variable inicializa y la local no tenga algun incomendiente al ser llamada y realice la accion correspondida
     */
    
    public planEnergia(String nombrePlan, double costoKw, double cargoBase, ArrayList<LocalTime> horasPico,ArrayList<Provincia> provinciaPlan){
        this.nombrePlan= nombrePlan;
        this.cargo= cargoBase;
        this.costoKW= costoKw;
        this.horasPico= horasPico;
        this.provinciaPlan=provinciaPlan;
    }
    
    /**
     * Se crea un constructor que solo recibe el nombre del plan
     * @param nombrePlan por medio del this la variable inicalizada nombrePlan de cual es de forma privada 
     * y la local nombrePlan no tenga ningun inconveniente al serla llamada por otra clase 
     */
    public planEnergia(String nombrePlan){
        this.nombrePlan= nombrePlan;
       
    }
    
    /**
     * Implementando un get como del nombre del plan parq que pueda ser llamado en otra clase
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
     * @param nombrePlan  es el valor de tipo String que se da a la variable local y a la de origen como son de tipo privada se utiliza el this
     * para que pueda se llamada en otra clase.
     */
    public void setNombrePlan(String nombrePlan){
        this.nombrePlan = nombrePlan;
    }
    /**
     * Seimplementa un set de costoKW
     * @param costoKW es el valor  de tipo double que se da a la variable local y a la de origen como son de tipo privada se utiliza el this
     * para que pueda se llamada en otra clase.
     */
    public void setCostoKW(double costoKW){
        this.costoKW = costoKW;
    }
    /**
     * Se implementa un set de cargo
     * @param cargo es el valor de tipo double que se da a la variable local y a la de origen como son de tipo privada se utiliza el this
     * para que pueda se llamada en otra clase.
     */
    public void setCargoBase(double cargo){
        this.cargo=cargo;
    }
    /**
     * Se implementa un set de las horas picos con formato LocalTime
     * @param horasPico es el valor de tipo de una lista de arreglos que se da a la variable local y a la de origen como son de tipo privada se utiliza el this
     * para que pueda se llamada en otra clase.
     */
    public void setHoras(ArrayList<LocalTime> horasPico){
        this.horasPico= horasPico;
    }
    
    /** 
     * Se verifica que los planes no tengan los mismos nombres con el metodo equals que es sobreescrito.
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
     * Se crea un constructor que recibe las provincias de tipo String
     * @param posibleProvincia es la variable que recibe y se verifica en la lista de arreglos de tipo String
     * @return retorna un booleano con el metodo constains del cual me indica ya sea True o false si existe en la lista 
     */
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