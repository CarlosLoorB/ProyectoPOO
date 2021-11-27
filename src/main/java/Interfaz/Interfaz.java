/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author CAELOS JR 2018
 */
import Datos.planEnergia;
import Datos.registro;
import Personal.abonado;
import Personal.administrador;
import Personal.operario;
import java.util.Scanner;
import Personal.user;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import resultadosConjuntos.MedidoresUsuarios;
/**
 *
 * @author gabri
 */

public class Interfaz {
    private Scanner sc;
    private registro dataBase;
    
    public Interfaz(){
        sc = new Scanner(System.in);
        dataBase = new registro();
    }
    
    public registro getRegistro(){
        return dataBase;
    }
    
    //no creo que la estructura del while esta bien hecha por eso lo comente pero eso lo dejaremos para cuando probemos el codigo
    public void menu() {
        System.out.println("Hola, bienvenido.");
        String op = "";
        while(!op.equals("2")){
        System.out.println("Ingrese su opcion");
        System.out.println("1: Iniciar sesion");
        System.out.println("2: Salir");
        op = sc.nextLine();
        switch(op){
            case "1":
                System.out.println("Ingrese su usuario:");
                String nombre = sc.nextLine();
                System.out.println("Ingrese su contrasena:");
                String contra = sc.nextLine();
                user log = new user(nombre,contra);
                int posicion = dataBase.getUsuarios().indexOf(log);
                System.out.println("La posicion es"+ posicion );
                if(posicion != -1){
                    int tipo= dataBase.tipoUsuario(posicion);
                    switch(tipo){
                        case 1:
                            iniciarSesionAdmin(posicion);
                        break;
                        case 2:
                            iniciarSesionOper(posicion); // Aun hay que crearlo
                        break;
                        case 3:
                            iniciarSesionAbon(posicion); //Aun hay que crearlos 
                        break;      
                    }
                }
                else{
                   System.out.println("La infromacion no es correcta ");
                }
            
                break;
            case "2":
                System.out.print("Saliendo...");
                break;
            default:
                System.out.println("Opcion no valida");
               break;
            } 
        }
    }
        
    
    //no creo que la estructura del while esta bien hecha por eso lo comente pero eso lo dejaremos para cuando probemos el codigo
    public void iniciarSesionAdmin(int posicion){
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        administrador admin = (administrador)nuevo;
        admin.menuOpc();
        int op =sc.nextInt();
        //creo que este while se debe de poner al incico del metodo, y en la linea de arriba debe ir un int op = 0
            while(op != 5){
                switch(op){
                    case 1:
                        dataBase.setPlanes(admin.registrarPlan(dataBase.getPlanes(), admin));
                        System.out.println("Se ha anadidio el plan");
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op =sc.nextInt();
                        break;
                    case 2 :
                        MedidoresUsuarios medidorcreado = admin.registrarMedidor(dataBase.getMedidores(), admin,dataBase.getUsuarios(), dataBase.getPlanes());
                        if (medidorcreado != null){
                        dataBase.setMedidores(medidorcreado.getMedidores());
                        dataBase.setUsuarios(medidorcreado.getUsuarios());
                        System.out.println("Se ha anadidio el medidor");
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op =sc.nextInt();
                        }
                        else{
                           System.out.println("Opcion no valida");
                           System.out.println("Que desea hacer");
                            admin.menuOpc();
                            op = sc.nextInt();
                        }
                        break;
                    case 3 :
                        System.out.println("Ingrese el dia de inicio");
                        int diaI = sc.nextInt();
                        System.out.println("Ingrese el mes de inicio");
                        int mesI = sc.nextInt();
                        System.out.println("Ingrese el ano de inicio");
                        int anoI = sc.nextInt();
                        System.out.println("Ingrese el dia de fin");
                        int diaF = sc.nextInt();
                        System.out.println("Ingrese el mes de fin");
                        int mesF = sc.nextInt();
                        System.out.println("Ingrese el ano de fin");
                        int anoF = sc.nextInt();
                        LocalDateTime horapicoI = LocalDateTime.of(anoI, mesI, diaI,0,0);
                        LocalDateTime horapicoF = LocalDateTime.of(anoF, mesF, diaF,0,0);
                        dataBase.setMedidores(admin.simularMedicion(horapicoI, horapicoF,dataBase));
                        System.out.println("Se ha creado las medicions");
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op =sc.nextInt();
                        break;
                    case 4:
                        break;
                    case 5 :
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;        
                }
                System.out.println("Saliendo");
            }
    }
    
     public void iniciarSesionOper(int posicion){
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        operario oper = (operario)nuevo;
        oper.menuOpc();
        int op = sc.nextInt();
            while(op != 2){
                switch(op){
                    case 1:
                        dataBase.setMedidores(oper.registrarMedicion(dataBase.getMedidores()));
                        System.out.println("Se ha registrado una nueva medicion.");
                        System.out.println("Que desea hacer");
                        oper.menuOpc();
                        op = sc.nextInt();
                        break;
                    case 2:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
                }
            }
        System.out.println("Saliendo");
     }
     
     public void iniciarSesionAbon(int posicion){
     System.out.println("sesion de abonado");
     }
     

}
            
            


