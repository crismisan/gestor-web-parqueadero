<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <title>Inicio </title>

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
                              <li><a>${correo}</a></li>
                              <li><a href="Principal.jsp" class="dropdown-item" ><strong><i class="fa-solid fa-power-off"></i> Cerrar Sesión</strong></a></li>
                            </ul>
                        </li>
                        
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
 

<!-- ***** Tabla de registros ***** -->
  <section class="calculator" style="margin-top: 0px; padding: 130px 0px;">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="section-heading">
            <h6>Estado</h6>
            <h4><i class="fa-solid fa-car-side"></i> Parqueadero </h4>
          </div>
          <div class="col-lg-12">
            <div class="naccs">
              <div class="tabs">
                <div class="row">
                  <div class="col-lg-12">

                    <table class="listado">
                      <thead>
                        <th>N° Parqueadero</th>
                        <th>Tipo de vehiculo</th>
                        <th>Placa</th>
                        <th>Fecha Ingreso</th>
                        <th>Marcar salida</th>
                      </thead>
                      <tbody>
                        <c:forEach var="u" items="${vehiculosActivos}">
                          <tr>
                            <td>${u.getNumero_parqueadero()}</td> <!-- <td>N° Parqueadero</td> -->
                            <td>${u.getTipo()}</td> <!-- <td>Tipo VH</td> -->
                            <td>${u.getPlaca()}</td>     <!-- <td>Placa</td> -->
                            <td>${u.getFecha_ingreso()}</td>  <!-- <td>Fecha Ingreso</td> -->
   

                            <td class="icono"><a href="Controlador?menu=Usuario&accion=Editar&id_usuario=${u.getId_usuario()}"><span class="fa-solid fa-square-arrow-up-right fa-2x"></span></a></td>	
                            
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



  <section class="what-we-do">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="right-items">
            <div class="row">
              <div class="col-lg-6">
                <div class="item">
                  <em>01</em>
                  <h4>Módulo Registro<br>de Vehículos</h4>
                  <p> Permite la creación y mantenimiento de una base de datos de vehículos que utilizan el parqueadero</p>
                </div>
              </div>
              <div class="col-lg-6">
                <div class="item">
                  <em>02</em>
                  <h4>Módulo Registro<br>de Propietarios</h4>
                  <p>Diseñado para almacenar información de los propietarios o usuarios habituales del parqueadero.</p>
                </div>
              </div>
              <div class="col-lg-6">
                <div class="item">
                  <em>03</em>
                  <h4>Módulo Ingreso<br>de Vehículo</h4>
                  <p>Gestiona la entrada de vehículos al parqueadero. Registra la hora de llegada, asigna un espacio de estacionamiento y emite un tiquete.</p>
                </div>
              </div>
              
              <div class="col-lg-6">
                <div class="item">
                  <em>04</em>
                  <h4>Módulo Salida<br>de Vehículo</h4>
                  <p>Controla la salida de los vehículos. Calcula el tiempo de estancia y el costo asociado, emite recibo de pago y actualiza el estado del espacio de estacionamiento. </p>
                </div>
              </div>

              <div class="col-lg-12">
                <div class="item">
                  <em>05</em>
                  <h4>Módulo Registro de Espacios</h4>
                  <p>Permite registrar y monitorear cada uno de los espacios de estacionamiento. <br>Ofrece una visión en tiempo real de la ocupación, permitiendo identificar rápidamente los espacios libres y los ocupados.</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <footer style="margin-top: 50px;">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <p>Copyright © 2024 Universidad Distrital Francisco José de Caldas. 
          
          <br>Designed by <a  rel="sponsored" >Santiago Sáenz & Christian Sánchez</a></p>
        </div>
      </div>
    </div>
  </footer>

</nav>
        <div class="m-4" style="height: 550px;">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
        </div>
  <!-- Scripts -->
  <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/isotope.min.js"></script>
    <script src="assets/js/owl-carousel.js"></script>

    <script src="assets/js/tabs.js"></script>
    <script src="assets/js/swiper.js"></script>
    <script src="assets/js/custom.js"></script>
    <script>
        var interleaveOffset = 0.5;

      var swiperOptions = {
        loop: true,
        speed: 1000,
        grabCursor: true,
        watchSlidesProgress: true,
        mousewheelControl: true,
        keyboardControl: true,
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        },
        on: {
          progress: function() {
            var swiper = this;
            for (var i = 0; i < swiper.slides.length; i++) {
              var slideProgress = swiper.slides[i].progress;
              var innerOffset = swiper.width * interleaveOffset;
              var innerTranslate = slideProgress * innerOffset;
              swiper.slides[i].querySelector(".slide-inner").style.transform =
                "translate3d(" + innerTranslate + "px, 0, 0)";
            }      
          },
          touchStart: function() {
            var swiper = this;
            for (var i = 0; i < swiper.slides.length; i++) {
              swiper.slides[i].style.transition = "";
            }
          },
          setTransition: function(speed) {
            var swiper = this;
            for (var i = 0; i < swiper.slides.length; i++) {
              swiper.slides[i].style.transition = speed + "ms";
              swiper.slides[i].querySelector(".slide-inner").style.transition =
                speed + "ms";
            }
          }
        }
      };

      var swiper = new Swiper(".swiper-container", swiperOptions);
    </script>
  </body>
</html>