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
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static org.apache.tomcat.jakartaee.commons.io.IOUtils.writer;

/**
 *
 * @author usuario
 */
public class RegistroIngresoDAO {
Document documento = new Document();
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int IdPorPlaca(String placa) {
        int id_vehiculo = 0;
        System.out.println("Ingreso a buscar id por placa");
        String sql = "SELECT id_vehiculo FROM vehiculos WHERE placa= ?";
        RegistroIngreso ri = new RegistroIngreso();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            while (rs.next()) {
                id_vehiculo = rs.getInt("id_vehiculo");
            }
        } catch (SQLException ex) {
            System.out.println("error en driver Daoregistroentrada buscarplacaporid: " + ex.getMessage());
        }
        return id_vehiculo;
    }

    public String encontrarTipoVehiculoPorId(int idVehiculo) {
        System.out.println("Ingreso a encontrar tipo de vehículo por ID");
        String tipoVehiculo = null;
        String sql = "SELECT tipo FROM vehiculos WHERE id_vehiculo = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVehiculo);
            rs = ps.executeQuery();
            while(rs.next()) {
                tipoVehiculo = rs.getString("tipo");
            }
        } catch (SQLException ex) {
            System.out.println("Error en el driver DAO vehículos al encontrar tipo de vehículo por ID: " + ex.getMessage());
        }
        return tipoVehiculo;
    }

    public int obtenerIdPropietarioPorIdVehiculo(int idVehiculo) {
        int idPropietario = 0; // Inicializar en caso de que no se encuentre el ID del vehículo
        try {
            String sql = "SELECT id_usuario_propietario FROM vehiculos WHERE id_vehiculo = ?";
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVehiculo);
            rs = ps.executeQuery();
            while (rs.next()) {
                idPropietario = rs.getInt("id_usuario_propietario");
            }
        } catch (SQLException ex) {
            System.out.println("error en driver Daovehiculos obtenerIdPropietarioPorIdVehiculo: " + ex.getMessage());
        }
        return idPropietario;
    }

    public String obtenerNombrePropietarioPorId(int idPropietario) {
        System.out.println("Ingreso a obtener nombre por id ");
        String nombrePropietario = ""; // Inicializar en caso de que no se encuentre el ID del propietario
        try {
            String sql = "SELECT nombre_usuario FROM usuarios WHERE id_usuario = ?";
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPropietario);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombrePropietario = rs.getString("nombre_usuario");
            }
            

        } catch (SQLException ex) {
            System.out.println("error en driver Daoregistroingreso obtenerNombrePropietarioPorId " + ex.getMessage());
        }
        return nombrePropietario;
    }

    public List Listar() {
        System.out.println("ingreso a listar registro de ingreso");
        String sql = "Select * FROM registroingreso";
        List<RegistroIngreso> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("carga registros listar registro de ingreso");
                  System.out.println(rs.getInt(1) + ", " + rs.getInt(2) + ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getInt(5) + ", " + rs.getDate(6) + ", " + rs.getString(7));
                RegistroIngreso ri = new RegistroIngreso();
                ri.setId_ingreso(rs.getInt(1));
                ri.setId_vehiculo(rs.getInt(2));
                ri.setPlaca(rs.getString(3));
                ri.setTipo(rs.getString(4));
                ri.setNumero_parqueadero(rs.getInt(5));
                ri.setFecha_ingreso(rs.getDate(6));
                ri.setPropietario(rs.getString(7));
                lista.add(ri);
                
            }
        } catch (Exception ex) {
            System.out.println("error en driver Daovehiculos listar: " + ex.getMessage());
        }
        return lista;
    }

    public int Agregar(RegistroIngreso ri) {
        System.out.println("ingreso a agregar registro de ingreso");
        String sql = "INSERT INTO registroingreso (id_vehiculo, placa, tipo_vehiculo, numero_parqueadero, "
                + "fecha_ingreso, propietario) VALUES(?,?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ri.getId_vehiculo());
            ps.setString(2, ri.getPlaca());
            ps.setString(3, ri.getTipo());
            ps.setInt(4, ri.getNumero_parqueadero());
            ps.setTimestamp(5, new java.sql.Timestamp(ri.getFecha_ingreso().getTime()));
            ps.setString(6, ri.getPropietario());

            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("error en driver Daoregistroentrada Agregar: " + ex.getMessage());
        }
        return r;
    }

    public RegistroIngreso listarid(int id) {
        System.out.println("ingreso a listarid registro de ingreso");
        String sql = "SELECT * FROM registroingreso WHERE id_entrada= " + id;
        RegistroIngreso ri = new RegistroIngreso();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ri.setId_ingreso(rs.getInt(1));
                ri.setId_vehiculo(rs.getInt(2));
                ri.setPlaca(rs.getString(3));
                ri.setTipo(rs.getString(4));
                ri.setNumero_parqueadero(rs.getInt(5));
                ri.setFecha_ingreso(rs.getDate(6));
                ri.setPropietario(rs.getString(7));
            }

        } catch (Exception ex) {
            System.out.println("error en driver Daoregistroentrada listarod: " + ex.getMessage());
        }
        return ri;
    }

    public int Actualizar(RegistroIngreso ri) {
        System.out.println("ingreso a actualizar registro de ingreso");
        String sql = "UPDATE registroingreso SET id_vehiculo=?, placa=?, tipo_vehiculo=?, numero_parqueadero=?, fecha_ingreso=?"
                + ", propietario=? WHERE id_entrada =?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, ri.getId_vehiculo());
            ps.setString(2, ri.getPlaca());
            ps.setString(3, ri.getTipo());
            ps.setInt(4, ri.getNumero_parqueadero());
            ps.setDate(5, new java.sql.Date(ri.getFecha_ingreso().getTime()));
            ps.setString(6, ri.getPropietario());
            ps.setInt(7, ri.getId_ingreso());
            ps.executeUpdate();
            System.out.println("registroingreso actualizado correctamente");
        } catch (Exception ex) {
            System.out.println("error en driver Daoregistroentrada actualizar: " + ex.getMessage());
        }
        return r;
    }

    public void Delete(int id) {
        System.out.println("ingreso a delete registro de ingreso");
        String sql = "DELETE  FROM registroingreso WHERE id_entrada=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
           // ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("registroentrada eliminado correctamente");
        } catch (Exception ex) {
            System.out.println("error en driver Daoregistroentrada delete: " + ex.getMessage());
        }
    }
    
    public List<RegistroIngreso> listarActivos() {
    System.out.println("Ingreso a listar registros de vehículos activos");
    String sql = "SELECT * FROM registroingreso WHERE id_entrada NOT IN (SELECT id_entrada FROM salidavehiculos)";
    List<RegistroIngreso> lista = new ArrayList<>();
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            
            System.out.println("Carga registros listar registros de vehículos activos");
            RegistroIngreso ri = new RegistroIngreso();
            ri.setId_ingreso(rs.getInt(1));
            ri.setId_vehiculo(rs.getInt(2));
            ri.setPlaca(rs.getString(3));
            ri.setTipo(rs.getString(4));
            ri.setNumero_parqueadero(rs.getInt(5));
            ri.setFecha_ingreso(rs.getDate(6));
            ri.setPropietario(rs.getString(7));
            lista.add(ri);
        }
    } catch (Exception ex) {
        System.out.println("Error en RegistroIngresoDAO listarActivos: " + ex.getMessage());
    }
    return lista;
}
    
         public void generateReceipt(RegistroIngreso registroIngreso, String dest) {
        Document documento = new Document();
        try {
            // Crear un PdfWriter
            PdfWriter.getInstance(documento, new FileOutputStream(dest));
            documento.open();

            // Agregar contenido al PDF
            documento.add(new Paragraph("Recibo de Ingreso"));
            documento.add(new Paragraph("ID Ingreso: " + registroIngreso.getId_ingreso()));
            documento.add(new Paragraph("ID Vehículo: " + registroIngreso.getId_vehiculo()));
            documento.add(new Paragraph("Placa: " + registroIngreso.getPlaca()));
            documento.add(new Paragraph("Tipo de Vehículo: " + registroIngreso.getTipo()));
            documento.add(new Paragraph("Número de Parqueadero: " + registroIngreso.getNumero_parqueadero()));
            documento.add(new Paragraph("Fecha de Ingreso: " + registroIngreso.getFecha_ingreso()));
            documento.add(new Paragraph("Propietario: " + registroIngreso.getPropietario()));

            // Cerrar el documento
            documento.close();

            System.out.println("Recibo generado correctamente: " + dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
