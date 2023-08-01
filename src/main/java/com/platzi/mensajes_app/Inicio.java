/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Diego Ballesteros
 */
public class Inicio {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int op =0;
        String men = "-------------------- \n"
                + " Aplicacion mensaje "
                + "\n1. Crear mensaje"
                + "\n2. Listar mensajes"
                + "\n3. Eliminar mensaje"
                + "\n4. Editar mensaje"
                + "\n5. Salir"
                + "----------> ";        
        fin: do {            
            System.out.print(men);
            op = sc.nextInt();
            switch (op) {
                case 1:
                    MensajeService.crearmensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.borrarMensaje();
                    break;
                case 4:
                    MensajeService.editarMensaje();
                    break;
                case 5:
                    System.out.println("|| Gracias por usar el programa ||");
                    break fin;
                default:
                    throw new AssertionError();
            }
            
        } while (true);
        
    }
}
