<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>Registro de Estacionamiento</title>

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
                                <li class="scroll-to-section"><a href="#about">facturación</a></li>
                                <li class="has-sub">
                          <a href="javascript:void(0)"><i class="fa-solid fa-user"></i> Sesión</a>
                            <ul class="sub-menu" style="width: auto;">
                              <li><a>${nombreUsuario}</a></li>
                              <li><a>${correo}</a></li>
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
                        <h4><em>Estacionamientos</em></h4>
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
                            <h4><i class="fa-solid fa-warehouse"></i> Formulario </h4>
                        </div>
                    </div>

                    <form id="form_user" action="Controlador?menu=Estacionamiento" method="POST">
                        <div class="row">
                            <div class="col-lg-2">
                                <label for="id plaza">ID</label>
                                <input type="text" value="${estacionamientos.getId_plaza()}" name="txtidplaza" class="form-control" id="id" placeholder="000"  >
                            </div>
                            <div class="col-lg-2">
                                <label for="id usurio">Número</label>
                                <input type="text" value="${estacionamientos.getNumero_plaza()}" name="txtnumero" class="form-control" id="id" placeholder="000"  >
                            </div>

                            <div class="col-lg-3">
                                <label for="Rol" class="form-label">Tipo de vehiculo</label>
                                <select class="form-control" name="txttipo" aria-label="Default select example"  onchange="this.form.click()">
                                    <option value="Carro" ${estacionamientos.getTipo_vehiculo() == "Carro" ? 'selected' : ''} name="option1">Carro</option>
                                    <option value="Moto" ${estacionamientos.getTipo_vehiculo() == "Moto" ? 'selected' : ''} name="option2">Moto</option>
                                    <option value="3 Ejes" ${estacionamientos.getTipo_vehiculo() == "3 Ejes" ? 'selected' : ''} name="option3">3 Ejes</option>
                                </select>
                            </div>
                            <div class="col-lg-2">
                                <label for="Rol" class="form-label">Estado</label>
                                <select class="form-control" name="txtestado" aria-label="Default select example"  onchange="this.form.click()">
                                    <option value="1" ${estacionamientos.getEstado() == 1 ? 'selected' : ''} name="option1">Activo</option>
                                    <option value="2" ${estacionamientos.getEstado() == 2 ? 'selected' : ''} name="option2">Inactivo</option>
                                </select>
                            </div>

                            <div class="col-lg-10" >
                                <div class="col-lg-2" style="float: left;" >
                                    <input type="submit" name="accion" value="Agregar"  class="orange-button">
                                </div>

                                <div class="col-lg-2" style="float: left; margin-left: 15px;">
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
                            <h4><i class="fa-solid fa-right-to-bracket"></i> Estacionamientos Registrados</h4>
                        </div>
                        <div class="col-lg-12">
                            <div class="naccs">
                                <div class="tabs">
                                    <div class="row">
                                        <div class="col-lg-12">

                                            <table class="listado">
                                                <thead>
                                                <th>Id</th>
                                                <th>Numero</th>
                                                <th>Tipo de vehiculo</th>
                                                <th>Estado</th>
                                                <th>Editar</th>
                                                <th>Borrar</th>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="e" items="${estacionamiento}">
                                                        <tr>
                                                            <td>${e.getId_plaza()}</td> <!-- <td>ID</td> -->
                                                            <td>${e.getNumero_plaza()}</td> <!-- <td>Numero</td> --> 
                                                            <td>${e.getTipo_vehiculo()}</td>
                                                            <td>   <!-- <td>Estado</td> -->
                                                                <c:choose>
                                                                    <c:when test="${e.getEstado() == 1}">Activo</c:when>
                                                                    <c:when test="${e.getEstado() == 2}">Inactivo</c:when>
                                                                </c:choose>
                                                            </td>

                                                            <td class="icono"><a href="Controlador?menu=Estacionamiento&accion=Editar&id_plaza=${e.getId_plaza()}"><span class="fa fa-pencil-square-o fa-2x"></span></a></td>	
                                                            <td class="icono"><a href="Controlador?menu=Estacionamiento&accion=Delete&id_plaza=${e.getId_plaza()}"><span class="fa fa-trash fa-2x"></span></a></td>	
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