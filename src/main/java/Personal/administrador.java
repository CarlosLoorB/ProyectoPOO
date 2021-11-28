/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Datos.Medidor;
import Datos.factura;
import Datos.medidorAnalogico;
import Datos.medidorInteligente;
import Datos.planEnergia;
import Datos.registro;
import Datos.telemetria;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import resultadosConjuntos.MedidoresUsuarios;
import org.apache.commons.lang3.RandomStringUtils;
//import Personal.abonado;

public class administrador extends user{
Scanner sc = new Scanner(System.in);
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
        System.out.println("Ingrese solo la hora del incicio de la hora pico");
        int inicioHPico = sc.nextInt();
        System.out.println("Ingrese el final de la hora pico");
        int finHPico = sc.nextInt();
        // agregar un if que confirme que todos los datos son validos 
        LocalTime horaPicoI = LocalTime.of(inicioHPico, 00 , 00);
        LocalTime horaPicoF = LocalTime.of(finHPico, 00 , 00);
        ArrayList<LocalTime> horapico = new ArrayList<>();
        horapico.add(horaPicoI);
        horapico.add(horaPicoF);
        planEnergia nuevoPlan = new planEnergia(nombrePlan, costoKw, cargoBase, horapico);
        System.out.println("El plan ha sido creado");
        if(planes.contains(nuevoPlan)){
        System.out.println("Ese Plan ya existe");
        return planes;
        //}
        }
        else
            planes.add(nuevoPlan);
        return planes;
    }
    
    public void menuOpc(){
        System.out.println("1. Registrar plan");
        System.out.println("2. Registra medidor");
        System.out.println("3. Simular mediciones");
        System.out.println("4. Realizar facturacion");
        System.out.println("5. Salir");
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
   
   //esto me debe devolver el array de medidores con las nuevas telemtrias credas y añadidas al medidor en cuestion 
   public ArrayList<Medidor> simularMedicion(LocalDateTime inicio, LocalDateTime fin, registro ui){
       ArrayList<telemetria> telem; //= new ArrayList<>();
       System.out.println("Fecha inicio:" + inicio);
       System.out.println("Fecha fin:" + fin);
       ArrayList<Medidor> med = ui.getMedidores();  
       for(int i=0;i<med.size();i++){
           Medidor n = med.get(i);
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
              m.setTelemetria(telem);
           }   
       }
       return med; 
   }
   
   public void realizarFacturacion(ArrayList<Medidor> medidoresPag){
        
       for(Medidor m: medidoresPag){
           int lfac = m.getFacturas().size();
           if(m.getFacturas().isEmpty()){
               planEnergia plan = m.getPlan();
               if(m instanceof medidorAnalogico){
                   medidorAnalogico ma = (medidorAnalogico)m;
                   double parcial = 0;
                   for(telemetria t: ma.getTelemetria()){ //duda sobre comprobacion de la fecha en la que se hace el metodo 
                       parcial = parcial + (plan.getcostoKW() * t.getconsumo());
                   }
                   double total = plan.getCargo() + parcial;
                   LocalDateTime fe = LocalDateTime.now();
                   int lon = ma.getTelemetria().size()-1;
                   LocalDateTime actu = ma.getTelemetria().get(lon).getFecha();
                   int dia1 = ma.getTelemetria().get(0).getFecha().getDayOfYear();
                   int diasF = LocalDateTime.now().getDayOfYear() - dia1;
                   factura fac = new factura(fe, actu, diasF, m, plan);
                   fac.setLecturaActual(ma.getTelemetria().get(lon).getconsumo());
                   fac.setLecturaAnterior();
                   m.agregarFactura(fac);
               // Aqui va lo de envio de correo
               } else {
                   double totalPico = 0;
                   double totalNP = 0;
                   medidorInteligente mi = (medidorInteligente) m;
                   for(telemetria t: mi.getTelemetria()){
                       int dthora = t.getFecha().getHour();
                       ArrayList<LocalTime> horasP = plan.getHoras();
                       for(LocalTime hora: horasP){
                           int h = hora.getHour();
                           if(dthora == h){
                              double consumoP = 2 * plan.getcostoKW() * mi.getConsumo();
                              totalPico = totalPico + consumoP;
                           } else {
                              double consumoNP = plan.getcostoKW() * mi.getConsumo();
                              totalNP = totalNP + consumoNP;
                              }  
                       }
                   }
                   double total = plan.getCargo() + totalPico + totalNP;
                   LocalDateTime fe = LocalDateTime.now();
                   int lon = mi.getTelemetria().size()-1;
                   LocalDateTime actu = mi.getTelemetria().get(lon).getFecha();
                   int dia1 = mi.getTelemetria().get(0).getFecha().getDayOfYear();
                   int diasF = LocalDateTime.now().getDayOfYear() - dia1;
                   factura fac = new factura(fe, actu, diasF, m, plan);
                   fac.setLecturaActual(mi.getTelemetria().get(lon).getconsumo());
                   fac.setLecturaAnterior();
                   m.agregarFactura(fac);
                   //Aqui va lo de envio de correo
                }
           } else {
               planEnergia plan = m.getPlan();
               if(m instanceof medidorAnalogico){
                   medidorAnalogico ma = (medidorAnalogico)m;
                   double parcial = 0;
                   for(telemetria t: ma.getTelemetria()){ //duda sobre comprobacion de la fecha en la que se hace el metodo 
                       if(t.getFecha().isAfter(m.getFacturas().get(lfac-1).getEmision())){
                         parcial = parcial + (plan.getcostoKW() * t.getconsumo());  
                       }
                   }
                   double total = plan.getCargo() + parcial;
                   LocalDateTime fe = LocalDateTime.now();
                   int lon = ma.getTelemetria().size()-1;
                   LocalDateTime actu = ma.getTelemetria().get(lon).getFecha();
                   int dia1 = ma.getTelemetria().get(0).getFecha().getDayOfYear();
                   int diasF = LocalDateTime.now().getDayOfYear() - dia1;
                   factura fac = new factura(fe, actu, diasF, m, plan);
                   fac.setLecturaActual(ma.getTelemetria().get(lon).getconsumo());
                   fac.setLecturaAnterior();
                   m.agregarFactura(fac);
               // Aqui va lo de envio de correo
               } else {
                   double totalPico = 0;
                   double totalNP = 0;
                   medidorInteligente mi = (medidorInteligente) m;
                   for(telemetria t: mi.getTelemetria()){
                       int dthora = t.getFecha().getHour();
                       ArrayList<LocalTime> horasP = plan.getHoras();
                       for(LocalTime hora: horasP){
                           int h = hora.getHour();
                           if(dthora == h){
                              double consumoP = 2 * plan.getcostoKW() * mi.getConsumo();
                              totalPico = totalPico + consumoP;
                           } else {
                              double consumoNP = plan.getcostoKW() * mi.getConsumo();
                              totalNP = totalNP + consumoNP;
                              }  
                       }
                   }
                   double total = plan.getCargo() + totalPico + totalNP;
                   LocalDateTime fe = LocalDateTime.now();
                   int lon = mi.getTelemetria().size()-1;
                   LocalDateTime actu = mi.getTelemetria().get(lon).getFecha();
                   int dia1 = mi.getTelemetria().get(0).getFecha().getDayOfYear();
                   int diasF = LocalDateTime.now().getDayOfYear() - dia1;
                   factura fac = new factura(fe, actu, diasF, m, plan);
                   fac.setLecturaActual(mi.getTelemetria().get(lon).getconsumo());
                   fac.setLecturaAnterior();
                   m.agregarFactura(fac);
                   //Aqui va lo de envio de correo
                   
                }
           }
       }
   }
}