
package Datos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author kevaalci
 */
public class factura {
    private LocalDateTime fechaEmi;
    private LocalDate fecInicioLectura; //nuevo 
    private LocalDate fecFinalLectura; //nuevo
    private int numDiasFact;
    private Medidor Medidor;
    private planEnergia planEnergia;
    private double lecturaAnterior;
    private double lecturaActual;
    private String codigo; //nuevo
    private double valorPagar; // nuevo 
    private double cargoBase; //nuevo

     
    public factura(LocalDateTime fechasEmi,LocalDate fecIncicioLectura,LocalDate fecFinalLectura,int numDiasFact,Medidor Medidor,planEnergia planEnergia,String codigo, double valorPagar){
        this.fechaEmi=fechasEmi;
        this.fecInicioLectura=fecIncicioLectura;
        this.fecFinalLectura=fecFinalLectura;
        this.numDiasFact=numDiasFact;
        this.Medidor=Medidor;
        this.planEnergia=planEnergia;
        this.codigo= codigo;
        this.valorPagar = valorPagar;
    }
    
    public Medidor getMedidor(){
        return Medidor;
    }
    public LocalDateTime getEmision(){
        return fechaEmi;
    }
    
    public String getEmisionString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaSt = fechaEmi.format(formatter);
        return fechaSt;
    }
    
    public String getInicioString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaSt = fecInicioLectura.format(formatter);
        return fechaSt;
    }
    
    public LocalDate getfecFinalLectura(){
        return fecFinalLectura;
    }
    public String getFinString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaSt = fecFinalLectura.format(formatter);
        return fechaSt;
    }
    
    public void setValorPagarString(double Valor){
        this.valorPagar=Valor;
    }
    
    public void setcargoBaseString(double cargo){
        this.cargoBase = cargo;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setLecturaActual(double lectura){
        this.lecturaActual = lectura;
    }
    public void setLecturaAnterior(){
        this.lecturaAnterior = lecturaActual;
    }
    
    @Override
    public String toString(){
        return ("Medidor: "+Medidor.getCodigo()+"\nNombre del Plan: "+planEnergia.getNombrePlan()+"\nDesde: "+getInicioString()+"\nHasta: "+getFinString()+"\nDias facturados: "+numDiasFact+"\nLectura Anterior: "+lecturaAnterior+"\nLectura Actual: "+lecturaActual+"\nConsumo: "+(lecturaActual-lecturaAnterior)+"\nCargo fijo: $"+cargoBase+"\nTotala a pagar: $"+valorPagar);
    }
}

