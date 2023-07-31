/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import java.util.ArrayList;
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
        System.out.println("--------------------");
        System.out.println(" Monstrando mensajes ");
        ArrayList<Mensaje> mensajes = MensajeDao.leerMensajeDB();
        
        for (Mensaje mensaje : mensajes) {
            System.out.println("ID: "+ mensaje.getIdMensaje());
            System.out.println("Mensaje: "+ mensaje.getMensaje());
            System.out.println("Autor: "+mensaje.getAutorMensaje());
            System.out.println("Fecha mensaje: "+mensaje.getFechaMensaje());
            System.out.println("");
        }
    }
    public static void borrarMensaje(){
        
    }
    public static void editarMensaje(){
        
    }
}
