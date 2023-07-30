/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Diego Ballesteros
 */
public class MensajeService {
    public static void crearmensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Tu nombre");
        String nombre= sc.nextLine();
        
        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);
        MensajeDao.crearMensajeDB(registro);
        
    }
    
    public static void listarMensaje(){
        
    }
    public static void borrarMensaje(){
        
    }
    public static void editarMensaje(){
        
    }
}
