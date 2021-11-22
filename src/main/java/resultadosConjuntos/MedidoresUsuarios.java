/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resultadosConjuntos;

import Datos.Medidor;
import Personal.user;
import java.util.ArrayList;

/**
 *
 * @author CAELOS JR 2018
 */
public class MedidoresUsuarios {
    private ArrayList<user> usuarios;
    private ArrayList<Medidor> medidores;
    
    public MedidoresUsuarios(ArrayList<user> usuarios,ArrayList<Medidor> medidores){
        this.medidores=medidores;
        this.usuarios=usuarios;
    }
    
     public ArrayList<user> getUsuarios(){
        return usuarios;
    } 
    
     public ArrayList<Medidor> getMedidores(){
        return medidores;
    } 
}

