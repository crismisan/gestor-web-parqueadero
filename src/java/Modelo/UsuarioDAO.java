
package Modelo;


import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioDAO implements Validar{ 
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    int idRol;
    @Override
    public int validar(Usuario user) {
       String sql="select * from usuarios WHERE correo_electronico=? AND contraseña=? ";
       try{
           
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, user.getCorreo());
           ps.setString(2, user.getContraseña());
           rs=ps.executeQuery();
           while(rs.next()){
               idRol = rs.getInt("id_rol");
               r=r+1;
               user.setCorreo(rs.getString("correo_electronico"));
               user.setContraseña(rs.getString("contraseña"));
               System.out.println("rol=" + idRol);
           }
           if (r == 1 && (idRol == 2 || idRol == 3)){
               return 1;
           }else{
               return 0;
           }
       }catch(Exception e){
           return 0;
       }
    }
    public String Nombreporcorreo(Usuario user){
        String sql="SELECT nombre_usuario FROM usuarios WHERE correo_electronico=?";
        try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        ps.setString(1, user.getCorreo());
        rs=ps.executeQuery();
        while(rs.next())
        user.setNombre(rs.getString("nombre_usuario"));
        System.out.println("CONEXION EXITOSA A LA BD en nombreporusuario ");
        }catch(Exception e){
           System.out.println("Error al obtener nombre de usuario por correo: " + e.getMessage());
       }
       return user.getNombre();
    }
    
   /* public String obtenerNombreRol(int idRol) {
    String sql = "SELECT nombre_rol FROM roles WHERE id_rol = ?";
    String nombreRol = null;
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idRol);
        rs = ps.executeQuery();
        if (rs.next()) {
            nombreRol = rs.getString("nombre_rol");
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener nombre de rol: " + ex.getMessage());
    }
    return nombreRol;
}*/

    public  List Listar() {
    System.out.println("ingreso a listar usuario");
        String sql = "select id_usuario, nombre_usuario, correo_electronico, id_rol from usuarios ";
        List<Usuario> lista = new ArrayList<>();
        try{
            System.out.println("ingreso a try listar usuarios");
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("carga registros listar usuarios");
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setCorreo(rs.getString(3));
                u.setId_rol(rs.getInt(4));
                lista.add(u);
            }
        }catch(SQLException ex){
            System.out.println("error en driver DaoUsuarios listar: " + ex.getMessage());
        }
        return lista;
}
    public int Agregar (Usuario usuario ){
        System.out.println("ingreso a agregar usuario");
        String sql="INSERT INTO usuarios (nombre_usuario, contraseña, correo_electronico, id_rol) VALUES(?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
             ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, usuario.getId_rol());
            ps.executeUpdate();
            
            
        }catch(SQLException ex){
            System.out.println("Error en driver DaoMedico agregar: " + ex.getMessage());
        }
        return r;
    }
    
    public Usuario listarId(int id){
        System.out.println("ingreso a listar id usuario");
        Usuario usuario = new Usuario();
        String sql="SELECT * FROM usuarios WHERE id_usuario=" + id;       
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                usuario.setId_usuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setContraseña(rs.getString(3));
                usuario.setCorreo(rs.getString(4));
                usuario.setId_rol(rs.getInt(5));
            }
        }catch(SQLException ex){
            System.out.println("Error en driver DaoUsuario listarID: " + ex.getMessage());
        }
        return usuario;
    }
    
    public int Actualizar(Usuario usuario){
        System.out.println("ingreso a actualizar usuario");
        String sql="UPDATE usuarios SET nombre_usuario=?, contraseña=?, correo_electronico=?, id_rol=? WHERE id_usuario=?";
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, usuario.getId_rol());
            ps.setInt(5, usuario.getId_usuario());
            System.out.println("id usuario: " + usuario.getId_usuario());
            ps.executeUpdate();
            System.out.println("Usuario actualizado correctamente");
            
        }catch(SQLException ex){
            System.out.println("Error en driver DaoUsuario Actualizar: " + ex.getMessage());
        }
        return r;
    }
    
    public void Delete(int idusuario){
        System.out.println("ingreso a eliminar usuario");
        String sql="DELETE FROM usuarios WHERE id_usuario=?";
        try{
           con = cn.Conexion();
           ps=con.prepareStatement(sql); 
           ps.setInt(1, idusuario);
           ps.executeUpdate();
           System.out.println("Usuario eliminado correctamente");
        }catch(SQLException ex){
            System.out.println("Error en driver DaoUsuario eliminar: " + ex.getMessage());
        }
    }
}
