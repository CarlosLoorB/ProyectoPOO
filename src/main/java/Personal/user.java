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
    
    /**
     * Se Implementa el equal del constructor de user para comprobar la contrasena y el usuario son iguales
     * @param obj es de metodo Objeto ya que esta verificando si son iguales o no con la variable comp 
     * @return me retorna un booleano para indicarme si es verdadero o falso 
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof user){
            user comp = (user)obj;
            if(contrasena.equals(comp.contrasena) && usuario.equals(comp.usuario)){
                return true;
            }
            else if(cedula.equals(comp.cedula)){
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
