package Datos;


import Datos.planEnergia.Provincia;
import static Datos.planEnergia.Provincia.*;
import Personal.abonado;
import Personal.administrador;
import Personal.operario;
import Personal.user;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author kevaalci
 */
public class registro {

    private ArrayList<user> usuarios;
    private ArrayList<Medidor> medidores;
    private ArrayList<factura> facturas;
    private ArrayList<planEnergia> planes;
    
    /**
     * Se crea un constructor llamado registro del cual no recibe nada.
     * usuarios sera una nueva lista de arreglos donde tendra los usuarios de operadores, administradores y abonados.
     * medidores es una nueva lista de arreglo del cual tendra los tipos de medidores
     * facturas es una nueva lista de arreglos donde tendra las facturas
     * planes es una lista de arreglo que tiene los tipos de planes
     */
    public registro(){
        usuarios= new ArrayList<>();
        medidores= new ArrayList<>();
        facturas= new ArrayList<>();
        planes= new ArrayList<>();
        inicializarDatos();
    }
    
    /**
     * se crea un constructor llamado inicializarDatos del cual se agregara  
     * inicalmente un usuario de administrador, dos operarios dos abonados 
     */
    public void inicializarDatos(){
        usuarios.add(new administrador("1302545984", "admin", "superadmin"));
        usuarios.add(new operario("0978451295", "operario1","clave1"));
        usuarios.add(new operario("0965221487", "operario2","clave2"));
        abonado a = new abonado("1307069874", "abonado1","clave3", "gabrielclucio14@gmail.com");
        abonado b = new abonado("1485622369", "abonado2", "clave4", "gabrielclucio14@gmail.com");
        LocalTime horapico1 = LocalTime.of(18, 00, 00);
        LocalTime horapico2 = LocalTime.of(20, 00, 00);
        ArrayList<LocalTime> horaspico1 = new ArrayList<>();
        ArrayList<LocalTime> horaspico2 = new ArrayList<>();
        horaspico1.add(horapico1);
        horaspico1.add(horapico2);
        ArrayList<Provincia> Provincias1 = new ArrayList<>(Arrays.asList(AZUAY, BOLIVAR, CANIAR));
        planEnergia plan1 = new planEnergia("Baraton",20d,10d,horaspico1,Provincias1);
        horaspico2.add(horapico1.plusHours(1));
        horaspico2.add(horapico2.plusHours(2));
        ArrayList<Provincia> Provincias2 = new ArrayList<>(Arrays.asList(CARCHI, CHIMBORAZO, COTOPAXI));
        planEnergia plan2 = new planEnergia("Mananero",18d,10d,horaspico2,Provincias2);
        planes.add(plan1);
        planes.add(plan2);
        medidorAnalogico medA1 = new medidorAnalogico("12344567", "10 de agosto", plan1, b);
        medidorAnalogico medA2 = new medidorAnalogico("12349485", "10 de agosto", plan2, a);
        medidorInteligente medI1 = new medidorInteligente("12349486", "10 de agosto", plan2, b);
        medidores.add(medA2);
        medidores.add(medA1);
        medidores.add(medI1);
        ArrayList<Medidor> meds1 = new ArrayList<>();
        meds1.add(medA1);
        meds1.add(medI1);
        b.setMedidores(meds1);
        ArrayList<Medidor> meds2 = new ArrayList<>();
        meds2.add(medA2);
        a.setMedidores(meds2);
        usuarios.add(b);
        usuarios.add(a);
    }
    
    /**
     * Se implementa un get de planes de una lista de arreglos de la clase  planEnergia para ser llamada en otras clases 
     * @return retorna los planes 
     */    
    public ArrayList<planEnergia> getPlanes(){
        return planes;
    } 
    
    /**
     * Se implementa un get de usuarios del cual por medio de una lista de arreglos de la clase de user  para ser llamada en otra clase
     * @return los usuarios 
     */
    public ArrayList<user> getUsuarios(){
        return usuarios;
    } 
    
    /**
     * Se implementa un get de facturas  para que pueda ser llamada en otra clase
     * @return me retornara las facturas
     */
    public ArrayList<factura> getFacturas(){
        return facturas;
    } 
    
    /**
     * Se implementa el get de Medidores para que no haya ningun imconveniente al momento de llamar en otra clase
     * @return me retorna las medidores
     */
    public ArrayList<Medidor> getMedidores(){
        return medidores;
    } 
    
    /**
     * Se implementa un set planes 
     * @param a por medio de this la variable inicial y  la de local no tenga algun inconventiente se coloca el valor de a 
     */
    public void setPlanes(ArrayList<planEnergia> a){
        this.planes= a;
    } 
    
    /**
     * Se implementa un set de usuarios
     * @param a por medio de this la variable inicial y  la de local no tenga algun inconventiente se coloca el valor de a
     */
    public void setUsuarios(ArrayList<user> a){
        this.usuarios= a;
    }
    
    /**
     * Se implementa un set de facturas 
     * @param a por medio de this la variable inicial y  la de local no tenga algun inconventiente se coloca el valor de a
     */
    public void setFacturas(ArrayList<factura> a){
        this.facturas= a;
    } 
    
    /**
     * Se implementa un set Medidores
     * @param a por medio de this la variable inicial y  la de local no tenga algun inconventiente se coloca el valor de a
     */
    public void setMedidores(ArrayList<Medidor> a){
        this.medidores= a;
    } 
    
    /**
     * Se implementa un metodo de tipo usuario que ingresa un int del cual se llama la clase user para hacer una revision
     * @param pos verifica si en usuarios. get(pos) se encuentra en la lista de arreglos de usuarios
     * @return me retornara un numero indicando si es un administrador, operario, administrador 
     */
    public int tipoUsuario(int pos){
        user revision = usuarios.get(pos);
        if(revision instanceof administrador)
            return 1;
        else if (revision instanceof operario)
            return 2;
        else if (revision instanceof abonado)
            return 3;
        else 
            return 4;
    }
    /*
    public void addAdmin(administrador admin){
        administradores.add(admin);
    } // Este metodo debe ser llamado en la opcion 1 (iniciar sesion)
    
    public void addOperario(operario operario){
        operarios.add(operario);
    }
    
    public void addMedidorInt(medidorInteligente Smartmed){
        medidorInteligentes.add(Smartmed);
    }
    
    public void addMedidorAna(medidorAnalogico Anamed){
        medidorAnalogicos.add(Anamed);
    }
    
    public void addfactura(factura factura){
        facturas.add(factura);
    }
    
    public void addPlan(planEnergia plan){
        planes.add(plan);
    }
    
    public void addAbonado(abonado abonado){
        abonados.add(abonado);
    }*/
}