/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import interfaz.Interfaz;
import Datos.Medidor;
import Datos.medidorAnalogico;
import Datos.medidorInteligente;
import Datos.planEnergia;
import Datos.registro;
import Datos.telemetria;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import resultadosConjuntos.MedidoresUsuarios;
import org.apache.commons.lang3.RandomStringUtils;
//import Personal.abonado;

public class administrador extends user{
private Scanner sc;
    public administrador(String cedula,String usuario,String contrasena){
        super(cedula,usuario,contrasena);
    }
    // adentro del metodo se pediran las provinciastodas las cosas 
    public ArrayList<planEnergia> registrarPlan(ArrayList<planEnergia> planes,administrador admin){
        String repetir;
        System.out.println("Ingrese el nombre del plan");
        String nombrePlan = sc.nextLine();
        System.out.println("Ingrese el costo KwH");
        double costoKw = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el nombre de las provincias disponibles");
        //hacer esl sistema de toma de datos enum para las provincias 
        do{
        System.out.println("Desea ingresar otra provincia:");
        repetir = sc.nextLine().toUpperCase();
        if(repetir.equals("SI"))
            System.out.println("Ingrese el nombre de las provincias disponibles");
        //hacer el sistema de toma de datos enum para las provincias
        }
        while(repetir.equals("SI"));
        System.out.println("Ingrese el cargo base");
        double cargoBase = sc.nextDouble();
        //pedir el LocalTime en el cual se hace la hora pico 
        planEnergia nuevoPlan = new planEnergia(nombrePlan, costoKw, cargoBase, horaPico);
        if(planes.contains(nuevoPlan)){
        System.out.println("Ese Plan ya existe");
        return planes;
        }
        else
            planes.add(nuevoPlan);
        return planes;
    }
    
    public int menuOpc(){
        System.out.println("1. Registrar plan");
        System.out.println("2. Registra medidor");
        System.out.println("3. Simular mediciones");
        System.out.println("4. Realizar facturacion");
        System.out.println("5. Salir");
        int op = sc.nextInt();
        return op;
    }
    
