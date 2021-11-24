package interfaz;

import Datos.registro;
import Personal.administrador;
import java.util.Scanner;
import Personal.user;
import java.time.LocalDateTime;
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
    
    public registro getDataBase(){
        return dataBase;
    }
    
    //no creo que la estructura del while esta bien hecha por eso lo comente pero eso lo dejaremos para cuando probemos el codigo
    public void menu() {
        System.out.println("Hola, bienvenido.");
        String op = "";
        //while(!op.equals("2")){
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
                   //se crea el nuevo usuario y cotrasena
                   //iniciarSesion();
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
        
    
    //no creo que la estructura del while esta bien hecha por eso lo comente pero eso lo dejaremos para cuando probemos el codigo
    public void iniciarSesionAdmin(int posicion){
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        administrador admin = (administrador)nuevo;
            //while(!op.equals("5")){
                int op = admin.menuOpc();
                switch(op){
                    case 1:
                        dataBase.setPlanes(admin.registrarPlan(dataBase.getPlanes(), admin));
                        break;
                    case 2 :
                        MedidoresUsuarios medidorcreado = admin.registrarMedidor(dataBase.getMedidores(), admin,dataBase.getUsuarios(), dataBase.getPlanes());
                        if (medidorcreado != null){
                        dataBase.setMedidores(medidorcreado.getMedidores());
                        dataBase.setUsuarios(medidorcreado.getUsuarios());
                        }
                        else{
                           System.out.println("Opcion no valida"); 
                        }
                        break;
                    case 3 :
                        System.out.println("Ingrese la fecha de inicio");
                        System.out.println("Ingrese la fecha de fin:");
                        admin.simularMedicion(LocalDateTime.MIN, LocalDateTime.MIN,dataBase);
                        break;
                    case 4:
                        break;
                    case 5 :
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;        
                }
    }
    
    public void iniciarSesionOper(int posicion){
        
    }
    
}  

