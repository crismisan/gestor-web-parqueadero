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
import java.util.ArrayList;
import java.util.List;

public class EstacionamientoDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    
    public List listar() {
        System.out.println("Ingreso a listar estacionamiento");
        String sql = "SELECT * FROM estacionamiento";
        List<Estacionamiento> lista = new ArrayList<>();
        try {
            System.out.println("Ingreso a try listar estacionamiento");
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("carga registros listar estacionamiento");
                Estacionamiento e = new Estacionamiento();
                e.setId_plaza(rs.getInt(1));
                e.setNumero_plaza(rs.getInt(2));
                e.setTipo_vehiculo(rs.getString(3));
                e.setEstado(rs.getInt(4));
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("error en driver Daovehiculos listar: " + ex.getMessage());
        }
        return lista;
    }

    public int Agregar(Estacionamiento e) {
        System.out.println("Ingreso a try agregar estacionamiento");
        String sql = "INSERT INTO estacionamiento(numero_plaza, tipo_vehiculo, estado) VALUES (?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, e.getNumero_plaza());
            ps.setString(2, e.getTipo_vehiculo());
            ps.setInt(3, e.getEstado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error en driver DaoEstacionamiento agregar: " + ex.getMessage());
        }
        return r;
    }
    public Estacionamiento listarid(int id){
        System.out.println("Ingreso a try listarid estacionamiento");
         Estacionamiento e = new Estacionamiento();
        String sql="SELECT * from estacionamiento WHERE id_plaza=" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();// el executequery ejecuta la consulta y obtiene datos, esos datos se guardan en el objeto rs
            while(rs.next()){  
            e.setId_plaza(rs.getInt(1));
            e.setNumero_plaza(rs.getInt(2));
            e.setTipo_vehiculo(rs.getString(3));
            e.setEstado(rs.getInt(4));
            }
            
        }catch (SQLException ex) {
            System.out.println("error en driver DaoEstacionamiento listarid: " + ex.getMessage());
        }
        return e;
    }
    public int Actualizar(Estacionamiento e){
        System.out.println("Ingreso a actualzar estacionamiento en controlador");
        String sql="UPDATE estacionamiento SET numero_plaza=?, tipo_vehiculo=?, estado=? WHERE id_plaza=?";
        try{
            
            con = cn.Conexion();
            ps = con.prepareStatement(sql);      
            ps.setInt(1, e.getNumero_plaza());
            ps.setString(2, e.getTipo_vehiculo());
            ps.setInt(3, e.getEstado());
            ps.setInt(4, e.getId_plaza());
            ps.executeUpdate();
            System.out.println("Estacionamiento actualizado correctamente");
            
        }catch (SQLException ex) {
            System.out.println("error en driver DaoEstacionamiento actualzar: " + ex.getMessage());
        }
        return r;
    }
    public void Delete(int id){
        System.out.println("Ingreso a try eliminar estacionamiento");
        String sql="DELETE FROM estacionamiento WHERE id_plaza=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);  
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("estacionamiento eliminado correctamente");
        }catch (SQLException ex) {
            System.out.println("error en driver DaoEstacionamiento eliminar: " + ex.getMessage());
        }
    } 
}
