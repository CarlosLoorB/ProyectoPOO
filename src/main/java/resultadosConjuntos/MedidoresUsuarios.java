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
    
    /**
     * Se implementa un constructor del cual recibe una lista de arreglos de usuarios y de medidores
     * @param usuarios por medio de this la variable inicial y  la de local no tenga algun inconventiente
     * @param medidores por medio de this la variable inicial y  la de local no tenga algun inconventiente
     */
    public MedidoresUsuarios(ArrayList<user> usuarios,ArrayList<Medidor> medidores){
        this.medidores=medidores;
        this.usuarios=usuarios;
    }
    
    /**
     * Se implementa un get usuarios para que pueda ser llamada en otra clase
     * @return me retornara los  usuarios
     */
    public ArrayList<user> getUsuarios(){
        return usuarios;
    } 
    
    /**
     * Se implementan un get de medidores para qu pueda ser llamada en otras clases
     * @return retorna medidores
     */
     public ArrayList<Medidor> getMedidores(){
        return medidores;
    } 
}

