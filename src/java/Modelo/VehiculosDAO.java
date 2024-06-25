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

/**
 *
 * @author usuario
 */
public class VehiculosDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public List Listar() {
        System.out.println("ingreso a listar vehiculos");
        String sql = "select * FROM vehiculos";
        List<Vehiculos> lista = new ArrayList<>();
        try {
            System.out.println("ingreso a try listar vehiculos");
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("carga registros listar vehiculos");
                Vehiculos v = new Vehiculos();
                v.setId_vehiculo(rs.getInt(1));
                v.setTipo(rs.getString(2));
                v.setPlaca(rs.getString(3));
                v.setMarca(rs.getString(4));
                v.setModelo(rs.getInt(5));
                v.setColor(rs.getString(6));
                v.setId_usuario_propietario(rs.getInt(7));
                lista.add(v);
            }
        } catch (Exception ex) {
            System.out.println("error en driver Daoveregistro inggreso listar: " + ex.getMessage());
        }
        return lista;
    }
    
    public int Agregar(Vehiculos v){
        System.out.println("ingreso a agregar vehiculos");
        String sql="INSERT into vehiculos(tipo, marca, placa, modelo, color, id_usuario_propietario) VALUES(?,?,?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, v.getTipo());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getPlaca());
            ps.setInt(4, v.getModelo());
            ps.setString(5, v.getColor());
            ps.setInt(6, v.getId_usuario_propietario());
            System.out.println("vehiculo agregado correctamente");
            ps.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println("error en driver Daovehiculos listar: " + ex.getMessage());
        }
        return r;
    }
    
    public Vehiculos listarid(int id){
        System.out.println("ingreso a listarid vehiculos");
        String sql="SELECT * FROM vehiculos WHERE id_vehiculo="+id;
        Vehiculos v = new Vehiculos();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();//el executequery ejecuta la consulta y obtiene datos, esos datos se guardan en el objeto rs
            while(rs.next()){
                v.setId_vehiculo(rs.getInt(1));
                v.setTipo(rs.getString(2));
                v.setPlaca(rs.getString(3));
                v.setMarca(rs.getString(4));
                v.setModelo(rs.getInt(5));
                v.setColor(rs.getString(6));
                v.setId_usuario_propietario(rs.getInt(7));      
                System.out.println("datos de usuario listado: "+ v.getId_vehiculo() + v.getTipo());
            }           
        }catch (SQLException ex) {
            System.out.println("error en driver Daovehiculos listarid: " + ex.getMessage());
        }
        return v;
    }
    
    public int Actualizar(Vehiculos v){
        System.out.println("ingreso a actualizar vehiculos");
        String sql="UPDATE vehiculos SET tipo=?, placa=?, marca=?, modelo=?, color=?, id_usuario_propietario=? "
                + "WHERE id_vehiculo=?";
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, v.getTipo());
            ps.setString(2, v.getPlaca());
            ps.setString(3, v.getMarca());
            ps.setInt(4, v.getModelo());
            ps.setString(5, v.getColor());
            ps.setInt(6, v.getId_usuario_propietario());
            ps.setInt(7, v.getId_vehiculo());
            System.out.println("id vehiculo: " + v.getId_vehiculo());
            ps.executeUpdate();
            System.out.println("Vehiculo actualizado correctamente");
        }catch (SQLException ex) {
            System.out.println("error en driver Daovehiculos listarid: " + ex.getMessage());
        }
        return r;
    }
    public void Delete(int id){
        System.out.println("ingreso a eliminar vehiculos");
        String sql="DELETE FROM vehiculos WHERE id_vehiculo=?";
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("vehiculo eliminado correctamente");
        }catch (SQLException ex) {
            System.out.println("error en driver Daovehiculos delete: " + ex.getMessage());
    }
}
}
