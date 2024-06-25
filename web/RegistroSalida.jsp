<%-- 
    Document   : RegistroSalida
    Created on : 3/06/2024, 11:36:49 a. m.
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>Registro de Ingreso</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/templatemo-574-mexant.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css">
        <!--
        
        -->
    </head>

    <body>

        <!-- ***** Header Area Start ***** -->
        <header class="header-area header-sticky">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <nav class="main-nav">
                            <!-- ***** Logo Start ***** -->
                            <a href="index.html" class="logo">
                                <img class="imglogo" src="assets/images/Logo-AutoPark-Ancho.png" alt="">
                            </a>
                            <!-- ***** Logo End ***** -->
                            <!-- ***** Menu Start ***** -->
                            <ul class="nav">
                                <li class="scroll-to-section"><a  href="Controlador?menu=Usuario&accion=Listar">Usuario</a></li>
                                <li class="scroll-to-section"><a  href="Controlador?menu=Vehiculo&accion=Listar">Vehiculo</a></li>
                                <li class="scroll-to-section"><a href="Controlador?menu=Estacionamiento&accion=Listar">Estacionamientos</a></li>
                                <li class="scroll-to-section"><a href="Controlador?menu=RegistroIngreso&accion=Listar">Registro de entrada</a></li>
                                                        <li class="scroll-to-section"><a href="Controlador?menu=RegistroSalida&accion=Listar">Registro de Salida</a></li>
                                
                                <li class="has-sub">
                          <a href="javascript:void(0)"><i class="fa-solid fa-user"></i> Sesión</a>
                            <ul class="sub-menu" style="width: auto;">
                              <li><a>${nombreUsuario}</a></li>
                              
                              <li><a href="Principal.jsp" class="dropdown-item" ><strong><i class="fa-solid fa-power-off"></i> Cerrar Sesión</strong></a></li>
                            </ul>
                        </li>
                                <li><a href="contact-us.html">Cerrar Sesión</a></li> 
                            </ul>        
                            <a class='menu-trigger'>
                                <span>Menu</span>
                            </a>
                            <!-- ***** Menu End ***** -->
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- ***** Header Area End ***** -->

        <section class="simple-solicita-cuenta" style="height: 220px;">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5" style="margin-top: 50px;">
                        <h4><em> Ingreso Vehiculos</em></h4>
                    </div>
                </div>
            </div>
        </section>

        <!-- ***** formulario ***** -->
        <section class="about-us" id="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 offset-lg-3">
                        <div class="section-heading">
                            <h6>Ingreso</h6>
                            <h4><i class="fa-solid fa-circle-arrow-down"></i> Formulario </h4>
                        </div>
                    </div>

                    <form id="form_user" action="Controlador?menu=RegistroSalida" method="POST">
                        <div class="row">
                            <div class="col-lg-2">
                                <label for="id salida">ID</label>
                                <input type="text" value="${registrosalida.getId_salida()}" name="id_salida" class="form-control" id="id" placeholder="000" readonly  >
                            </div>
                            
                            <div class="col-lg-2">
                                <label for="id ingreso">ID</label>
                                <input type="text" value="${registrosalida.getId_entrada()}" name="txtIdEntrada" class="form-control" id="id"  >
                            </div>
                            <div class="col-lg-2">
                                <label for="fecha salida">Fecha Salida</label>
                                <input type="datetime-local" value="${registroingreso.getFecha_salida()}" name="txtFechaSalida" class="form-control" id="id"   >
                            </div>
                            <div class="col-lg-2">
                                <label for="monto pagado">Monto Pagado</label>
                                <input type="text" value="${registrosalida.getMonto_pagado()}" name="txtMontoPagado" class="form-control" id="id"   >
                            </div>
                           
                            <div class="col-lg-12" >
                                <div class="col-lg-2" style="float: right;" >
                                    <input type="submit" name="accion" value="Agregar"  class="orange-button">
                                </div>

                                <div class="col-lg-2" style="float: right; margin-right: 15px;">
                                    <input type="submit" name="accion" value="Actualizar" class="orange-button">
                                </div>
                            </div>

                        </div> 
                    </form>
                </div>
            </div>
        </section>


        <!-- ***** Tabla de registros ***** -->
        <section class="calculator" style="margin-top: 0px;">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-heading">
                            <h6>Tabla</h6>
                            <h4><i class="fa-solid fa-car-rear"></i> Vehiculos Ingresados</h4>
                        </div>
                        <div class="col-lg-12">
                            <div class="naccs">
                                <div class="tabs">
                                    <div class="row">
                                        <div class="col-lg-12">

                                            <table class="listado">
                                                <thead>
                                                <th>Id Salida </th>
                                                <th>Id Entrada</th>
                                                <th>Fecha Salida</th>
                                                <th>Monto Pagado</th>
                                                <th>Editar</th>
                                                <th>borrar</th>
                                                <..!<!-- <th>Imprimir</th> --> 
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="u" items="${registrosalidas}">
                                                        <tr>
                                                            <td>${u.getId_salida()}</td> <!-- <td>ID</td> -->
                                                            <td>${u.getId_entrada()}</td> <!-- <td>N° ticket</td> -->
                                                            <td>${u.getFecha_salida()}</td>     <!-- <td>Tipo de Vehiculo</td> -->
                                                            <td>${u.getMonto_pagado()}</td>  <!-- <td>N° de parqueadero</td> -->
                                                            <td class="icono"><a href="Controlador?menu=RegistroSalida&accion=Editar&id_salida=${u.getId_salida()}"><span class="fa fa-pencil-square-o fa-2x"></span></a></td>	
                                                            <td class="icono"><a href="Controlador?menu=RegistroSalida&accion=Delete&id_salida=${u.getId_salida()}"><span class="fa fa-trash fa-2x"></span></a></td>	
                                                            <--<!--  <td class="icono"><a href="Controlador?menu=RegistroIngreso&accion=Imprimir&id_ingreso="><span class="fa fa-print fa-2x"></span></a></td> -->
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>





        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright © 2024 Universidad Distrital Francisco José de Caldas. 

                            <br>Designed by <a  rel="sponsored" >Santiago Sáenz & Christian Sánchez</a></p>
                    </div>
                </div>
            </div>
        </footer>

        <!-- Scripts table -->
        <script src="https://use.fontawesome.com/bf66789927.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <script src="assets/js/isotope.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>

        <script src="assets/js/tabs.js"></script>
        <script src="assets/js/swiper.js"></script>
        <script src="assets/js/custom.js"></script>
    </body>
</html>