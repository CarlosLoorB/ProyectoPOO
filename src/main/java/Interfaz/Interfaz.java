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
    private static registro dataBase;

    /**
     * Se crea un constructor vacio del cual va a pedir por teclado en la base
     * de datos.
     */
    public Interfaz() {
        sc = new Scanner(System.in);
        dataBase = new registro();
    }

    /**
     * Se implementea un get de registro que se dereiva de la clase registro
     *
     * @return me retorna la base de datos de registro.
     */
    public registro getRegistro() {
        return dataBase;
    }

    /**
     * Se emplea el menu a mostrar donde se presentara un mensaje de bienvenida
     * y las opciones que debe elegir entre entrar a sesion o salir al
     * seleccionar la opcion 1 se debe ingresar el usuario y contrasena el cual
     * se verificara si el usuario y la contrasena existe y a su vez verificara
     * si el usuario ingresado pertenece al administrador, abonado u operario,
     * en caso de no existir el usuario se imprimira un mensaje como "La
     * informacion no es correcta", en caso de seleccionar la opcion 2 se saldra
     * del programa.
     */
    public void menu() {
        String opcionEntrada = "";
        while (!opcionEntrada.equals("2")) {
            opcionEntrada = mostrarMenuIncial(); //correcion 1
            realizarOpcion(opcionEntrada);
        }
    }

    public String mostrarMenuIncial() {  //correcion 1 extraer metodo 
        System.out.println("Hola, bienvenido.");
        System.out.println("Ingrese su opcion");
        System.out.println("1: Iniciar sesion");
        System.out.println("2: Salir");
        String opcionEntrada = sc.nextLine();
        return opcionEntrada;
    }

    public void realizarOpcion(String opcionEntrada) {
        switch (opcionEntrada) {
            case "1":
                inciarSesion();
                break;//correccion 2
            case "2":
                System.out.print("Saliendo...");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public void inciarSesion() {  //correccion 2 extraer metodo 
        int posicion = hallarUser();
        if (posicion != -1) {    //correcion 5  replace conditional with polymorfism 
            user Cliente = dataBase.getUsuarios().get(posicion);
            Cliente.inciarSesionAdmin(dataBase);
        } else {
            System.out.println("La informacion no es correcta ");
        }
    }
    
    public int hallarUser() {
        System.out.println("Ingrese su usuario:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su contrasena:");
        String contra = sc.nextLine();
        int posicion = dataBase.getUsuarios().indexOf(new user(nombre, contra)); //correccion 4 inline temp
        return posicion;
    }
    
    

    /**
     * Se implementa el metodo de iniciarSessionAdmin ingresa con una posicion e
     * indica si esta en la base de datos, al ser un administrador tiene 5
     * opciones
     *
     * @param posicion la posicion del user en la lista.
     */
    public void iniciarSesionAdmin(int posicion) {
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        administrador admin = (administrador) nuevo;
        admin.menuOpc();
        int op = sc.nextInt();
        while (op != 5) {
            switch (op) {
                case 1:
                    dataBase.setPlanes(admin.registrarPlan(dataBase.getPlanes(), admin));
                    System.out.println("Se ha anadidio el plan");
                    System.out.println("Que desea hacer");
                    admin.menuOpc();
                    op = sc.nextInt();
                    break;
                case 2:
                    MedidoresUsuarios medidorcreado = admin.registrarMedidor(dataBase.getMedidores(), admin, dataBase.getUsuarios(), dataBase.getPlanes());
                    if (medidorcreado != null) {
                        dataBase.setMedidores(medidorcreado.getMedidores());
                        dataBase.setUsuarios(medidorcreado.getUsuarios());
                        System.out.println("Se ha anadidio el medidor");
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op = sc.nextInt();
                    } else {
                        System.out.println("Opcion no valida");
                        System.out.println("Que desea hacer");
                        admin.menuOpc();
                        op = sc.nextInt();
                    }
                    break;
                case 3:
                    int d = 0;
                    int m = 0;
                    int df = 0;
                    int mf = 0;
                    System.out.println("Ingrese solo el dia de inicio como un numero:");
                    int diaI = sc.nextInt();
                    System.out.println("Ingrese el mes de inicio como un numero: ");
                    int mesI = sc.nextInt();
                    System.out.println("Ingrese el ano de inicio como un numero:");
                    int anoI = sc.nextInt();
                    System.out.println("Ingrese solo el dia de fin como un numero:");
                    int diaF = sc.nextInt();
                    System.out.println("Ingrese el mes de fin como un numero: ");
                    int mesF = sc.nextInt();
                    System.out.println("Ingrese el ano de fin como un numero");
                    int anoF = sc.nextInt();
                    if (dataBase.validarFecha(diaI, mesI, anoI) && dataBase.validarFecha(diaF, mesF, anoF)) {
                        LocalDateTime fechaI = LocalDateTime.of(anoI, mesI, diaI, 0, 0);
                        LocalDateTime fechaF = LocalDateTime.of(anoF, mesF, diaF, 0, 0);
                        if (fechaI.isBefore(fechaF)) {
                            dataBase.setMedidores(admin.simularMedicion(fechaI, fechaF, dataBase));
                            System.out.println("Se ha creado las medicion");
                            medidorInteligente med = (medidorInteligente) (dataBase.getMedidores().get(2));
                            System.out.println("Que desea hacer");
                            admin.menuOpc();
                            op = sc.nextInt();
                        } else {
                            System.out.println("Se ingresado fechas incosistentes");
                            System.out.println("Que desea hacer");
                            admin.menuOpc();
                            op = sc.nextInt();
                        }
                    } else {
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
                    op = sc.nextInt();
                    break;
                case 5:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    System.out.println("Que desea hacer");
                    admin.menuOpc();
                    op = sc.nextInt();
                    break;
            }
            System.out.println("Saliendo");
        }
    }

    /**
     * se implementa este metodo para iniciar sesion con el usuario de tipo
     * operario.
     *
     * @param posicion posicion del usuario.
     */
    public void iniciarSesionOper(int posicion) {
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        operario oper = (operario) nuevo;
        oper.menuOpc();
        int op = sc.nextInt();
        while (op != 2) {
            switch (op) {
                case 1:
                    ArrayList<Medidor> MedidoresConMedicion = oper.registrarMedicion(dataBase.getMedidores());
                    if (MedidoresConMedicion.size() != 0) {
                        dataBase.setMedidores(MedidoresConMedicion);
                        System.out.println("Se ha registrado una nueva medicion.");
                        System.out.println("Que desea hacer");
                        oper.menuOpc();
                        op = sc.nextInt();
                    } else {
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
     * Se implementa el metodo de iniciarSesionAbon del cual ingresa la posicion
     * e indica si esta en la base de datos, al ser un Abonado
     *
     * @param posicion posicion del user en la lista.
     */
    public void iniciarSesionAbon(int posicion) {
        int index = posicion;
        user nuevo = dataBase.getUsuarios().get(index);
        abonado abon = (abonado) nuevo;
        abon.menuOpc();
        int op = sc.nextInt();
        while (op != 4) {
            switch (op) {
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
                    int d = 0;
                    int m = 0;
                    int df = 0;
                    int mf = 0;
                    System.out.println("Ingrese solo el dia de inicio como un numero:");
                    int diaI = sc.nextInt();
                    System.out.println("Ingrese el mes de inicio como un numero: ");
                    int mesI = sc.nextInt();
                    System.out.println("Ingrese el ano de inicio como un numero:");
                    int anoI = sc.nextInt();
                    System.out.println("Ingrese solo el dia de fin como un numero:");
                    int diaF = sc.nextInt();
                    System.out.println("Ingrese el mes de fin como un numero: ");
                    int mesF = sc.nextInt();
                    System.out.println("Ingrese el ano de fin como un numero");
                    int anoF = sc.nextInt();
                    if (dataBase.validarFecha(diaI, mesI, anoI) && dataBase.validarFecha(diaF, mesF, anoF)) {
                        LocalDateTime fechaI = LocalDateTime.of(anoI, mesI, diaI, 0, 0);
                        LocalDateTime fechaF = LocalDateTime.of(anoF, mesF, diaF, 0, 0);
                        if (fechaI.isBefore(fechaF)) {
                            abon.consumoHora(fechaI, fechaF);
                            System.out.println("Se ha mostrado el historico.");
                            System.out.println("Que desea hacer");
                            abon.menuOpc();
                            op = sc.nextInt();
                            System.out.println("Saliendo");
                        } else {
                            System.out.println("Se ingresado fechas incosistentes");
                            System.out.println("Que desea hacer");
                            abon.menuOpc();
                            op = sc.nextInt();
                        }
                    } else {
                        System.out.println("Se ingresado fechas incosistentes");
                        System.out.println("Que desea hacer");
                        abon.menuOpc();
                        op = sc.nextInt();
                    }
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    System.out.println("Que desea hacer");
                    abon.menuOpc();
                    op = sc.nextInt();
                    break;

            }
        }
        System.out.println("Saliendo al menu");
    }
}