   public MedidoresUsuarios registrarMedidor(ArrayList<Medidor> medidoresReg,administrador admin,ArrayList<user> abonados,ArrayList<planEnergia> planes){
        String repetir;
        System.out.println("Ingrese el numero de cedula del abonado");
        String numCedula = sc.nextLine();
        user abonTest = new user(numCedula);
        int posicionAbon = abonados.indexOf(abonTest);
                if(posicionAbon != -1){
                   user clienteUser =abonados.get(posicionAbon);
                   abonado cliente = (abonado)clienteUser;
                   System.out.println("Ingrese la direccion:");
                   String direccion = sc.nextLine();
                   System.out.println("Ingrese el plan:");
                   String nombrePlan = sc.nextLine();
                   planEnergia planTest = new planEnergia(nombrePlan);
                   int posicionPlan = planes.indexOf(planTest);
                   if(posicionPlan != -1){
                       planEnergia planAdd = planes.get(posicionPlan);
                       System.out.println("El tipo de Medidor es analogico o inteligente: ");
                       String tipoMedidor = sc.nextLine().toUpperCase();
                       if(tipoMedidor.equals("ANALOGICO")){
                           //GENERA UN NUMERO ALEATORIO Y REVISA QUE YA NO ESTE EN LA LSITA DE MEDIDORES,PONLE DE NOMBRE codigo
                           String codigo = RandomStringUtils.randomAlphanumeric(6);
                           medidorAnalogico medidorCreado= new medidorAnalogico(codigo,direccion,planAdd,cliente);
                           ArrayList<Medidor> listaCliente= cliente.getMedidores();
                           medidoresReg.add(medidorCreado);
                           listaCliente.add(medidorCreado);
                           cliente.setMedidores(listaCliente);
                           abonados.set(posicionAbon,cliente);
                           MedidoresUsuarios retorno = new MedidoresUsuarios(abonados,medidoresReg);
                           //aqui envias el correo 
                           return retorno;
                       }
                       else if(tipoMedidor.equals("INTELIGENTE")){
                           //GENERA UN NUMERO ALEATORIO Y REVISA QUE YA NO ESTE EN LA LSITA DE MEDIDORES,PONLE DE NOMBRE codigo
                           String codigo = RandomStringUtils.randomAlphanumeric(6);
                           medidorInteligente medidorCreado= new medidorInteligente(codigo,direccion,planAdd,cliente);
                           ArrayList<Medidor> listaCliente= cliente.getMedidores();
                           medidoresReg.add(medidorCreado);
                           listaCliente.add(medidorCreado);
                           cliente.setMedidores(listaCliente);
                           abonados.set(posicionAbon,cliente);
                           MedidoresUsuarios retorno = new MedidoresUsuarios(abonados,medidoresReg);
                           //aqui envias el correo 
                           return retorno;
                       }
                   }
                   else{
                     System.out.println("No existe el plan ");
                   }
                }
                else{
                    System.out.println("Se creara el abonado");
                    System.out.println("Ingrese el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el correo: ");
                    String correo = sc.nextLine();
                    String contrasena = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
                    abonado cliente = new abonado(numCedula,numCedula,contrasena,correo);
                    System.out.println("Ingrese la dreccion:");
                    String direccion = sc.nextLine();
                    System.out.println("Ingrese el plan:");
                    String nombrePlan = sc.nextLine();
                    planEnergia planTest = new planEnergia(nombrePlan);
                    int posicionPlan = planes.indexOf(planTest);
                    if(posicionPlan != -1){
                       planEnergia planAdd = planes.get(posicionPlan);
                       System.out.println("El tipo de Medidor es analogico o inteligente: ");
                       String tipoMedidor = sc.nextLine().toUpperCase();
                       if(tipoMedidor.equals("ANALOGICO")){
                           //GENERA UN NUMERO ALEATORIO Y REVISA QUE YA NO ESTE EN LA LSITA DE MEDIDORES,PONLE DE NOMBRE codigo
                           String codigo = RandomStringUtils.randomAlphanumeric(6);
                           medidorAnalogico medidorCreado= new medidorAnalogico(codigo,direccion,planAdd,cliente);
                           ArrayList<Medidor> listaCliente= cliente.getMedidores();
                           medidoresReg.add(medidorCreado);
                           listaCliente.add(medidorCreado);
                           cliente.setMedidores(listaCliente);
                           abonados.add(cliente);
                           MedidoresUsuarios retorno = new MedidoresUsuarios(abonados,medidoresReg);
                           //aqui envias el correo 
                           return retorno;
                           }
                       else if(tipoMedidor.equals("INTELIGENTE")){
                           //GENERA UN NUMERO ALEATORIO Y REVISA QUE YA NO ESTE EN LA LSITA DE MEDIDORES,PONLE DE NOMBRE codigo
                           String codigo = RandomStringUtils.randomAlphanumeric(6);
                           medidorInteligente medidorCreado= new medidorInteligente(codigo,direccion,planAdd,cliente);
                           ArrayList<Medidor> listaCliente= cliente.getMedidores();
                           medidoresReg.add(medidorCreado);
                           listaCliente.add(medidorCreado);
                           cliente.setMedidores(listaCliente);
                           abonados.set(posicionAbon,cliente);
                           MedidoresUsuarios retorno = new MedidoresUsuarios(abonados,medidoresReg);
                           //aqui envias el correo 
                           return retorno;
                       }
                    }
                    else{
                     System.out.println("No existe el plan ");
                   }
                }
          return null;
        }
   
   public ArrayList<telemetria> simularMedicion(LocalDateTime inicio, LocalDateTime fin, registro ui){
       ArrayList<telemetria> telem= new ArrayList<>();
       System.out.println("Fecha inicio:" + inicio);
       System.out.println("Fecha fin:" + fin);
       ArrayList<Medidor> med = ui.getMedidores();  
       for(Medidor n: med){
           if(n instanceof medidorInteligente){
              medidorInteligente m = (medidorInteligente)n;
              System.out.println("Lecturas para medidor con codigo" + m.getCodigo() + "con valor actual" + m.getValor() );
              System.out.println(m.getCodigo() + "," + inicio + "," + m.getValor());
              telem = m.getTelemetria();
              while(inicio != fin){
                  inicio = inicio.plusMinutes(10);
                  int tamano = telem.size();
                  telemetria elemento = telem.get(tamano - 1);
                  double valorInicial = elemento.getconsumo();
                  double consumoInventado = valorInicial + Math.random()*10;
                  telemetria telemNew = new telemetria(m.getCodigo(),inicio,consumoInventado);
                  System.out.println(m.getCodigo() + "," + inicio + "," + consumoInventado);
                  telem.add(telemNew);
              }     
           }   
       }
       return telem;
   }
   /*
   public void realizarFacturacion(){
       for(Medidor m: ())
           if(m instanceof medidorAnalogico){
               double totalPago = m.
           }
   }*/
}