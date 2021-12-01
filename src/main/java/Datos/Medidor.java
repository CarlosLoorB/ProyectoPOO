/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Personal.abonado;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author CAELOS JR 2018
 */
public class Medidor {
    private String codigo;
    private String direccion;
    private planEnergia plan;
    private abonado abonado;
    protected double consumo;
    protected double ultValor;
    protected LocalDate ultMedida;
    private ArrayList<factura> facturas;
    
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
     * Se implementa el get de facturas
     * @return las facturas
     */
    public ArrayList<factura> getFacturas() {
        return facturas;
    }
<<<<<<< HEAD
    

   public void agregarFactura(factura f){
=======
   
    /**
     * Se implementa el metodo de agregar facturas recibe la factura
     * @param f se va añadiendo a la lista de arreglos facturas. 
     */
    public void agregarFactura(factura f){
>>>>>>> e655080f071cf2da26b383309a3b2fe251523b81
       facturas.add(f);
   }
   
}
