/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RegistroSalidaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    // Listar todos los registros de salida
    public List<RegistroSalida> Listar() {
        System.out.println("Ingreso a listar registros de salida");
        String sql = "SELECT * FROM salidavehiculos";
        List<RegistroSalida> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Carga registros listar registros de salida");
                System.out.println(rs.getInt(1) + ", " + rs.getInt(2) + ", " + rs.getTimestamp(3) + ", " + rs.getInt(4));
                RegistroSalida rss = new RegistroSalida();
                rss.setId_salida((rs.getInt(1)));
                rss.setId_entrada(rs.getInt(2));
                rss.setFecha_salida(rs.getTimestamp(3));
                rss.setMonto_pagado(rs.getInt(4));
                lista.add(rss);
            }
        } catch (Exception ex) {
            System.out.println("Error en driver RegistroSalidaDAO Listar: " + ex.getMessage());
        }
        return lista;
    }

    // Agregar un nuevo registro de salida
    public int Agregar(RegistroSalida rss) {
        System.out.println("Ingreso a agregar registro de salida");
        String sql = "INSERT INTO salidavehiculos (id_entrada, fecha_salida, monto_pagado) VALUES(?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, rss.getId_entrada());
            ps.setTimestamp(2, new java.sql.Timestamp(rss.getFecha_salida().getTime()));
            ps.setInt(3, rss.getMonto_pagado());

            r = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en driver RegistroSalidaDAO Agregar: " + ex.getMessage());
        }
        return r;
    }

    // Listar un registro de salida por ID
    public RegistroSalida listarid(int id) {
        System.out.println("Ingreso a listarid registro de salida");
        String sql = "SELECT * FROM salidavehiculos WHERE id_salida= " + id;
        RegistroSalida rss = new RegistroSalida();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                rss.setId_salida(rs.getInt(1));
                rss.setId_entrada(rs.getInt(2));
                rss.setFecha_salida(rs.getTimestamp(3));
                rss.setMonto_pagado(rs.getInt(4));
            }

        } catch (Exception ex) {
            System.out.println("Error en driver RegistroSalidaDAO listarid: " + ex.getMessage());
        }
        return rss;
    }

    // Actualizar un registro de salida
    public int Actualizar(RegistroSalida rss) {
        System.out.println("Ingreso a actualizar registro de salida");
        String sql = "UPDATE salidavehiculos SET id_entrada=?, fecha_salida=?, monto_pagado=? WHERE id_salida =?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, rss.getId_entrada());
            ps.setTimestamp(2, new java.sql.Timestamp(rss.getFecha_salida().getTime()));
            ps.setInt(3, rss.getMonto_pagado());
            ps.setInt(4, rss.getId_salida());
            ps.executeUpdate();
            System.out.println("Registro de salida actualizado correctamente");
        } catch (Exception ex) {
            System.out.println("Error en driver RegistroSalidaDAO Actualizar: " + ex.getMessage());
        }
        return r;
    }

    // Eliminar un registro de salida
    public void Delete(int id) {
        System.out.println("Ingreso a delete registro de salida");
        String sql = "DELETE FROM salidavehiculos WHERE id_salida=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Registro de salida eliminado correctamente");
        } catch (Exception ex) {
            System.out.println("Error en driver RegistroSalidaDAO Delete: " + ex.getMessage());
        }
    }
}

