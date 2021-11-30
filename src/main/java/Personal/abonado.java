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
    
    public void historicoFacturado(ArrayList<factura> facturas){
        Scanner sc = new Scanner(System.in);
        System.out.println("Los medidores a su disposicion son");
        for (Medidor n : medidores){
            if ((n.getAbonado().cedula).equals(cedula)){
                System.out.println(n.getCodigo());
            }      
        }
        //hay que corregir
        System.out.println("Ingrese el codigo del medidor del cual desea ver sus facturas");
        String codigo = sc.nextLine();
        int impresiones = 0;
        for ( factura n : facturas){ // le voy a cambiar las variables las que solo tienen una vocal o alguna consonante 
            while (impresiones <4 ){ //y si se le hace un do y while?  
            if (((n.getMedidor()).getCodigo()).equals(codigo)){
                //hay que poner para que se imprima la factura en cuestion
                System.out.print(n);
                impresiones++;
            }
            }
        }
        if (impresiones == 0)
        System.out.println("Esas son sus facturas");
    }
}
