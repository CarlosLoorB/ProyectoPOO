/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personal;

import Datos.Medidor;
import java.util.ArrayList;

/**
 *
 * @author CAELOS JR 2018
 */
public class abonado extends user{
    private ArrayList<Medidor> medidores;
    private String correo;
    
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
}
