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
    
    /**
     * Se crea un constructor vacio del cual va a pedir por teclado en la base de datos.
     */
    public Interfaz(){
        sc = new Scanner(System.in);
        dataBase = new registro();
    }
    
    /**
     * Se implementea un get de registro que se dereiva de la clase registro
     * @return me retorna la base de datos de registro.
     */
    public registro getRegistro(){
        return dataBase;
    }
    
    /**
     * Se emplea el menu a mostrar donde se presentara un mensaje de bienvenida y las opciones que debe elegir entre entrar a sesion o salir
     * al seleccionar la opcion 1 se debe ingresar el usuario y contrasena el cual se verificara si el usuario y la contrasena existe
     * y a su vez verificara si el usuario ingresado pertenece al administrador, abonado u operario, en caso de no existir el usuario se 
     * imprimira un mensaje como "La informacion no es correcta", en caso de seleccionar la opcion 2 se saldra del programa.
     */
    
    //no creo que la estructura del while esta bien hecha por eso lo comente pero eso lo dejaremos para cuando probemos el codigo
    public void menu() {
        System.out.println("Hola, bienvenido.");
        String opm = "";
        while(!opm.equals("2")){
        System.out.println("Ingrese su opcion");
        System.out.println("1: Iniciar sesion");
        System.out.println("2: Salir");
        opm = sc.nextLine();
        switch(opm){
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
                            iniciarSesionOper(posicion); 
                        break;
                        case 3:
                            iniciarSesionAbon(posicion); 
                        break;      
                    }
                }
                else{
                   System.out.println("La informacion no es correcta ");
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
        
    /**
     * Se implementa el metodo de iniciarSessionAdmin ingresa con una posicion e indica si esta en la base de datos, al ser un administrador
     * tiene 5 opciones 
     * @param posicion 
     */
    //no creo que la estructura del while esta bien hecha por eso lo comente pero eso lo dejaremos para cuando probemos el codigo
    public void iniciarSesionAdmin(int posicion){
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        administrador admin = (administrador)nuevo;
        admin.menuOpc();
        int op =sc.nextInt();
            while(op != 5){
                switch(op){
                    case 1:
                        System.out.println(dataBase.getPlanes().size()); // borrar comprobacion 
                        dataBase.setPlanes(admin.registrarPlan(dataBase.getPlanes(), admin));
                        System.out.println("Se ha anadidio el plan");
                        System.out.println(dataBase.getPlanes().size()); //borrar comprobacion
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
                        LocalDateTime fechaI = LocalDateTime.of(anoI, m, d,0,0);
                        LocalDateTime fechaF = LocalDateTime.of(anoF, mf, df,0,0);
                        if (fechaI.isBefore(fechaF)){
                        dataBase.setMedidores(admin.simularMedicion(fechaI, fechaF,dataBase));
                        System.out.println("Se ha creado las medicion");
                        medidorInteligente med = (medidorInteligente)(dataBase.getMedidores().get(2));
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op =sc.nextInt();
                        }
                        else{
                            System.out.println("Se ingresado fechas incosistentes");
                            System.out.println("Que desea hacer");
                            admin.menuOpc();
                            op = sc.nextInt();
                        }
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
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op =sc.nextInt();
                        break;        
                }
                System.out.println("Saliendo");
            }
    }
    
    /**
     * se implementa 
     * @param posicion 
     */
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
                        System.out.println("Que desea hacer");
                            oper.menuOpc();
                            op = sc.nextInt();
                        break;
                }
            }
        System.out.println("Saliendo");
     }
    
    /**
     * Se implementa el metodo de iniciarSesionAbon del cual ingresa la posicion e indica si esta en la base de datos, al ser un Abonado
     * @param posicion 
     */
     public void iniciarSesionAbon(int posicion){
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        abonado abon = (abonado)nuevo;
        abon.menuOpc();
        
        int op =sc.nextInt();
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
                        LocalDateTime a = LocalDateTime.of(2021,11,12,00,00);
                        LocalDateTime b = LocalDateTime.of(2021,11,14,00,00);
                        abon.consumoHora(a,b);
                        System.out.println("Se ha mostrado el historico.");
                        System.out.println("Que desea hacer");
                        abon.menuOpc();
                        op = sc.nextInt();
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        System.out.println("Que desea hacer");
                        abon.menuOpc();
                        op = sc.nextInt();
                        break;
                    
                }}
     System.out.println("Saliendo al menu");
     }
}