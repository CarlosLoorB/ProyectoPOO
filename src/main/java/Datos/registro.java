package Datos;

import Personal.administrador;
import Personal.operario;
import java.util.ArrayList;


/**
 *
 * @author kevaalci
 */
public class registro {

    private ArrayList<administrador> administradores;
    private ArrayList<operario> operarios;
    private ArrayList<medidorInteligente> medidorInteligentes;
    private ArrayList<medidorAnalogico> medidorAnalogicos;
    private ArrayList<factura> facturas;
    private ArrayList<planEnergia> planes;
    private ArrayList<abonado> abonados;
    
    public registro(){
        administradores= new ArrayList<>();
        operarios= new ArrayList<>();
        medidorInteligentes= new ArrayList<>();
        medidorAnalogicos= new ArrayList<>();
        facturas= new ArrayList<>();
        planes= new ArrayList<>();
        abonados= new ArrayList<>();
    }
    
    public void addAdmin(administrador admin){
        administradores.add(admin);
    }
    
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
    }
        
    public ArrayList<planEnergia> getPlanes(){
        return planes;
    }
}