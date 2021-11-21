/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personal;

import Datos.medidor;
import java.util.ArrayList;

/**
 *
 * @author CAELOS JR 2018
 */
public class abonado extends user{
    private ArrayList<medidor> medidores;
    private String correo;
    
    public abonado(String cedula,String usuario,String contrasena,String correo){
    super(cedula,usuario,contrasena);
    this.correo= correo;
    medidores= new ArrayList<>();
    }
    
    public abonado(String cedula,String usuario,String contrasena,String correo,medidor medidorP){
    super(cedula,usuario,contrasena);
    this.correo= correo;
    medidores= new ArrayList<>();
    medidores.add(medidorP);
    }
    
    public ArrayList<medidor> getMedidores(){
        return medidores;
    } 
    
    public void setMedidores(ArrayList<medidor> a){
        this.medidores= a;
    } 
}
