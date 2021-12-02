/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personal;

import Datos.Medidor;
import Datos.medidorAnalogico;
import Datos.medidorInteligente;
import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class operario extends user{
    private Scanner sc;
            
    public operario(String cedula,String usuario,String contrasena){
        super(cedula,usuario,contrasena);
    }
    
    public void menuOpc(){
        System.out.println("1. Registrar medicion");
        System.out.println("2. Salir");
    }
    
    public ArrayList<Medidor> registrarMedicion(ArrayList<Medidor> medidoresPag){
        ArrayList<Medidor> nosalio = new ArrayList<>();
        int posMedidor= -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del medidor");
        String codigo = sc.nextLine();
        for(int i=0;i<medidoresPag.size();i++){
        Medidor n = medidoresPag.get(i);
        if (n.getCodigo().equals(codigo))
            posMedidor= i;
        }     
        if(posMedidor != -1){
            Medidor medidor = medidoresPag.get(posMedidor);
            if(medidor instanceof medidorAnalogico){
                medidorAnalogico medidorReg = (medidorAnalogico)medidor;
                System.out.println("Ingrese el valor del medidor");
                String ultValorTxt = sc.nextLine();
                if (!(Objects.isNull(Doubles.tryParse(ultValorTxt)))){
                double ultValor =Doubles.tryParse(ultValorTxt);          
                medidorReg.registrarMedicion(ultValor);
                medidoresPag.set(posMedidor,medidorReg);
                return medidoresPag ;
                }
                else{
                System.out.println("El valor ingresado no es valido");
                return nosalio; 
                }
            }
            else{
                System.out.println("El medidor no es analogico");
                return nosalio;
            }
        }
        else{
            System.out.println("No existe ese medidor");
            return nosalio;
        }          
    }
    
    /*
    String numCedula = sc.nextLine();
        user abonTest = new user(numCedula);
        int posicionAbon = abonados.indexOf(abonTest);
                if(posicionAbon != -1){
    */
}
