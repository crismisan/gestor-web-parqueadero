/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Estacionamiento;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Modelo.UsuarioDAO;
import Modelo.Usuario;
import java.util.List;
import Modelo.VehiculosDAO;
import Modelo.Vehiculos;
import Modelo.EstacionamientoDAO;
import Modelo.RegistroIngreso;
import Modelo.RegistroIngresoDAO;
import Modelo.RegistroSalida;
import Modelo.RegistroSalidaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author usuario
 */
public class Controlador extends HttpServlet {

    UsuarioDAO daou = new UsuarioDAO();
    Usuario user = new Usuario();
    VehiculosDAO vdao = new VehiculosDAO();
    Vehiculos v = new Vehiculos();
    EstacionamientoDAO edao = new EstacionamientoDAO();
    RegistroIngreso ri = new RegistroIngreso();
    RegistroIngresoDAO ridao = new RegistroIngresoDAO();
    RegistroSalida rs = new RegistroSalida();
    RegistroSalidaDAO rsdao = new RegistroSalidaDAO();
    int r, idu, idv, ide;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (accion.equals("ingresar")) {
            String correo = request.getParameter("txtcorreo");
            String contraseña = request.getParameter("txtcontraseña");
            user.setCorreo(correo);
            user.setContraseña(contraseña);
            r = daou.validar(user);
            if (r == 1) {
                String nombreUsuario = daou.Nombreporcorreo(user);
                if (nombreUsuario != null) {
                    request.getSession().setAttribute("nombreUsuario", nombreUsuario);
                    request.getRequestDispatcher("Home.jsp").forward(request, response);

                }
                //response.sendRedirect("Controlador?menu=Usuario&accion=Listar");
                //request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                //request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                request.getSession().setAttribute("correo", correo);// en la sesion podre usar lo que hay en correo con el nombre correo

            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            String nombreUsuario = daou.Nombreporcorreo(user);

        }

        if (menu != null && menu.equals("Usuario")) {
            switch (accion) {
                case "Listar" -> {
                    System.out.println("ingreso a switch listar");
                    List lista = daou.Listar();
                    request.setAttribute("usuarios", lista); //estamos enviando al jsp una lista con el nombre usuarios
                    request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                }
                case "Agregar" -> {
                    System.out.println("Ingreso a agregar en controlador");
                    String nombre = request.getParameter("txtNombre");
                    String correo = request.getParameter("txtCorreo");
                    String contraseña = request.getParameter("txtContraseña");
                    String rol = request.getParameter("txtRol");

                    user.setNombre(nombre);
                    user.setCorreo(correo);
                    user.setContraseña(contraseña);
                    int idrol = Integer.parseInt(rol);
                    user.setId_rol(idrol);
                    daou.Agregar(user);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                }
                case "Editar" -> {
                    idu = Integer.parseInt(request.getParameter("id_usuario"));
                    Usuario user = daou.listarId(idu);
                    request.setAttribute("usuario", user); // aca establezco que mi objeto p en el jsp es paciente
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                }
                case "Actualizar" -> {
                    System.out.println("Ingreso a actualizar en controlador");
                    String id = request.getParameter("txtdusuario");
                    String nombre = request.getParameter("txtNombre");
                    String correo = request.getParameter("txtCorreo");
                    String contraseña = request.getParameter("txtContraseña");
                    String rol = request.getParameter("txtRol");

                    user.setId_usuario(Integer.parseInt(id));
                    user.setNombre(nombre);
                    user.setCorreo(correo);
                    user.setContraseña(contraseña);
                    int idrol = Integer.parseInt(rol);
                    user.setId_rol(idrol);
                    daou.Actualizar(user);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                }
                case "Delete" -> {
                    System.out.println("Ingreso a actualizar en controlador");
                    idu = Integer.parseInt(request.getParameter("id_usuario"));
                    daou.Delete(idu);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                }
            }
        }
        if (menu != null && menu.equals("Vehiculo")) {
            switch (accion) {
                case "Listar" -> {
                    System.out.println("ingreso a switch listar vehiculo");
                    List lista = vdao.Listar();
                    request.setAttribute("vehiculos", lista); //estamos enviando al jsp una lista con el nombre usuarios
                    request.getRequestDispatcher("Vehiculos.jsp").forward(request, response);
                }
                case "Agregar" -> {
                    System.out.println("Ingreso a agregar vehiculos en controlador");
                    String tipo = request.getParameter("txtTipo");
                    String marca = request.getParameter("txtMarca");
                    String placa = request.getParameter("txtPlaca");
                    String modelo = request.getParameter("txtModelo");
                    String color = request.getParameter("txtColor");
                    String propietario = request.getParameter("txtidpersona");
                    v.setTipo(tipo);
                    v.setPlaca(placa);
                    int modelo1 = Integer.parseInt(modelo);
                    v.setModelo(modelo1);
                    v.setMarca(marca);
                    v.setColor(color);
                    int propietario1 = Integer.parseInt(propietario);
                    v.setId_usuario_propietario(propietario1);

                    vdao.Agregar(v);
                    request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                }
                case "Editar" -> {
                    idv = Integer.parseInt(request.getParameter("id_vehiculo"));
                    Vehiculos v = vdao.listarid(idv);
                    request.setAttribute("vehiculo", v); // aca establezco que mi objeto v en el jsp es paciente
                    request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                }
                case "Actualizar" -> {
                    System.out.println("Ingreso a actualozar vehiculos en controlador");
                    String idvehiculo = request.getParameter("txtIdvehiculo");
                    String tipo = request.getParameter("txtTipo");
                    String marca = request.getParameter("txtMarca");
                    String placa = request.getParameter("txtPlaca");
                    String modelo = request.getParameter("txtModelo");
                    String color = request.getParameter("txtColor");
                    String propietario = request.getParameter("txtidpersona");
                    int idvv = Integer.parseInt(idvehiculo);
                    v.setId_vehiculo(idvv);
                    v.setTipo(tipo);
                    v.setPlaca(placa);
                    int modelo1 = Integer.parseInt(modelo);
                    v.setModelo(modelo1);
                    v.setMarca(marca);
                    v.setColor(color);
                    int propietario1 = Integer.parseInt(propietario);
                    v.setId_usuario_propietario(propietario1);
                    vdao.Actualizar(v);
                    request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);

                }
                case "Delete" -> {
                    System.out.println("Ingreso a eliminar vehiculo en controlador");
                    idv = Integer.parseInt(request.getParameter("id_vehiculo"));
                    vdao.Delete(idv);
                    request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                }
            }

        }
        if (menu != null && menu.equals("Estacionamiento")) {
            switch (accion) {
                case "Listar" -> {
                    List<Estacionamiento> lista = edao.listar();
                    request.setAttribute("estacionamiento", lista);
                    request.getRequestDispatcher("Estacionamiento.jsp").forward(request, response);
                }
                case "Agregar" -> {
                    String numeroPlaza = request.getParameter("txtnumero");
                    String tipoVehiculo = request.getParameter("txttipo");
                    String estado = request.getParameter("txtestado");
                    Estacionamiento nuevoEstacionamiento = new Estacionamiento();
                    int numplaza = Integer.parseInt(numeroPlaza);
                    nuevoEstacionamiento.setNumero_plaza(numplaza);
                    nuevoEstacionamiento.setTipo_vehiculo(tipoVehiculo);
                    int estado1 = Integer.parseInt(estado);
                    nuevoEstacionamiento.setEstado(estado1);

                    edao.Agregar(nuevoEstacionamiento);
                    request.getRequestDispatcher("Controlador?menu=Estacionamiento&accion=Listar").forward(request, response);
                }
                case "Editar" -> {
                    ide = Integer.parseInt(request.getParameter("id_plaza"));
                    System.out.println("El id de la plaza a editar es: " + ide);
                    Estacionamiento estacionamientoEditar = edao.listarid(ide);
                    request.setAttribute("estacionamientos", estacionamientoEditar);
                    request.getRequestDispatcher("Controlador?menu=Estacionamiento&accion=Listar").forward(request, response);
                }
                case "Actualizar" -> {
                    String idPlaza = request.getParameter("txtidplaza");
                    String numeroPlaza = request.getParameter("txtnumero");
                    String tipoVehiculo = request.getParameter("txttipo");
                    String estado = request.getParameter("txtestado");

                    Estacionamiento estacionamientoActualizar = new Estacionamiento();
                    int idplazza = Integer.parseInt(idPlaza);
                    estacionamientoActualizar.setId_plaza(idplazza);
                    int numplaza = Integer.parseInt(numeroPlaza);
                    estacionamientoActualizar.setNumero_plaza(numplaza);
                    estacionamientoActualizar.setTipo_vehiculo(tipoVehiculo);
                    int estado1 = Integer.parseInt(estado);
                    estacionamientoActualizar.setEstado(estado1);

                    edao.Actualizar(estacionamientoActualizar);
                    request.getRequestDispatcher("Controlador?menu=Estacionamiento&accion=Listar").forward(request, response);
                }
                case "Delete" -> {
                    int idEliminar = Integer.parseInt(request.getParameter("id_plaza"));
                    edao.Delete(idEliminar);
                    request.getRequestDispatcher("Controlador?menu=Estacionamiento&accion=Listar").forward(request, response);
                }
            }
        }
        if (menu != null && menu.equals("RegistroIngreso")) {
            switch (accion) {
                case "Listar" -> {
                    List<RegistroIngreso> lista = ridao.Listar();
                    System.out.println("Cantidad de registros en lista desde el controlador: " + lista.size());
                    for (RegistroIngreso ri : lista) {
                        System.out.println("ID: " + ri.getId_ingreso() + ",id vehiculo: " + ri.getId_vehiculo() + ", Placa: " + ri.getPlaca() + ", vehiculo: " + ri.getTipo() + ", Parqueadero: " + ri.getNumero_parqueadero() + ", Fecha Ingreso: " + ri.getFecha_ingreso() + ", Propietario: " + ri.getPropietario());
                    }
                    request.setAttribute("registroingresos", lista);
                    request.getRequestDispatcher("RegistroIngreso.jsp").forward(request, response);
                }
                case "Agregar" -> {
                    String placa = request.getParameter("txtplaca");
                    int id_vehiculo = ridao.IdPorPlaca(placa);
                    String tipo = ridao.encontrarTipoVehiculoPorId(id_vehiculo);
                    System.out.println("en el controlador, tipo de vehiculo = " + tipo);
                    int id_persona = ridao.obtenerIdPropietarioPorIdVehiculo(id_vehiculo);
                    String nombre = ridao.obtenerNombrePropietarioPorId(id_persona);
                    int numero_parqueadero = Integer.parseInt(request.getParameter("txtparqueadero"));
                    String fechaHoraStr = request.getParameter("txtfecha");
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    java.util.Date fechaHoraUtil = null;
                    java.sql.Timestamp fechaHoraSQL = null;
                    System.out.println("Fecha y hora sin convertir: " + fechaHoraStr);
                    try {
                        // Convertir la cadena a un objeto Date de java.util.Date
                        fechaHoraUtil = formato.parse(fechaHoraStr);
                        // Convertir java.util.Date a java.sql.Timestamp
                        fechaHoraSQL = new java.sql.Timestamp(fechaHoraUtil.getTime());
                        // Imprimir la fecha y hora como java.sql.Timestamp
                        System.out.println("Fecha y hora como java.sql.Timestamp: " + fechaHoraSQL);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    ri.setPlaca(placa);
                    ri.setId_vehiculo(id_vehiculo);
                    ri.setTipo(tipo);
                    ri.setPropietario(nombre);
                    ri.setNumero_parqueadero(numero_parqueadero);
                    ri.setFecha_ingreso(fechaHoraUtil);
                    ridao.Agregar(ri);

                    request.getRequestDispatcher("Controlador?menu=RegistroIngreso&accion=Listar").forward(request, response);

                }
                case "Editar" -> {
                    ide = Integer.parseInt(request.getParameter("id_ingreso"));

                    RegistroIngreso registroentradaeditar = ridao.listarid(ide);
                    request.setAttribute("registroingreso", registroentradaeditar);
                    request.getRequestDispatcher("Controlador?menu=RegistroIngreso&accion=Listar").forward(request, response);
                }
                case "Actualizar" -> {
                    String placa = request.getParameter("txtplaca");
                    int id_vehiculo = ridao.IdPorPlaca(placa);
                    String tipo = ridao.encontrarTipoVehiculoPorId(id_vehiculo);
                    String nombre = ridao.obtenerNombrePropietarioPorId(id_vehiculo);
                    int numero_parqueadero = Integer.parseInt(request.getParameter("txtparqueadero"));
                    String fechaHoraStr = request.getParameter("txtfecha");
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    java.util.Date fechaHoraUtil = null;
                    java.sql.Timestamp fechaHoraSQL = null;
                    System.out.println("Fecha y hora sin convertir: " + fechaHoraStr);
                    try {
                        // Convertir la cadena a un objeto Date de java.util.Date
                        fechaHoraUtil = formato.parse(fechaHoraStr);
                        // Convertir java.util.Date a java.sql.Timestamp
                        fechaHoraSQL = new java.sql.Timestamp(fechaHoraUtil.getTime());
                        // Imprimir la fecha y hora como java.sql.Timestamp
                        System.out.println("Fecha y hora como java.sql.Timestamp: " + fechaHoraSQL);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    ri.setPlaca(placa);
                    ri.setId_vehiculo(id_vehiculo);
                    ri.setTipo(tipo);
                    ri.setPropietario(nombre);
                    ri.setNumero_parqueadero(numero_parqueadero);
                    ri.setFecha_ingreso(fechaHoraUtil);
                    ridao.Actualizar(ri);
                    request.getRequestDispatcher("Controlador?menu=RegistroIngreso&accion=Listar").forward(request, response);
                }
                case "Delete" -> {
                    ide = Integer.parseInt(request.getParameter("id_ingreso"));
                    ridao.Delete(ide);
                    request.getRequestDispatcher("Controlador?menu=RegistroIngreso&accion=Listar").forward(request, response);

                }
                case "ListarActivos" -> {
                    List<RegistroIngreso> listaActivos = ridao.listarActivos();
                    request.setAttribute("vehiculosActivos", listaActivos);
                    request.getRequestDispatcher("Controlador?menu=RegistroIngreso&accion=ListarActivos").forward(request, response);
                }
                case "Imprimir" -> {
                    int id = Integer.parseInt(request.getParameter("id_ingreso"));
                    RegistroIngreso registroIngreso = ridao.listarid(id);

                    // Generar el PDF
                    RegistroIngresoDAO pdfGenerator = new RegistroIngresoDAO();
                    String dest = "C:/Users/usuario/Documents/NetBeansProjects/Parqueadero/Parqueaderorecibo_" + id + ".pdf";
                    pdfGenerator.generateReceipt(registroIngreso, dest);

                    // Enviar mensaje de confirmación o redirigir a la lista
                    request.setAttribute("mensaje", "Recibo generado correctamente. Descargue el recibo desde <a href='" + dest + "'>aquí</a>.");
                    request.getRequestDispatcher("Controlador?menu=RegistroIngreso&accion=Listar").forward(request, response);
                    break;
                }

            }
        }

        if (menu != null && menu.equals("RegistroSalida")) {
            switch (accion) {
                case "Listar" -> {
                    List<RegistroSalida> lista = rsdao.Listar();
                    request.setAttribute("registrosalidas", lista);
                    request.getRequestDispatcher("RegistroSalida.jsp").forward(request, response);
                }
                case "Agregar" -> {
                    int id_entrada = Integer.parseInt(request.getParameter("txtIdEntrada"));
                    String fechaHoraStr = request.getParameter("txtFechaSalida");
                    int monto_pagado = Integer.parseInt(request.getParameter("txtMontoPagado"));
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    java.util.Date fechaHoraUtil = null;
                    java.sql.Timestamp fechaHoraSQL = null;
                    System.out.println("Fecha y hora sin convertir: " + fechaHoraStr);
                    try {
                        // Convertir la cadena a un objeto Date de java.util.Date
                        fechaHoraUtil = formato.parse(fechaHoraStr);
                        // Convertir java.util.Date a java.sql.Timestamp
                        fechaHoraSQL = new java.sql.Timestamp(fechaHoraUtil.getTime());
                        // Imprimir la fecha y hora como java.sql.Timestamp
                        System.out.println("Fecha y hora como java.sql.Timestamp: " + fechaHoraSQL);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    RegistroSalida rs = new RegistroSalida();
                    rs.setId_entrada(id_entrada);
                    rs.setFecha_salida(fechaHoraSQL);
                    rs.setMonto_pagado(monto_pagado);
                    rsdao.Agregar(rs);

                    request.getRequestDispatcher("Controlador?menu=RegistroSalida&accion=Listar").forward(request, response);
                }
                case "Editar" -> {
                    int id_salida = Integer.parseInt(request.getParameter("id_salida"));
                    RegistroSalida registroSalidaEditar = rsdao.listarid(id_salida);
                    request.setAttribute("registrosalida", registroSalidaEditar);
                    request.getRequestDispatcher("Controlador?menu=RegistroSalida&accion=Listar").forward(request, response);
                }
                case "Actualizar" -> {
                    int id_salida = Integer.parseInt(request.getParameter("id_salida"));
                    int id_entrada = Integer.parseInt(request.getParameter("txtIdEntrada"));
                    String fechaHoraStr = request.getParameter("txtFechaSalida");
                    int monto_pagado = Integer.parseInt(request.getParameter("txtMontoPagado"));
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    java.util.Date fechaHoraUtil = null;
                    java.sql.Timestamp fechaHoraSQL = null;
                    System.out.println("Fecha y hora sin convertir: " + fechaHoraStr);
                    try {
                        // Convertir la cadena a un objeto Date de java.util.Date
                        fechaHoraUtil = formato.parse(fechaHoraStr);
                        // Convertir java.util.Date a java.sql.Timestamp
                        fechaHoraSQL = new java.sql.Timestamp(fechaHoraUtil.getTime());
                        // Imprimir la fecha y hora como java.sql.Timestamp
                        System.out.println("Fecha y hora como java.sql.Timestamp: " + fechaHoraSQL);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    RegistroSalida rs = new RegistroSalida();
                    rs.setId_salida(id_salida);
                    rs.setId_entrada(id_entrada);
                    rs.setFecha_salida(fechaHoraSQL);
                    rs.setMonto_pagado(monto_pagado);
                    rsdao.Actualizar(rs);

                    request.getRequestDispatcher("Controlador?menu=RegistroSalida&accion=Listar").forward(request, response);
                }
                case "Delete" -> {
                    int id_salida = Integer.parseInt(request.getParameter("id_salida"));
                    rsdao.Delete(id_salida);
                    request.getRequestDispatcher("Controlador?menu=RegistroSalida&accion=Listar").forward(request, response);
                }
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
