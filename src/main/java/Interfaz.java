import Datos.registro;
import java.util.Scanner;
import Personal.*;
import java.time.LocalDateTime;
/**
 *
 * @author gabri
 */
public class Interfaz {
    private Scanner sc;
    private registro dataBase;
    
    public Interfaz(){
        sc = new Scanner(System.in);
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
                if(posicion != 1){
                    int tipo= database.tipoUsuario(posicion);
                    switch(tipo){
                        case 1:
                            iniciarSesionAdmin();
                            break;
                    }
                ) else{
                   se crea el nuevo usuario y cotrasena
                   iniciarSesion();
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
        String op = "";
            //while(!op.equals("5")){
                System.out.println("1. Registrar plan");
                System.out.println("2. Registra medidor");
                System.out.println("3. Simular mediciones");
                System.out.println("4. Realizar facturacion");
                System.out.println("5. Salir");
                op = sc.nextLine();
                switch(op){
                    case "1":
                        System.out.println("Ingrese el nombre del plan");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese el costo KwH");
                        double costo = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Ingrese el nombre de las provincias");
                        
                        System.out.println("Ingrese el cargo base");
                        double base = sc.nextDouble();
                        LocalDateTime pico = LocalDateTime.of(2018, 10, 10, 11, 25);

                      
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;        
                }
            }
    }  
}
