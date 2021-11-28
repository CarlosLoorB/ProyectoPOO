package Datos;


import Personal.abonado;
import Personal.administrador;
import Personal.operario;
import Personal.user;
import java.time.LocalTime;
import java.util.ArrayList;


/**
 *
 * @author kevaalci
 */
public class registro {

    private ArrayList<user> usuarios;
    private ArrayList<Medidor> medidores;
    private ArrayList<factura> facturas;
    private ArrayList<planEnergia> planes;
    
    public registro(){
        usuarios= new ArrayList<>();
        medidores= new ArrayList<>();
        facturas= new ArrayList<>();
        planes= new ArrayList<>();
        inicializarDatos();
    }
    
    public void inicializarDatos(){
        usuarios.add(new administrador("1302545984", "admin", "superadmin"));
        usuarios.add(new operario("0978451295", "operario1","clave1"));
        usuarios.add(new operario("0965221487", "operario2","clave2"));
        abonado a = new abonado("1307069874", "abonado1","clave3", "penelope@gmail.com");
        usuarios.add(a);
        usuarios.add(new abonado("1485622369", "abonado2", "clave4", "calobo2001@gmail.com"));
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
        planes.add(plan1);
        planes.add(plan2);
        Medidor m = new Medidor("1234", "10 de agosto", plan1, a);
    }
        
    public ArrayList<planEnergia> getPlanes(){
        return planes;
    } 
    
    public ArrayList<user> getUsuarios(){
        return usuarios;
    } 
    
    public ArrayList<factura> getFacturas(){
        return facturas;
    } 
    
    public ArrayList<Medidor> getMedidores(){
        return medidores;
    } 
    
    public void setPlanes(ArrayList<planEnergia> a){
        this.planes= a;
    } 
    
    public void setUsuarios(ArrayList<user> a){
        this.usuarios= a;
    }
    
    public void setFacturas(ArrayList<factura> a){
        this.facturas= a;
    } 
    
    public void setMedidores(ArrayList<Medidor> a){
        this.medidores= a;
    } 
    
    public int tipoUsuario(int pos){
        user revision = usuarios.get(pos);
        if(revision instanceof administrador)
            return 1;
        else if (revision instanceof operario)
            return 2;
        else if (revision instanceof administrador)
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