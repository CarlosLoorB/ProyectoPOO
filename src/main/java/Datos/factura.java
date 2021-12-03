
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
    
    /**
     * Se implementa un get de emision para que pueda se llamada en otra clase debido que esta de forma privada
     * @return me retornara la fecha de emision con formato LocalDateTime
     */
    public String getEmisionString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaSt = fechaEmi.format(formatter);
        return fechaSt;
    }
    
    /**
     * Retorna el inicio de la factura en forma de string.
     * @return string con el inicio.
     */
    public String getInicioString(){
        String fechaSt = fecInicioLectura.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        return fechaSt;
    }
    /**
     * Retorna la fecha del final de lectura de la factura.
     * @return LocalDate con el final de lectura.
     */
    public LocalDate getfecFinalLectura(){
        return fecFinalLectura;
    }
    /**
     * retorna la fecha y tiempo del inicio de lectura de la factura.
     * @return LocalDateTime de la fecha final de lectura.
     */
    public LocalDateTime getfecFinalLecturaTime(){
        LocalDateTime fechaFinal = fecFinalLectura.atTime(0,0, 0);       
        return fechaFinal;
    }
    /**
     * Regresa el string de la fecha final de la factura.
     * @return String con la fecha final.
     */
    public String getFinString(){
        String fechaSt = fecFinalLectura.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        return fechaSt;
    }
    /**
     * Este metodo estable el valor a pagar de la factura.
     * @param Valor valor a pagar.
     */
    public void setValorPagar(double Valor){
        this.valorPagar=Valor;
    }
    /**
     * este metodo establece el cargo base del plan en la factura.
     * @param cargo cargo base.
     */
    public void setcargoBase(double cargo){
        this.cargoBase = cargo;
    }
    /**3
     * retorna el codigo de la factura
     * @return String con el codigo de la factura.
     */
    public String getCodigo(){
        return codigo;
    }
    /**
     * Establece el valor de la lectura actual.
     * @param lectura valor de lectura
     */
    public void setLecturaActual(double lectura){
        this.lecturaActual = lectura;
    }
    /**
     * Establece la lectura anterior de la factura.
     * @param lecturaAc valor de la lectura.
     */
    public void setLecturaAnterior(double lecturaAc){
        this.lecturaAnterior = lecturaAc;
    }
    /**
     * Se implementa un get de lectura alctual
     * @return me retornara la lectura actual de consumo
     */
    public double getLecturaActual(){
        return lecturaActual;
    }
    /**
     * Se implementa un get de valor a pagar
     * @return me retornara el valor que se pagara por el consumo generado
     */
    public double getValorPagar(){
        return valorPagar;
    }
    /**
     * Retorna el valor de kW consumidos en forma de String
     * @return String con los kW.
     */
    public String kWConsumidos(){
        double valor = lecturaActual - lecturaAnterior;
        return String.valueOf(valor);
    }
    
    @Override
    /**
     * Se sobreescribe el metodo ToString 
     * @return retorna un a cadena de caracteres con la fecha de emision, nombre del plan, desde donde inicia la lectrura de facturacion y el final,
     * la lectura anterior, la lectura actual, el consumo, el cargo fijo  y el total a pagar
     */
    public String toString(){
        return ("Fecha Emision: "+ fechaEmi+"\nMedidor: "+Medidor.getCodigo()+"\nNombre del Plan: "+planEnergia.getNombrePlan()+
                "\nDesde: "+getInicioString()+"\nHasta: "+getFinString()+"\nDias facturados: "+numDiasFact+"\nLectura Anterior: "+
                lecturaAnterior+"\nLectura Actual: "+lecturaActual+"\nConsumo: "+(lecturaActual-lecturaAnterior)+"\nCargo fijo: $"
                +cargoBase+"\nTotala a pagar: $"+valorPagar);
    }
}

