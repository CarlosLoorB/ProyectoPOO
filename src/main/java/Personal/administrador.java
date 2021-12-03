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
import org.apache.commons.lang3.RandomStringUtils; // este para que sirve? es porque me sale en rojo como advertencia ¿es para que salga la contraseña en random?
//import Personal.abonado;

public class administrador extends user{
Scanner sc = new Scanner(System.in);
    public administrador(String cedula,String usuario,String contrasena){
        super(cedula,usuario,contrasena);
    }
    // adentro del metodo se pediran las provinciastodas las cosas 
    public ArrayList<planEnergia> registrarPlan(ArrayList<planEnergia> planes,administrador admin){
        ArrayList<Provincia> planProvincias = new ArrayList<>();
        ArrayList<LocalTime> horapico = new ArrayList<>();
        String repetir;
        System.out.println("Ingrese el nombre del plan");
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
        System.out.println("Ingrese solo la hora de incicio de la hora pico"); // while se desea ingresar mas horas 
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
            //}
        } else {
            planes.add(nuevoPlan);
        }
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
       //MedidoresUsuarios meds = new MedidoresUsusarios();
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
                           Medidor med = (Medidor) medidorCreado;
                           correo.enviarCorreo(cliente.getCorreo(), "Registro de medidor", med.toString());  
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
                           Medidor med = (Medidor) medidorCreado;
                           correo.enviarCorreo(cliente.getCorreo(), "Registro de medidor", med.toString()); 
                           return retorno;
                       }//hacer un else si es que no te da ninguno de los dos tipos de medidor 
                       
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
                           //GENERA UN NUMERO ALEATORIO Y REVISA QUE YA NO ESTE EN LA LSITA DE MEDIDORES,PONLE DE NOMBRE codigo
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
                           //GENERA UN NUMERO ALEATORIO Y REVISA QUE YA NO ESTE EN LA LSITA DE MEDIDORES,PONLE DE NOMBRE codigo
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
   
   //esto me debe devolver el array de medidores con las nuevas telemtrias credas y añadidas al medidor en cuestion 
   public ArrayList<Medidor> simularMedicion(LocalDateTime inicio, LocalDateTime fin, registro ui){
       //LocalDateTime iniciocalculo
       ArrayList<telemetria> telem; //= new ArrayList<>();
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
              
              m.registrarMedicion(consumoInventado);
              med.set(i,m);
              
           }   
       }
       return med; 
   }
   // el nuevo contructor ya tiene la fecha de incicio agregada, la fecha de final agragada y el coido tambien, asi que no te olvides de agregarlas al constructor 
   // para el cargo base y el costo ya estan creados los setters para que los agreges apenas lo tengas 
   public ArrayList<Medidor> realizarFacturacion(ArrayList<Medidor> medidoresPag){
       ArrayList<Medidor> medidoresFacturasActualizadas = new ArrayList<>();
       for(Medidor m: medidoresPag){
           int lfac = m.getFacturas().size();
           planEnergia plan = m.getPlan();
           LocalDateTime femi = LocalDateTime.now(); //Fecha de emision
           LocalDate actual = m.getUltimaMedida(); // fecha de ultima lectura
           double cargoPlan = plan.getCargo(); //Consumo fijo del plan
           double lecActual = m.getValor(); // Kw actuales
           double consumo = m.getConsumo(); //consumo en Kw
           if(m.getFacturas().isEmpty()){                                      
               if(m instanceof medidorAnalogico){
                   double total = ((medidorAnalogico) m).calcularTotalAnalogico(plan, cargoPlan);
                   factura fac = new factura(femi, actual, actual, 0, m, plan,  RandomStringUtils.randomNumeric(8), total);
                   fac.setcargoBase(cargoPlan);
                   fac.setLecturaAnterior();
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
                           totalParcial = mi.calcularTotalInteligente(plan, dthora, h, t, consumoAnte, totalPico, totalNP);
                       }
                   }
                   double total = cargoPlan + totalParcial;
                   int pos = mi.getTelemetria().size()-1;
                   LocalDate fI = (mi.getTelemetria().get(0).getFecha()).toLocalDate();
                   LocalDate fF = (mi.getTelemetria().get(pos).getFecha()).toLocalDate();
                   int dias = fF.getDayOfYear() - fI.getDayOfYear();
                   factura fac = new factura(femi, fI, fF, dias, m, plan,  RandomStringUtils.randomNumeric(8), total); 
                   fac.setcargoBase(cargoPlan);
                   fac.setLecturaAnterior();
                   fac.setLecturaActual(lecActual);
                   m.agregarFactura(fac); 
                   medidoresFacturasActualizadas.add(m);
                  }
           } else {                                 
               LocalDate fechaAnterior = m.getFacturas().get(0).getfecFinalLectura();  // saca el primero 
               LocalDateTime fechaAnteriorTime=  m.getFacturas().get(0).getfecFinalLecturaTime();
               int dias = actual.getDayOfYear() - fechaAnterior.getDayOfYear(); 
               if(m instanceof medidorAnalogico){ 
                   double total = cargoPlan + (plan.getcostoKW()*m.getConsumo()); // El costo por el consumo del medidor                        
                   factura fac = new factura(femi, fechaAnterior, actual, dias, m, plan, RandomStringUtils.randomNumeric(8), total);
                   fac.setcargoBase(cargoPlan);
                   fac.setLecturaAnterior();
                   fac.setLecturaActual(lecActual);
                   m.agregarFactura(fac);
                   medidoresFacturasActualizadas.add(m);

               } else {
                   double totalPico = 0;
                   double totalNP = 0;
                   medidorInteligente mi = (medidorInteligente) m;
                   for(telemetria t: mi.getTelemetria()){
                       if(t.getFecha().isAfter(fechaAnteriorTime)){                                               
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
                   }
                   double total = cargoPlan + totalPico + totalNP;
                   factura fac = new factura(femi, fechaAnterior, actual, dias, m, plan, RandomStringUtils.randomNumeric(8), total);
                   fac.setcargoBase(cargoPlan);
                   fac.setLecturaAnterior();
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