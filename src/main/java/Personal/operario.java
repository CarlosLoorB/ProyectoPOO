/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personal;

import Datos.Medidor;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class operario extends user{
    
    public operario(String cedula,String usuario,String contrasena){
        super(cedula,usuario,contrasena);
    }
    
    public void registrarMedicion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del medidor");
        String codigo = sc.nextLine();
        for(Medidor m: medidores){
            
        }
    }
    
    /*
    String numCedula = sc.nextLine();
        user abonTest = new user(numCedula);
        int posicionAbon = abonados.indexOf(abonTest);
                if(posicionAbon != -1){
    */
}
