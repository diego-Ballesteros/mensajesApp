/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public static ArrayList<Mensaje> leerMensajeDB(){
         Conexion dbConect = new Conexion();
         ArrayList<Mensaje> mensajes = new ArrayList<>();
         
         PreparedStatement ps = null;
         ResultSet rs = null;
         
         try(Connection conexion = dbConect.get_connection()){
            String query ="SELECT * FROM mensajes";
            
            ps=conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
             while (rs.next()) {
                 Mensaje mensaje = new Mensaje();
                 mensaje.setIdMensaje(rs.getInt("id_mensaje"));
                 mensaje.setMensaje(rs.getString("mensaje"));
                 mensaje.setAutorMensaje(rs.getString("autor_mensaje"));
                 mensaje.setFechaMensaje(rs.getString("fecha_mensaje"));
                 mensajes.add(mensaje);
             }
            
        } catch (Exception e) {
             System.out.println("No se pudieron recuperar los datos");
             System.out.println(e);
        }
         return mensajes;
    }
    public static void borrarMensajeDB(int idMensaje){
        Conexion dbConect = new Conexion();
        
         try(Connection conexion = dbConect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM mensajes "
                        + "WHERE id_mensaje = ?";
                ps =conexion.prepareStatement(query);
                ps.setInt(1,idMensaje);
                ps.executeUpdate();
                System.out.println("Mensaje eliminado exitosamente");
            
            } catch (Exception e) {
                 System.out.println("No se pudo borrar el datos");
                 System.out.println(e);
            }
            
        } catch (Exception e) {
            
             System.out.println(e);
        }
    }
    
    public static void actualizarMensajeBD(Mensaje mensaje){
        Conexion dbConect = new Conexion();
        
         try (Connection conexion = dbConect.get_connection()){
            PreparedStatement ps = null;
             try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.executeUpdate();
                System.out.println("actualizado con exito");
                
             } catch (SQLException ex) {
                 System.out.println("No se pudo hacer la actualizacion ");
                 System.out.println(ex);
             }
            
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
}
