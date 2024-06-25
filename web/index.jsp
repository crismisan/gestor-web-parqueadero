<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <title>Login</title>

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

  <section class="fondologin">
    <div class="container">
      <div class="rowlogin">
        <div class="section-headingLogin" >

            <div class="login__header">
                
                    <img class="img_log"  src="assets/images/Logo-AutoPark-Ancho.png" alt="">
                
            </div>
        
            <form action= "Controlador?accion=ingresar&redirect=Home.jsp" class="login__form"  method="post">
        
              <div>
                <label for="email">Usuario</label><br>
                <input type="email" id="email" name="txtcorreo" placeholder=" ejemplo@mail.com"pattern="[^ @]*@[^ @]*" required="">
              </div>
        
              <div>
                <label for="password">Contraseña </label><a href="index.html"> ¿Olvidaste?</a><br>
                <input type="password" id="password" name="txtcontraseña" placeholder=" ***********">
              </div>
              
              <div>
                  <button type="submit" name="accion" id="form-submit" class="orange-button" value="ingresar" >Ingresar</button>
              </div>
              <div>
                <label for="password">¿No eres miembro? </label><a href="SolicitarCuenta.jsp"> Solicitar cuenta</a>
              </div>
        
            </form>
        
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

  <!-- Scripts -->
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
