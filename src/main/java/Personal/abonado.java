/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personal;

import Datos.Medidor;
import Datos.factura;
import Datos.medidorInteligente;
import Datos.telemetria;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author CAELOS JR 2018
 */
public class abonado extends user{
    private ArrayList<Medidor> medidores;
    private String correo;
    
    /**
     * Se Implementa el metodo que ingresa la cédula, usuario, contrasena y correo 
     * @param cedula Se deriva del constructor de user  
     * @param usuario Se deriva del constructor de user
     * @param contrasena Se deriva del constructor de user
     * @param correo Se implementa para que no se tenga algun inconveniente a la hora de llamarla 
     */
    public abonado(String cedula,String usuario,String contrasena,String correo){
    super(cedula,usuario,contrasena);
    this.correo= correo;
    medidores= new ArrayList<>();
    }
    
    public abonado(String cedula,String usuario,String contrasena,String correo,Medidor medidorP){
    super(cedula,usuario,contrasena);
    this.correo= correo;
    medidores= new ArrayList<>();
    medidores.add(medidorP);
    }
    
    public ArrayList<Medidor> getMedidores(){
        return medidores;
    } 
    
    public void setMedidores(ArrayList<Medidor> a){
        this.medidores= a;
    } 
    
    public String getCorreo(){
        return correo;
    }
    
    public void consultarFactura(){
        Scanner sc = new Scanner(System.in);
        int cantTotalFacturas = 0;
        System.out.println("Facturas Asociadas");
        for (Medidor m : medidores){
            int cantidadFact = m.getFacturas().size();
            cantTotalFacturas= cantTotalFacturas + cantidadFact + 1;
        }
        final Object[][] table = new String[cantTotalFacturas][];
        table[0] = new String[]{"Numero de factura", "Fecha emision", "Codigo del medidor"};
        int numerocolumna= 1;
        for (Medidor m : medidores){
            ArrayList<factura> facturas = m.getFacturas();
            for ( int i=0;i<facturas.size();i++){
                factura f = facturas.get(i);
                table[numerocolumna] = new String[]{f.getCodigo(), f.getEmisionString(), f.getMedidor().getCodigo()};
                numerocolumna++; 
            }
        }
        System.out.println("Ingrese codigo de factura");
        String codeFacturaElegida = sc.nextLine();
        for (Medidor m : medidores){
            ArrayList<factura> facturas = m.getFacturas();
            for ( int i=0;i<facturas.size();i++){
                factura fact = facturas.get(i);
                if (fact.getCodigo().equals(codeFacturaElegida)){
                    System.out.println(fact.toString());
                }
            }
        }
        
    }
    
    public void historicoFacturado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Los medidores a su disposicion son");
        for (Medidor n : medidores){
                System.out.println(n.getCodigo());
            }
        System.out.println("Ingrese el codigo del medidor del cual desea ver sus facturas");
        String codigo = sc.nextLine();
        int impresiones = 0;
        for ( int i=0;i<medidores.size();i++){
            Medidor n = medidores.get(i);
            while (impresiones < 4) { //y si se le hace un do y while?  
                if ((n.getCodigo()).equals(codigo)) {
                    ArrayList<factura> listaFact = n.getFacturas();
                    final Object[][] table = new String[4][];
                    table[0] = new String[]{"Numero de factura", "Nombre del plan", "Codigo del medidor"};
                    for (int o = 1; o < 4; o++) {
                        factura fact = listaFact.get(o);
                        table[o] = new String[]{fact.getCodigo(), n.getPlan().getNombrePlan(), fact.getMedidor().getCodigo()};
                    }
                    for (final Object[] row : table) {
                        System.out.format("%15s%15s%15s\n", row);
                    }
                }
            }
            }
        }
    
    /*
    Ya esta avanzado, ya esta lo de mostrar todos los medidores y lo de recibir el codigo para elegir el medidor
    solo falta el calculo de los promedios.
    Yo estaba pensando hacer primero un for para recorrer las 24 horas y usar ese for para ver las telemetrias de dicha hora
    pero no se como creas conveniente hacerlo.
    No te olvides de ver si esta puesto en el menu el metodo
    */
    public void consumoHora(LocalDateTime fechaInicio, LocalDateTime fechaFin){
        Scanner sc = new Scanner(System.in);
        for(Medidor m: medidores){
           System.out.println("Los medidores inteligentes asociados son:"); 
           if(m instanceof medidorInteligente){
               System.out.println("Codigo medidor: " + m.getCodigo()); 
               System.out.println("Tipo de medidor: Inteligente");
               System.out.println("Nombre del plan: " + m.getPlan().getNombrePlan());
           }    
        }
        System.out.println("Ingrese el codigo del medidor a consultar: ");
        String codigo = sc.nextLine();
        for(Medidor m: medidores){
           if(m.getCodigo().equalsIgnoreCase(codigo)){
               medidorInteligente mi = (medidorInteligente) m;
               for(telemetria t: mi.getTelemetria()){
                   if((t.getFecha().isEqual(fechaInicio) || t.getFecha().isAfter(fechaInicio)) && (t.getFecha().isBefore(fechaFin) || t.getFecha().isEqual(fechaFin))){
                       
                   }
               }
           }
           
        }
        
    }
}   
    
    // Carlos Loor - este ya no sirve 
    /*
   public void historicoFacturado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Los medidores a su disposicion son");
        for (Medidor n : medidores){
                System.out.println(n.getCodigo());
            }
        System.out.println("Ingrese el codigo del medidor del cual desea ver sus facturas");
        String codigo = sc.nextLine();
        int impresiones = 0;
        for ( int i=0;i<medidores.size();i++){
            Medidor n = medidores.get(i);
            while (impresiones <4 ){ //y si se le hace un do y while?  
            if ((n.getCodigo()).equals(codigo)){
                ArrayList<factura> listaFact = n.getFacturas();
                
                for( int o=0;o<4;o++){
                    factura fact = listaFact.get(o);
                    System.out.println(fact.toString());
                }
            }
            }
        }
    }*/
