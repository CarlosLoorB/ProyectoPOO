/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author CAELOS JR 2018
 */
import Datos.Medidor;
import Datos.medidorInteligente;
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
import java.util.Objects;
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
                        // validar para texto 
                        int d = 0;
                        int m = 0;
                        int df = 0;
                        int mf = 0;
                        do{
                        System.out.println("Ingrese el dia de inicio");
                        int diaI = sc.nextInt();
                        d = diaI;
                        }while(d<1 || d>31);
                        do{
                        System.out.println("Ingrese el mes de inicio");
                        int mesI = sc.nextInt();
                        m = mesI;
                        }while(m<1 || m>12);
                        System.out.println("Ingrese el ano de inicio");
                        int anoI = sc.nextInt();
                        do{
                        System.out.println("Ingrese el dia de fin");
                        int diaF = sc.nextInt();
                        df = diaF;
                        }while(d<1 || d>31);
                        do{
                        System.out.println("Ingrese el mes de fin");
                        int mesF = sc.nextInt();
                        mf = mesF;
                        }while(m<1 || m>12);
                        System.out.println("Ingrese el ano de fin");
                        int anoF = sc.nextInt();
                        LocalDateTime horapicoI = LocalDateTime.of(anoI, m, d,0,0);
                        LocalDateTime horapicoF = LocalDateTime.of(anoF, mf, df,0,0);
                        dataBase.setMedidores(admin.simularMedicion(horapicoI, horapicoF,dataBase));
                        System.out.println("Se ha creado las medicions");
                        medidorInteligente med = (medidorInteligente)(dataBase.getMedidores().get(2));
                        System.out.println(med.getTelemetria().size());
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op =sc.nextInt();
                        break;
                    case 4:
                        dataBase.setMedidores(admin.realizarFacturacion(dataBase.getMedidores()));
                        System.out.println("Se ha realizado la facturacion y se han enviado los correos");
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op =sc.nextInt();
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
                        ArrayList<Medidor> MedidoresConMedicion = oper.registrarMedicion(dataBase.getMedidores());
                        if(MedidoresConMedicion.size()!=0){
                        dataBase.setMedidores(MedidoresConMedicion);
                        System.out.println("Se ha registrado una nueva medicion.");
                        System.out.println("Que desea hacer");
                        oper.menuOpc();
                        op = sc.nextInt();
                        }
                        else{
                            System.out.println("Los valores son invalidos");
                            System.out.println("Que desea hacer");
                            oper.menuOpc();
                            op = sc.nextInt();
                        }
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
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        abonado abon = (abonado)nuevo;
        abon.menuOpc();
        int op =sc.nextInt();
        //creo que este while se debe de poner al incico del metodo, y en la linea de arriba debe ir un int op = 0
            while(op != 4){
                switch(op){
                    case 1:
                        abon.consultarFactura();
                        System.out.println("Se ha mostrado sus facturas.");
                        System.out.println("Que desea hacer");
                        abon.menuOpc();
                        op = sc.nextInt();
                        break;
                    case 2:
                        abon.historicoFacturado();
                        System.out.println("Se ha mostrado el historico.");
                        System.out.println("Que desea hacer");
                        abon.menuOpc();
                        op = sc.nextInt();
                        System.out.println("Saliendo");
                        break;
                        case 3:
                        //abon.consumoHora(LocalDateTime.MIN, LocalDateTime.MIN);
                        System.out.println("Se ha mostrado el historico.");
                        System.out.println("Que desea hacer");
                        abon.menuOpc();
                        op = sc.nextInt();
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
                    
                }}
     System.out.println("Saliendo al menu");
     }
     

}
            
            


