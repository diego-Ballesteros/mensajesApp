/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Diego Ballesteros
 */
public class MensajeDao {
    
    public static void crearMensajeDB(Mensaje mensaje){
        Conexion dbConect = new Conexion();
        
        try(Connection conexion = dbConect.get_connection()) {
            PreparedStatement ps = null;
            try{
               String  query = "INSERT INTO `mensajes` ( mensaje, autor_mensaje) VALUES (?,?)";
               ps =conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setString(2, mensaje.getAutorMensaje());
               ps.executeUpdate();
                System.out.println("Mensaje creado con exito");
               
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void leerMensajeDB(){
        
    }
    public static void vorrarMensaje(int idMensaje){
        
    }
    public static void actualizarMensajeBD(Mensaje mensaje){
        
    }
    
}
