
package Datos;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 *
 * @author kevaalci
 */
public class factura {
    private LocalDateTime fechaEmi;
    private LocalDateTime fecLecturaAct;
    private int numDiasFact;
    private Medidor Medidor;
    private planEnergia planEnergia;
    private double lecturaAnterior;
    private double lecturaActual;
     
    public factura(LocalDateTime fechasEmi,LocalDateTime fecLecturaAct,int numDiasFact,Medidor Medidor,planEnergia planEnergia){
        this.fechaEmi=fechasEmi;
        this.fecLecturaAct=fecLecturaAct;
        this.numDiasFact=numDiasFact;
        this.Medidor=Medidor;
        this.planEnergia=planEnergia;
    }
    
    public Medidor getMedidor(){
        return Medidor;
    }
    public LocalDateTime getEmision(){
        return fechaEmi;
    }
    public void setLecturaActual(double lectura){
        this.lecturaActual = lectura;
    }
    public void setLecturaAnterior(){
        this.lecturaAnterior = lecturaActual;
    }
    
}

