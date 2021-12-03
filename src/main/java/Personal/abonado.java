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
    
    public void menuOpc(){
        System.out.println("1. Consultar factura");
        System.out.println("2. Consultar historico facturado");
        System.out.println("3. Consultar consumos por hora");
        System.out.println("4. Salir");
    }
    
    public abonado(String cedula,String usuario,String contrasena,String correo,Medidor medidorP){
    super(cedula,usuario,contrasena);
    this.correo= correo;
    medidores= new ArrayList<>();
    medidores.add(medidorP);
    }
    
    public abonado(String cedula,String usuario,String contrasena,String correo,ArrayList<Medidor> medidores){
    super(cedula,usuario,contrasena);
    this.correo= correo;
    this.medidores=medidores;
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
            System.out.println(cantidadFact);
            cantTotalFacturas= cantTotalFacturas + cantidadFact ;
            System.out.println(cantTotalFacturas);
        }
        final Object[][] table = new String[cantTotalFacturas + 1][];
        table[0] = new String[]{"Numero de factura", "Fecha emision", "Codigo del medidor"};
        int numerocolumna= 1;
        for (Medidor m : medidores){
            ArrayList<factura> facturas = m.getFacturas();
            for ( int i=0;i<facturas.size();i++){
                factura f = facturas.get(i);
                table[numerocolumna] = new String[]{f.getCodigo(),"  "+ f.getEmisionString(), "   "+ f.getMedidor().getCodigo()};
                numerocolumna++; 
            }
        }
        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s\n", row);
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
        boolean exists = false;//hasta aqui revisado
        for ( int i=0;i<medidores.size();i++){
            Medidor n = medidores.get(i);
            if ((n.getCodigo()).equals(codigo)) {
                System.out.println("Se buscara sus facturas");
                exists = true;
                final Object[][] table = new String[4][];
                while (impresiones < 4) { //y si se le hace un do y while?  
                    ArrayList<factura> listaFact = n.getFacturas();
                    table[0] = new String[]{"Numero de factura", "Nombre del plan", "Codigo del medidor"};
                    for (int o = 0; o<listaFact.size(); o++) {
                        factura fact = listaFact.get(o);
                        table[o+1] = new String[]{fact.getCodigo(), n.getPlan().getNombrePlan(), fact.getMedidor().getCodigo()};
                        impresiones++;
                    }
                    if(impresiones != 4)
                        impresiones = 4;
                }
                for (final Object[] row : table) {
                        System.out.format("%15s%15s%15s\n", row);
                    }
            }
        }
        if (!exists)//revisado
            System.out.println("Ingreso mal el codigo de medidor ");
        }
    
    /*
    Ya esta avanzado, ya esta lo de mostrar todos los medidores y lo de recibir el codigo para elegir el medidor
    solo falta el calculo de los promedios.
    Yo estaba pensando hacer primero un for para recorrer las 24 horas y usar ese for para ver las telemetrias de dicha hora
    pero no se como creas conveniente hacerlo.
    No te olvides de ver si esta puesto en el menu el metodo
    */
    public void consumoHora(LocalDateTime fechaInicio, LocalDateTime fechaFin){
        boolean medidorEncontrado = false;
        Scanner sc = new Scanner(System.in);
        int dias = fechaFin.getDayOfYear() - fechaInicio.getDayOfYear();
        System.out.println("Los medidores inteligentes asociados son:");
        int cantMedidoresI = 0;
        int nFila =1;
        for(Medidor m: medidores){
           if(m instanceof medidorInteligente){
               cantMedidoresI++;
               
           }
        }
        final Object[][] table = new String[cantMedidoresI + 1][];
        table[0] = new String[]{"Codigo medidor", "Tipo de medidor", "Nombre del plan"};
        for ( int i=0;i<medidores.size();i++){
           Medidor m = medidores.get(i); 
           if(m instanceof medidorInteligente){
               table[nFila] = new String[]{m.getCodigo(), "inteligente", m.getPlan().getNombrePlan()};
                nFila++;
           }    
        }
        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s\n", row);
        }
        ArrayList promedios = new ArrayList();
        final Object[][] table2 = new String[25][];
        int fila = 1;
        table2[0] = new String[]{"hora","promedio consumo"};
        System.out.println("Ingrese el codigo del medidor a consultar: ");
        String codigo = sc.nextLine();
        for(Medidor m: medidores){
           if(m.getCodigo().equalsIgnoreCase(codigo)){
               medidorEncontrado = true;
               if(medidorEncontrado == true){                                 
                   medidorInteligente mi = (medidorInteligente) m;
                   for (int h = 0; h <= 23; h = h + 1) {
                       double sumaHora = 0;
                       double consumoHoraAnterior = 0;
                       for (telemetria t : mi.getTelemetria()) {
                           if ((t.getFecha().isEqual(fechaInicio) || t.getFecha().isAfter(fechaInicio)) && (t.getFecha().isBefore(fechaFin) || t.getFecha().isEqual(fechaFin)) && (t.getFecha().getHour() == h)) {
                               if (consumoHoraAnterior == 0) {
                                   consumoHoraAnterior = t.getconsumo();
                               } else {
                                   sumaHora = sumaHora + (t.getconsumo() - consumoHoraAnterior);
                                   consumoHoraAnterior = t.getconsumo();
                               }
                           }
                       }
               table2[fila] = new String[]{h+":00-"+h+":59","    "+ String.valueOf(sumaHora/dias)};
               fila++;
               }
           } 
           } 

           
       }
                   if(medidorEncontrado == false){
                   System.out.println("Medidor no encontrado");
               } else {
               for (final Object[] row: table2) {
          System.out.format("%15s%15s\n", row);
      }  
           }
      
    }
}   