
import Personal.user;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CAELOS JR 2018
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Confirma si funciona");
        byte opc;
        String usuario;
        
        try{
            do{
                System.out.println("Menu");
                System.out.println("1. Iniciar Sesion");
                System.out.println("2. Salir");
                Scanner sc = new Scanner(System.in);
                opc = sc.nextByte();
                if (opc==2){
                    System.out.println("Saliendo...");
                    break;
                }
                switch(opc){
                    case 1:
                        System.out.println("Bienvenido al Sistema");
                        //esto no va, como vas a crear un nuevo user 
                        //personal user = new user();
                        System.out.println("Ingrese su usuario: ");
                        //user.user= sc.nextLine();
                        System.out.print("Ingrese la contrasea");
                }
                
            }while (opc==1|| opc==2);
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
}
