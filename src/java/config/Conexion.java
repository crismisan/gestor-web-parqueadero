/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/parqueadero"; // Cambia el puerto si es diferente para tu MySQL
    String user = "root";
    String pass = "";

    public Connection Conexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("CONEXION EXITOSA A LA BD ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver de la BD: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la BD: " + ex.getMessage());
        }
        return con;
    }
}

