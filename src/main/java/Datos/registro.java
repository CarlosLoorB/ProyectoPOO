package Datos;


import Personal.administrador;
import Personal.operario;
import Personal.user;
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