/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Datos.Medidor;
import Datos.correo;
import Datos.factura;
import Datos.medidorAnalogico;
import Datos.medidorInteligente;
import Datos.planEnergia;
import Datos.planEnergia.Provincia;
import Datos.registro;
import Datos.telemetria;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import resultadosConjuntos.MedidoresUsuarios;
import org.apache.commons.lang3.RandomStringUtils; 

public class administrador extends user{
    Scanner sc = new Scanner(System.in);
    
    /**
     * Crea un nuevo objeto de tipo administrador
     * @param cedula cedula del administrador.
     * @param usuario usuario del administrador.
     * @param contrasena constrasena del administrador.
     */
    public administrador(String cedula,String usuario,String contrasena){
        super(cedula,usuario,contrasena);
    }
    /**
     * Este metodo permite la creacion de un nuevo plan y lo devuelve.
     * @param planes la lista de los planes presentes en el registro.
     * @param admin el usuario de administrador.
     * @return una lista actualizada de planes con los que han sido creados.
     */
    public ArrayList<planEnergia> registrarPlan(ArrayList<planEnergia> planes,administrador admin){
        ArrayList<Provincia> planProvincias = new ArrayList<>();
        ArrayList<LocalTime> horapico = new ArrayList<>();
        String repetir;
        System.out.println("Ingrese el nombre del plan");
        System.out.println("Recuerde que son importantes las mayusculas y minusculas");
        String nombrePlan = sc.nextLine();
        System.out.println("Ingrese el costo KwH");
        double costoKw = sc.nextDouble();
        sc.nextLine();
        do {

            System.out.println("Ingrese el nombre de las provincias disponibles");
            String posibleProvincia1 = sc.nextLine().toUpperCase();
            String posibleProvincia = posibleProvincia1.replace(" ", "_");
            ArrayList<String> Provincias = new ArrayList<>(Arrays.asList("AZUAY", "BOLIVAR", "CANIAR", "CARCHI", "CHIMBORAZO", "COTOPAXI", "EL_ORO", "ESMERALDAS", "GALAPAGOS",
                    "GUAYAS", "IMBABURA", "LOJA", "LOS_RIOS", "MANABI", "MORONA_SANTIAGO", "NAPO", "ORELLANA", "PASTAZA",
                    "PICHINCHA", "SANTA_ELENA", "SANTO_DOMINGO_DE_LOS_TSACHILAS", "SUCUMBIOS", "TUNGURAHUA", "ZAMORA_CHINCHIPE"));
            if (Provincias.contains(posibleProvincia)) {
                Provincia provinciaAnadir= Provincia.valueOf(posibleProvincia);
                planProvincias.add(provinciaAnadir);
            }
            System.out.println("Desea ingresar otra provincia:");
            repetir = sc.nextLine().toUpperCase();
        } while (repetir.equals("SI"));
        System.out.println("Ingrese el cargo base");
        double cargoBase = sc.nextDouble();
        do{
        System.out.println("Ingrese solo la hora de incicio de la hora pico:");
        System.out.println("Formato 24Hrs");
        int inicioHPico = sc.nextInt();
        if (inicioHPico >= 0 && inicioHPico <=24 ){
        LocalTime horaPicoI = LocalTime.of(inicioHPico, 00, 00);
        horapico.add(horaPicoI);
        }
        else{
           System.out.println("La hora no es valida"); 
        }
        System.out.println("Desea ingresar otra hora:");
            repetir = sc.nextLine().toUpperCase();
            if (!(repetir.equals("SI") || repetir.equals("NO") ))
                System.out.println("No es un comando valido, se seguira con el proceso");
        }
        while(repetir.equals("SI"));
        planEnergia nuevoPlan = new planEnergia(nombrePlan, costoKw, cargoBase, horapico,planProvincias);
        System.out.println("El plan ha sido creado");
        if (planes.contains(nuevoPlan)) {
            System.out.println("Ese Plan ya esta agregado");
            return planes;          
        } else {
            planes.add(nuevoPlan);
        }
        return planes;
    }
    /**
     * Muestra las opciones disponibles para el administrador.
     */
    public void menuOpc(){
        System.out.println("1. Registrar plan");
        System.out.println("2. Registra medidor");
        System.out.println("3. Simular mediciones");
        System.out.println("4. Realizar facturacion");
        System.out.println("5. Salir");
    }
    /**
     * Se implementa el metododo registrar Medidor el cual pide un ArrayList Medidor, administrador, ArrayList user, ArrayList lanEnergia
     * @param medidoresReg son los medidores presentes en el registro
     * @param admin es el usuario de administrador
     * @param abonados es la lista de los abonados en el registro
     * @param planes la lista de los planes presentes en el registro
     * @return retorna medidoresUsuarios que es un objeto con una lista de medidores y una lista de usuarios
     */
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
                           String codigo = RandomStringUtils.randomAlphanumeric(6);
                           medidorAnalogico medidorCreado= new medidorAnalogico(codigo,direccion,planAdd,cliente);
                           ArrayList<Medidor> listaCliente= cliente.getMedidores();
                           medidoresReg.add(medidorCreado);
                           listaCliente.add(medidorCreado);
                           cliente.setMedidores(listaCliente);
                           abonados.set(posicionAbon,cliente);
                           MedidoresUsuarios retorno = new MedidoresUsuarios(abonados,medidoresReg);
                           Medidor med = (Medidor) medidorCreado;
                           correo.enviarCorreo(cliente.getCorreo(), "Registro de medidor", med.toString());  
                           return retorno;
                       }
                       else if(tipoMedidor.equals("INTELIGENTE")){                          
                           String codigo = RandomStringUtils.randomAlphanumeric(6);
                           medidorInteligente medidorCreado= new medidorInteligente(codigo,direccion,planAdd,cliente);
                           ArrayList<Medidor> listaCliente= cliente.getMedidores();
                           medidoresReg.add(medidorCreado);
                           listaCliente.add(medidorCreado);
                           cliente.setMedidores(listaCliente);
                           abonados.set(posicionAbon,cliente);
                           MedidoresUsuarios retorno = new MedidoresUsuarios(abonados,medidoresReg);
                           Medidor med = (Medidor) medidorCreado;
                           correo.enviarCorreo(cliente.getCorreo(), "Registro de medidor", med.toString()); 
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
                    String correoCliente = sc.nextLine();
                    String contrasena = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
                    abonado cliente = new abonado(numCedula,numCedula,contrasena,correoCliente);
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
                           String codigo = RandomStringUtils.randomAlphanumeric(6);
                           medidorAnalogico medidorCreado= new medidorAnalogico(codigo,direccion,planAdd,cliente);
                           ArrayList<Medidor> listaCliente= cliente.getMedidores();
                           medidoresReg.add(medidorCreado);
                           listaCliente.add(medidorCreado);
                           cliente.setMedidores(listaCliente);
                           abonados.add(cliente);
                           MedidoresUsuarios retorno = new MedidoresUsuarios(abonados,medidoresReg);
                           Medidor med = (Medidor) medidorCreado;
                           String contenido = med.toString() + "\nSu usuario es: " + numCedula + "\nSu contraseña es:" + contrasena ;
                           correo.enviarCorreo(cliente.getCorreo(), "Registro de medidor", contenido); 
                           return retorno;
                           }
                       
                       else if(tipoMedidor.equals("INTELIGENTE")){
                           String codigo = RandomStringUtils.randomAlphanumeric(6);
                           medidorInteligente medidorCreado= new medidorInteligente(codigo,direccion,planAdd,cliente);
                           ArrayList<Medidor> listaCliente= cliente.getMedidores();
                           medidoresReg.add(medidorCreado);
                           listaCliente.add(medidorCreado);
                           cliente.setMedidores(listaCliente);
                           abonados.add(cliente);
                           MedidoresUsuarios retorno = new MedidoresUsuarios(abonados,medidoresReg);
                           Medidor med = (Medidor) medidorCreado;
                           String contenido = med.toString() + "\nSu usuario es: " + numCedula + "\nSu contraseña es:" + contrasena ;                           
                           correo.enviarCorreo(cliente.getCorreo(), "Registro de medidor", contenido); 
                           return retorno;
                       }
                       else {
                         System.out.println("No existe el medidor ");  
                       }
                    }
                    else{
                     System.out.println("No existe el plan ");
                   }
                }
          return null;
        }
   /**
    * Este metodo simula mediciones para medidores inteligentes en el rango de fechas dado y las ingresa en el registro.
    * @param inicio es la fecha inicial del rango
    * @param fin es la fecha final del rango
    * @param ui es el objeto tipo registro
    * @return una lista de medidores con sus telemetrias actualizadas.
    */
   public ArrayList<Medidor> simularMedicion(LocalDateTime inicio, LocalDateTime fin, registro ui){
       ArrayList<telemetria> telem; 
       System.out.println("Fecha inicio:" + inicio);
       System.out.println("Fecha fin:" + fin);
       ArrayList<Medidor> med = ui.getMedidores();  
       for(int i=0;i<med.size();i++){
           double consumoInventado = 0;
           Medidor n = med.get(i);
           if(n instanceof medidorInteligente){
              medidorInteligente m = (medidorInteligente)n;
              System.out.println("Lecturas para medidor con codigo " + m.getCodigo() + " con valor actual " + m.getValor() );
              System.out.println(m.getCodigo() + "," + inicio + "," + m.getValor());
              telem = m.getTelemetria();
              LocalDateTime inicioCalculo = inicio;
              do{
                  inicioCalculo = inicioCalculo.plusMinutes(10);
                  int tamano = telem.size();
                  if (tamano == 0){
                      consumoInventado = Math.random() * 10;
                      telemetria telemNew = new telemetria(m.getCodigo(), inicioCalculo, consumoInventado);
                      System.out.println(m.getCodigo() + "," + inicioCalculo + "," + consumoInventado);
                      telem.add(telemNew);                    
                  }
                  else{
                  telemetria elemento = telem.get(tamano - 1);
                  double valorInicial = elemento.getconsumo();
                  consumoInventado = valorInicial + Math.random()*10;
                  telemetria telemNew = new telemetria(m.getCodigo(),inicioCalculo,consumoInventado);
                  System.out.println(m.getCodigo() + "," + inicioCalculo + "," + consumoInventado);
                  telem.add(telemNew);
                  }
              }
              while(inicioCalculo.isBefore(fin));
              m.setTelemetria(telem);
              
              m.registrarMedicion(consumoInventado,fin.toLocalDate());
              med.set(i,m);
              
           }   
       }
       return med; 
   }
