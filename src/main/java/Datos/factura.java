
package Datos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author kevaalci
 */
public class factura {
    private LocalDateTime fechaEmi;//
    private LocalDate fecInicioLectura; //
    private LocalDate fecFinalLectura; //
    private int numDiasFact;//
    private Medidor Medidor;//
    private planEnergia planEnergia;//
    private double lecturaAnterior;
    private double lecturaActual;
    private String codigo; //
    private double valorPagar; // 
    private double cargoBase;// 

    /**
     * Se crea un constructor que ingresa la fecha de emision, la fecha de inicio de la lectrura del medidor, la fecha final de la lectura,
     * el numero de dias que se facturara, Medidor, el planEnergia, el codigo y el valor que se pagara.
     * @param fechasEmi mediante el this se llama la variable inicalizada y la variable local para que pueda ser llamada sin ningun inconveniente
     * @param fecIncicioLectura  mediante el this se llama la variable inicalizada y la variable local para que pueda ser llamada sin ningun inconveniente
     * @param fecFinalLectura  mediante el this se llama la variable inicalizada y la variable local para que pueda ser llamada sin ningun inconveniente
     * @param numDiasFact  mediante el this se llama la variable inicalizada y la variable local para que pueda ser llamada sin ningun inconveniente
     * @param Medidor  mediante el this se llama la variable inicalizada y la variable local para que pueda ser llamada sin ningun inconveniente
     * @param planEnergia  mediante el this se llama la variable inicalizada y la variable local para que pueda ser llamada sin ningun inconveniente
     * @param codigo  mediante el this se llama la variable inicalizada y la variable local para que pueda ser llamada sin ningun inconveniente
     * @param valorPagar  mediante el this se llama la variable inicalizada y la variable local para que pueda ser llamada sin ningun inconveniente
     */ 
    
    public factura(LocalDateTime fechasEmi,LocalDate fecIncicioLectura,LocalDate fecFinalLectura,int numDiasFact,
            Medidor Medidor,planEnergia planEnergia,String codigo, double valorPagar){
        this.fechaEmi=fechasEmi;
        this.fecInicioLectura=fecIncicioLectura;
        this.fecFinalLectura=fecFinalLectura;
        this.numDiasFact=numDiasFact;
        this.Medidor=Medidor;
        this.planEnergia=planEnergia;
        this.codigo= codigo;
        this.valorPagar = valorPagar;
    }
    
    /**
     * Se implementa un get Medidor para que pueda ser llamada en otras clases
     * @return me retorna un Medidor
     */
    public Medidor getMedidor(){
        return Medidor;
    }
    /**
     * Se implementa un get de emision para que pueda se llamada en otra clase debido que esta de forma privada
     * @return me retornara la fecha de emision con formato LocalDateTime
     */
    public LocalDateTime getEmision(){
        return fechaEmi;
    }
    
    public String getEmisionString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaSt = fechaEmi.format(formatter);
        return fechaSt;
    }
    
    public String getInicioString(){
        String fechaSt = fecInicioLectura.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        return fechaSt;
    }
    
    public LocalDate getfecFinalLectura(){
        return fecFinalLectura;
    }
    
    public LocalDateTime getfecFinalLecturaTime(){
        LocalDateTime fechaFinal = fecFinalLectura.atTime(0,0, 0);       
        return fechaFinal;
    }
    
    public String getFinString(){
        String fechaSt = fecFinalLectura.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        return fechaSt;
    }
    
    public void setValorPagar(double Valor){
        this.valorPagar=Valor;
    }
    
    public void setcargoBase(double cargo){
        this.cargoBase = cargo;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setLecturaActual(double lectura){
        this.lecturaActual = lectura;
    }
    public void setLecturaAnterior(double lecturaAc){
        this.lecturaAnterior = lecturaAc;
    }
    
    public double getLecturaActual(){
        return lecturaActual;
    }
    
    @Override
    public String toString(){
        return ("Fecha Emision: "+ fechaEmi+"\nMedidor: "+Medidor.getCodigo()+"\nNombre del Plan: "+planEnergia.getNombrePlan()+
                "\nDesde: "+getInicioString()+"\nHasta: "+getFinString()+"\nDias facturados: "+numDiasFact+"\nLectura Anterior: "+
                lecturaAnterior+"\nLectura Actual: "+lecturaActual+"\nConsumo: "+(lecturaActual-lecturaAnterior)+"\nCargo fijo: $"
                +cargoBase+"\nTotala a pagar: $"+valorPagar);
    }
}

