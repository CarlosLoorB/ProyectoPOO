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
/*
public class Interfaz {
    private Scanner sc;
    private registro dataBase;
    
    public Interfaz(){
        sc = new Scanner(System.in);
        dataBase = new registro();
        administrador administradorInicial = new administrador("0","admin","superadmin");
        operario operario1 = new operario("1","operario1","clave1");
        operario operario2 = new operario("2","operario2","clave2");
        LocalTime horapico1 = LocalTime.of(18, 00, 00);
        LocalTime horapico2 = LocalTime.of(20, 00, 00);
        ArrayList<LocalTime> horaspico1 = new ArrayList<>();
        ArrayList<LocalTime> horaspico2 = new ArrayList<>();
        horaspico1.add(horapico1);
        horaspico1.add(horapico2);
        planEnergia plan1 = new planEnergia("baraton",20d,10d,horaspico1);
        horaspico2.add(horapico1.plusHours(1));
        horaspico2.add(horapico2.plusHours(2));
        planEnergia plan2 = new planEnergia("mananero",18d,10d,horaspico2);
        abonado abonado1 = new abonado("3","abonado1","clave3","calobo2001@gmail.com");
        abonado abonado2 = new abonado("4","abonado2","clave4","calobo2001@gmail.com");
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
        int op = admin.menuOpc();
        //creo que este while se debe de poner al incico del metodo, y en la linea de arriba debe ir un int op = 0
            while(op != 5){
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
                        dataBase.setMedidores(admin.simularMedicion(LocalDateTime.MIN, LocalDateTime.MIN,dataBase));
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
        int op = oper.menuOpc();
        //creo que este while se debe de poner al incico del metodo, y en la linea de arriba debe ir un int op = 0
            while(op != 2){
                    if (op == 1){
                        dataBase.setMedidores(oper.registrarMedicion(dataBase.getMedidores()));
                        
                    }
            }
        System.out.println("Saliendo");
     }
     
     public void iniciarSesionAbon(int posicion){
     System.out.println("sesion de abonado");
     }
}
*/           
            

