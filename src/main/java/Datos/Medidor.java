/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Personal.abonado;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *
 * @author CAELOS JR 2018
 */
public abstract class Medidor {
    private String codigo;
    private String direccion;
    private planEnergia plan;
    private abonado abonado;
    protected double consumo;
    protected double ultValor;
    protected LocalDate ultMedida;
    private ArrayList<factura> facturas;
    
    /**
     * Se crea un constructor donde ingresa un abonado, una direccion, un tipo de plan y codigo
     * @param codigo se utiliza el this para llamar la variable inicial que esta de forma privada y la local es para que no pueda tener ningun inconveniente al llamarla en otra clase
     * @param direccion se utiliza el this para llamar la variable inicial que esta de forma privada y la local es para que no pueda tener ningun inconveniente al llamarla en otra clase
     * @param plan se utiliza el this para llamar la variable inicial que esta de forma privada y la local es para que no pueda tener ningun inconveniente al llamarla en otra clase
     * @param abonado se utiliza el this para la inicializacion de la variable y de la local  llamade abonado y que se deriva de la clase abonado.
     * Se llama la variable consumo que esta de forma privada y se le da un valor predeterminado de cero.
     * Se llama la variable ultValor con un this ya que esta de forma privada y se le da un valor de cero.
     * Se llama la variable ultMedida con this  del cual indica la hora , dia actual.
     * Se llama la variable facturas con un this y se crea un nueva lista de arreglos vacia.
     */
    public Medidor(String codigo, String direccion, planEnergia plan, abonado abonado){
        this.codigo= codigo;
        this.direccion= direccion;
        this.plan= plan;
        this.abonado= abonado;
        this.consumo= 0;
        this.ultValor= 0;
        this.ultMedida= LocalDate.now();
        this.facturas = new ArrayList();
   }
   
    /**
     * Se implementa un metodo abstracto de tipo double del cual se ingresa el tipo de plan, el dthora, la hora, consumo anterior, total de hora pico y el total del nuevo precio
     * @param plan es llamado de la clase de planEnergia 
     * @param dthora es de tipo entero 
     * @param h es la hora y de tipo entero
     * @param t es la lista de arreglos del cual tiene el metodo de telemetria del cual se ingresa un codigo, fecha y consumo
     * @param consumoAnte es el consumo anterior del cual se genero y se guardo
     * @param totalPico es el total de las horas picos 
     * @param totalNP es el total del nuevo precio que se generará.
     * @return  retornara un valor de tipo double
     */
    public abstract double calcularTotalInteligente(planEnergia plan, int dthora, int h, telemetria t, double consumoAnte, double totalPico, double totalNP);
    
    /**
     * Se implementa un metodo abstracto llamado calculatTotalAnalogico del cual se utilizara en el medidorAnalogico del cual ingres un tipo de plan y un consumo 
     * @param plan es llamado de la clase de planEnergia
     * @param cargoPlan es el cargo que recibio del plan solicitado 
     * @return retornara un valor de tipo double.
     */
    public abstract double calcularTotalAnalogico(planEnergia plan, double cargoPlan);
    
    /**
     *Se Implementa el método equals debido que se quiere verificar que el codigo sea único
     * @param obj es de tipo objeto con el cual hace la comprobacion si el codigo que se ingreso es igual o diferente
     * @return retorna un booleano difiendo si la palabra es diferente o igual. 
     */
    
    public boolean equals(Object obj){
        if (obj instanceof Medidor){
            Medidor a = (Medidor)obj;
            if (codigo.equals(a.codigo)){
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
    * Se Implementa el get de codigo para que se pueda nombrar en otra clase
    * @return me retorna el codigo.
    */
    
    public String getCodigo(){
        return codigo;
    }
    /**
     * Se implementa el get valor
     * @return me retorna el ultimo valor 
     */
    public double getValor() {
        return ultValor;
    }
    /**
     * Se implementa el get de abonado para asi poderlo llamar en otras clases ya que es de modo privado
     * @return me retorna abonado 
     */
    public abonado getAbonado() {
        return abonado;
    }
    /**
     * Se implementa el get de plan del cual se llama de la clase planEnergia para saber los tipos de plan
     * @return me retorna plan 
     */
    public planEnergia getPlan(){
        return plan;
    }
    /**
     * Se implementa un get de consumo para que se pueda llamar en otras clases debido a que esta de forma privada
     * @return el consumo del cual sera el consumo que genera de acuerdo al plan de energia que se solicito.
     */
    public double getConsumo(){
        return consumo;
    }
    /**
     * Se implementa el get de facturas mediante una liata de arreglos con el metodo de factura
     * @return las facturas
     */
    public ArrayList<factura> getFacturas() {
        return facturas;
    }
    /**
     * Se implementa el metodo de agregar facturas recibe la factura
     * @param f se va añadiendo a la lista de arreglos facturas. 
     * En la lista de arreglos de facturas se añade el valor inicial cero y el la factura actual
     */
    public void agregarFactura(factura f){
        facturas.add(0, f);
    }
    
    /**
     * Se implementa un get de ultimaMedida que es de tipo LocalDate
     * @return  retorna un ultMedida
     */
    public LocalDate getUltimaMedida() {
        return ultMedida;
    }
    
    /**
     * Se implementa el metodo toString del cual podra ser llamado en otra clase 
     * @return me retorna una cadena de String del cual sera el codigo, direccion y el plan solicitado.
     */
    
    @Override
    public String toString(){
        return "codigo: " + codigo + " direccion: " + direccion + " plan: " + plan;
    }
}
