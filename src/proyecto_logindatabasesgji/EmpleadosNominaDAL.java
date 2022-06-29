/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_logindatabasesgji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Space
 */
public class EmpleadosNominaDAL {
    
    String strConexionDB="jdbc:mysql://localhost:3306/proyectofinaldbnomina?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String user="root";
    String password="root";
    Connection conn= null;
    
    public EmpleadosNominaDAL(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(strConexionDB,user,password);
            
            System.out.println("Conexion Establecida");
            
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println("Error de Conexion "+e);

        }
    }
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL) {
            
        try {
            PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
    
        } catch (SQLException e) {
           System.out.println(e);
           return 0;
   
                   }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL) {
            
        try {
            PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
    
        } catch (SQLException e) {
           System.out.println(e);
           return null;
   
                   }
    }
    
    
}
