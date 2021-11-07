package Datos;

/**
 *
 * @author kevaalci
 */
public class planEnergia {
    private String nombrePlan;
    private double costoKW;
    private String cargo;
    private double horas;
    
    public String getNombrePlan(){
        return nombrePlan;
    }
    public double getcostoKW(){
        return costoKW;
    }
    public String getCargo(){
        return cargo;
    }
    public double horas(){
        return horas;
    }
    public void setNombrePlan(String nombrePlan){
        this.nombrePlan = nombrePlan;
    }
    public void setCostoKW(double costoKW){
        this.costoKW = costoKW;
    }
    public void setHoras(double horas){
        this.horas= horas;
    }
    
}