/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resultadosConjuntos;

import Datos.medidor;
import Personal.user;
import java.util.ArrayList;

/**
 *
 * @author CAELOS JR 2018
 */
public class MedidoresUsuarios {
    private ArrayList<user> usuarios;
    private ArrayList<medidor> medidores;
    
    public MedidoresUsuarios(ArrayList<user> usuarios,ArrayList<medidor> medidores){
        this.medidores=medidores;
        this.usuarios=usuarios;
    }
    
     public ArrayList<user> getUsuarios(){
        return usuarios;
    } 
    
     public ArrayList<medidor> getMedidores(){
        return medidores;
    } 
}

