/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personal;

import Datos.Medidor;
import Datos.factura;
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