/**
 * Este metodo realiza las facturas para cada uno de los medidores en registro y envia un correo por factura.
 * @param medidoresPag es la lista de medidores presente en el registro
 * @return una lista de medidores actualizados con sus respectivas facturas.
 */
   public ArrayList<Medidor> realizarFacturacion(ArrayList<Medidor> medidoresPag){
       ArrayList<Medidor> medidoresFacturasActualizadas = new ArrayList<>();
       for(Medidor m: medidoresPag){
           
           planEnergia plan = m.getPlan();
           LocalDateTime femi = LocalDateTime.now(); 
           LocalDate actual = m.getUltimaMedida(); 
           double cargoPlan = plan.getCargo(); 
           double lecActual = m.getValor(); 
           double consumo = m.getConsumo(); 
           if(m.getFacturas().isEmpty()){                                      
               if(m instanceof medidorAnalogico){
                   double total = cargoPlan + (plan.getcostoKW()*consumo);
                   factura fac = new factura(femi, actual, actual, 0, m, plan,  RandomStringUtils.randomNumeric(8), total);
                   fac.setcargoBase(cargoPlan);
                   fac.setLecturaAnterior(0);
                   fac.setLecturaActual(lecActual);
                   m.agregarFactura(fac);
                   medidoresFacturasActualizadas.add(m);
               } else {
                   double totalParcial = 0;
                   double totalPico = 0;
                   double totalNP = 0;
                   double consumoAnte = 0;
                   medidorInteligente mi = (medidorInteligente) m; 
                   for(telemetria t: mi.getTelemetria()){ 
                       int dthora = t.getFecha().getHour();  
                       ArrayList<LocalTime> horasP = plan.getHoras(); 
                       for(LocalTime hora: horasP){
                           int h = hora.getHour();
                           if(dthora == h){
                              double consumoNuevo = t.getconsumo() - consumoAnte;
                              double consumoP = 2 * plan.getcostoKW() * consumoNuevo; 
                              consumoAnte = t.getconsumo();
                              totalPico = totalPico + consumoP;
                           } else {
                              double consumoNuevo = t.getconsumo() - consumoAnte;
                              double consumoNP = plan.getcostoKW() * consumoNuevo;
                              consumoAnte = t.getconsumo();
                              totalNP = totalNP + consumoNP;
                           } 
                       totalParcial = totalPico + totalNP;
                       }
                   }   
                   double total = cargoPlan + totalParcial;
                   int pos = mi.getTelemetria().size()-1;
                   LocalDate fI = (mi.getTelemetria().get(0).getFecha()).toLocalDate();
                   LocalDate fF = (mi.getTelemetria().get(pos).getFecha()).toLocalDate();
                   int dias = fF.getDayOfYear() - fI.getDayOfYear();
                   factura fac = new factura(femi, fI, fF, dias, m, plan,  RandomStringUtils.randomNumeric(8), total); 
                   fac.setcargoBase(cargoPlan);
                   fac.setLecturaAnterior(0);
                   fac.setLecturaActual(lecActual);
                   m.agregarFactura(fac); 
                   medidoresFacturasActualizadas.add(m);
                  }
           } else {                                 
               LocalDate fechaAnterior = m.getFacturas().get(0).getfecFinalLectura();  
               LocalDateTime fechaAnteriorTime=  m.getFacturas().get(0).getfecFinalLecturaTime();
               int dias = actual.getDayOfYear() - fechaAnterior.getDayOfYear(); 
               if(m instanceof medidorAnalogico){ 
                   double total = cargoPlan + (plan.getcostoKW()*m.getConsumo());                        
                   factura fac = new factura(femi, fechaAnterior, actual, dias, m, plan, RandomStringUtils.randomNumeric(8), total);
                   fac.setcargoBase(cargoPlan);
                   fac.setLecturaAnterior(m.getFacturas().get(0).getLecturaActual());
                   fac.setLecturaActual(lecActual);
                   m.agregarFactura(fac);
                   medidoresFacturasActualizadas.add(m);

               } else {
                   double totalPico = 0;
                   double totalNP = 0;
                   double consumoAnte = 0;
                   medidorInteligente mi = (medidorInteligente) m;
                   for(telemetria t: mi.getTelemetria()){
                       if(t.getFecha().isAfter(fechaAnteriorTime)){                                               
                           int dthora = t.getFecha().getHour();
                           ArrayList<LocalTime> horasP = plan.getHoras();
                           for(LocalTime hora: horasP){
                              int h = hora.getHour();
                              if(dthora == h){
                                double consumoNuevo = t.getconsumo() - consumoAnte;
                                double consumoP = 2 * plan.getcostoKW() * consumoNuevo; 
                                consumoAnte = t.getconsumo();
                                totalPico = totalPico + consumoP;
                              } else {
                                double consumoNuevo = t.getconsumo() - consumoAnte;
                                double consumoNP = plan.getcostoKW() * consumoNuevo;
                                consumoAnte = t.getconsumo();
                                totalNP = totalNP + consumoNP;
                              }  
                           }
                       }
                   }
                   double total = cargoPlan + totalPico + totalNP;
                   factura fac = new factura(femi, fechaAnterior, actual, dias, m, plan, RandomStringUtils.randomNumeric(8), total);
                   fac.setcargoBase(cargoPlan);
                   fac.setLecturaAnterior(m.getFacturas().get(0).getLecturaActual());
                   fac.setLecturaActual(lecActual);
                   m.agregarFactura(fac);
                   medidoresFacturasActualizadas.add(m);

                }
           }
           factura f = m.getFacturas().get(0);
           correo.enviarCorreo(m.getAbonado().getCorreo(), "Facturas","Codigo de factura: "+f.getCodigo()+"\n"+f.toString());            
       }
       return medidoresFacturasActualizadas;
   }
}