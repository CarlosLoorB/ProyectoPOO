/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personal;

/**
 *
 * @author gabri
 */
public class user {
    protected String cedula;
    private String usuario;
    private String contrasena; 
    
    public user(String cedula,String usuario,String contrasena){
        this.cedula=cedula;
        this.usuario=usuario;
        this.contrasena=contrasena;
    }
    
    public user(String usuario,String contrasena){
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.cedula="-1";
    }
    
    public user(String cedula){
        this.usuario="nada";
        this.contrasena="nada";
        this.cedula=cedula;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof user){
            user a = (user)obj;
            if(contrasena.equals(a.contrasena) && usuario.equals(a.usuario)){
                return true;
            }
            else if(cedula.equals(a.cedula)){
                return true;
            }
            else{
                return false;
            }
        }
        else
            return false;
    }
    
    
}
