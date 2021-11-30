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
    * Se Implementa los get de cada constructor de abonado, dirección, tipoPlan, codigo, consumo, ultValor, ultMedida, facturas
    * es para que las variables se las puedan nombrar en otras clases
    * @return me retorna si el abonado ha ingreso bien los datos, la dreccion, el tipoPlan que se ha solicitado,las facturas.
    */
    
    public String getCodigo(){
        return codigo;
    }
    
    public double getValor() {
        return ultValor;
    }
    public abonado getAbonado() {
        return abonado;
    }
    public planEnergia getPlan(){
        return plan;
    }
    public double getConsumo(){
        return consumo;
    }
    public ArrayList<factura> getFacturas() {
        return facturas;
    }
    

   public void agregarFactura(factura f){
       facturas.add(f);
   }
   
}
