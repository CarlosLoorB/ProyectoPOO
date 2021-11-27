
package Datos;

import java.time.LocalDate;


/**
 *
 * @author kevaalci
 */
public class factura {
    private LocalDate fechasEmi;
    private LocalDate fecLecturaAct;
    private int numDiasFact;
    private Medidor Medidor;
    private planEnergia planEnergia;
     
    public factura(LocalDate fechasEmi,LocalDate fecLecturaAct,int numDiasFact,Medidor Medidor,planEnergia planEnergia){
        this.fechasEmi=fechasEmi;
        this.fecLecturaAct=fecLecturaAct;
        this.numDiasFact=numDiasFact;
        this.Medidor=Medidor;
        this.planEnergia=planEnergia;
    }
    
    public Medidor getMedidor(){
        return Medidor;
    }
}

