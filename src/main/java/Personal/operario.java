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
    
    /**
     * Se crea un contructor que ingrese la cedula, usuario y contrasena
     * @param cedula mediante un super que se deriva de la clase user se coloca la cedula
     * @param usuario mediante un super que se deriva de la clase user se coloca el usuario
     * @param contrasena mediante un super que se deriva de la clase user se coloca la contrasena 
     * para que no haya ningun inconveniente al ser llamada 
     */
    public operario(String cedula,String usuario,String contrasena){
        super(cedula,usuario,contrasena);
    }
    /**
     * Se implementa un metodo que imprima las opciones al seleccionar operacion lo cuales son registrar medicion o salir del sistema.
     */
    public void menuOpc(){
        System.out.println("1. Registrar medicion");
        System.out.println("2. Salir");
    }
    
    /**
     * Se crea un metodo que se registra la medicion y entra una lista de arreglos
     * Se crea una nueva lista llamada nosalio para indicar el medidor esta o no esta en la lista de arreglos
     * se crea una variable posMedidor con valor de -1
     * Se pide por teclado que ingrese el codigo del medidor para verificar si esta en la lista de arreglod medidoresPag con el punto size
     * Se llama la clase Medidor y se crea la variable n del cual me indicara la posicion en la lista de arreglo
     * Mediante un if se verifica con el getCodigo es el mismo codigo que se pidio por teclado
     * @param medidoresPag indica si el codigo ingresado se halla en el arreglo de Medidor
     * @return me retorna si la variable nosalio esta o no en la lista de arreglos de medidorAnalogico 
     */
    public ArrayList<Medidor> registrarMedicion(ArrayList<Medidor> medidoresPag){
        ArrayList<Medidor> nosalio = new ArrayList<>();
        int posMedidor= -1;
        Scanner sc = new Scanner(System.in);  //redundante
        System.out.println("Ingrese el codigo del medidor");
        String codigo = sc.nextLine();
        for(int i=0;i<medidoresPag.size();i++){
        Medidor n = medidoresPag.get(i);
        if (n.getCodigo().equals(codigo))  //se usaria el index of y ya se tiene el medidor
            posMedidor= i;
        }     
        if(posMedidor != -1){
            Medidor medidor = medidoresPag.get(posMedidor);
            if(medidor instanceof medidorAnalogico){
                medidorAnalogico medidorReg = (medidorAnalogico)medidor;
                System.out.println("Ingrese el valor del medidor");  ///hacer esto una funcion aparte 
                String ultValorTxt = sc.nextLine();
                if (!(Objects.isNull(Doubles.tryParse(ultValorTxt)))){
                double ultValor =Doubles.tryParse(ultValorTxt);  // que retorne este valor         
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
    

}
