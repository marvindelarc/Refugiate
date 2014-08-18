<%-- 
    Document   : index
    Created on : 15/11/2013, 03:19:57 PM
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
        <title>Ref&uacute;giate</title>
        <link rel="shortcut icon" type="img/x-icon" href="new/img/favicon.ico" />

        <link href='http://fonts.googleapis.com/css?family=Coda' rel='stylesheet' type='text/css' />
        <link href='http://fonts.googleapis.com/css?family=Jura:400,500,600,300' rel='stylesheet' type='text/css' />
        
        <link rel="stylesheet" href="new/css/formulario.css" type="text/css"/>	
        <link rel="stylesheet" href="new/css/table.css" type="text/css"/>	
        <link rel="stylesheet" href="new/css/style.css" type="text/css" media="all" />
        
        <script src="new/js/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="new/js/jquery.touchwipe.1.1.1.js" type="text/javascript"></script>
        <script src="new/js/jquery.carouFredSel-5.5.0-packed.js" type="text/javascript"></script>
        <!--[if lt IE 9]><script src="new/js/modernizr.custom.js"></script><![endif]-->
        <script src="new/js/functions.js" type="text/javascript"></script>
    </head>
<body>
    <!-- wrapper -->
    <div class="wrapper">
        <!-- header -->
        <header class="header">
            <div class="shell">
                <div class="header-top">
                    <h1 id="logo"><img  src="new/img/logo_refugiate.png" width="130" height="75"/></h1>
                    <nav id="navigation">
                        <ul>
                            <li class="active home"><a href="index.jsp">Inicio</a></li>
                            <li><a href="afiliate1.jsp">Afiliate</a></li>
                            <li><a href="conocenos.jsp">Conocenos</a></li>
                            <li><a href="servicios.jsp">Servicios</a></li>
                            <li><a href="InciarSesion.jsp">Iniciar Sesion</a></li>																					
                        </ul>
                    </nav>
                    <div class="cl">&nbsp;</div>
                </div>
                <div class="slider">
                    <div id="bg"></div>
                    <div id="carousel">
                        <div>
                            <h3>RefugiateApp</h3>
                            <h5>Busqueda de establecimientos</h5>
                            <p>Esta aplicacion ANDROID brindara al Usuario una guia de todos los hoteles mas cercanos 
                                    a su ubicacion,como tambien datos como: categoria, telefonos de contacto entre otros..</p>
                            <a href="Refugiate.apk" class="green-btn">Descargar APK</a>							 
                            <img class="img-front" src="new/img/movil/0.1.1.jpg" alt="dot1" width="260" height="400" />
                            <img class="img-mid" src="new/img/movil/1.0.jpg" alt="dot2" width="230" height="350" />
                            <img class="img-back" src="new/img/movil/2.jpg" alt="dot3" width="195" height="300" />
                        </div>
                        <div>
                            <h3>RefugiateApp</h3>
                            <h5>Buscar establecimientos cercanos</h5>
                            <p>Con el GPS ensendido podra visualizar los establecimientos cercanos a su ubicacion, asi como
                                filtrar los locales por distancia ...</p>
                            <a href="Refugiate.apk" class="green-btn">Descargar APK</a>							 
                            <img class="img-front" src="new/img/movil/1.3.jpg" alt="dot1" width="260" height="400" />
                            <img class="img-mid" src="new/img/movil/1.4.jpg" alt="dot2" width="230" height="350" />
                            <img class="img-back" src="new/img/movil/1.2.jpg" alt="dot3" width="195" height="300" />
                        </div>
                        <div>
                            <h3>RefugiateApp</h3>
                            <h5>Configuración Personalizada</h5>
                            <p>El usuario podrá seleccionar el tiempo de actualizacion de datos, así como predefinir el momento que
                                desea se le recuerde sus reservas pendientes, filtrar la propaganda según el nivel de estrellas ...</p>
                            <a href="Refugiate.apk" class="green-btn">Descargar APK</a>							 
                            <img class="img-front" src="new/img/movil/0.1.jpg" alt="dot1" width="260" height="400" />
                            <img class="img-mid" src="new/img/movil/1.0.jpg" alt="dot2" width="230" height="350" />
                            <img class="img-back" src="new/img/movil/2.jpg" alt="dot3" width="195" height="300" />
                        </div>
                        <div>
                            <h3>RefugiateApp</h3>
                            <h5>Busqueda Personalizada Pro Filtros</h5>
                            <p>Cuenta con muchos filtros de busqueda, para encontrar establecimientos que cumplan con los  datos 
                                establecidos por el usuario ...</p>
                            <a href="Refugiate.apk" class="green-btn">Descargar APK</a>							 
                            <img class="img-front" src="new/img/movil/8.jpg" alt="dot1" width="260" height="400" />
                            <img class="img-mid" src="new/img/movil/5.0.jpg" alt="dot2" width="230" height="350" />
                            <img class="img-back" src="new/img/movil/5.1.jpg" alt="dot3" width="195" height="300" />
                        </div>
                    </div>
                    <div class="pagination"></div>
                    <a id="prev" href="#"></a>
                    <a id="next" href="#"></a>
                </div>
            </div>
        </header>
        <!-- end of header -->
        <!-- shell -->
        <div class="shell">
            <!-- main -->
            <div class="main">
                <section class="partners">					
                    <div id="partners-slider">
                        <div class="slider-holder2">
                            <img src="new/img/Hoteles/Sheraton-Hotel-Resorts-logo.jpg" width="140" height="52" />
                            <img src="new/img/Hoteles/hotel_haciendajpg.jpg" width="170" height="52" />
                            <img src="new/img/Hoteles/logo_libertadores.jpg" width="170" height="52" />
                            <img src="new/img/Hoteles/logo_pullman.jpg" width="180" height="52" />
                            <img src="new/img/Hoteles/omac_logo_bravo.png" width="150" height="52" />
                            <img src="new/img/Hoteles/belle-sand.logo.jpg" width="172" height="52" />
                            <img src="new/img/Hoteles/kunturwasi.png" width="215" height="52" />
                            <img src="new/img/Hoteles/posadadelobo.png" width="210" height="52" />						    
                        </div>
                    </div>
                    <div class="slider-arr">
                        <a class="prev-arr arr-btn" href="#"></a>
                        <a class="next-arr arr-btn" href="#"></a>
                    </div>
                </section>
                <div class="socials">
                    <p>Estamos a su disposición. Póngase en contacto con nosotros atraves de:</p>
                    <ul>
                        <li><a href="https://www.facebook.com/Refugiateapp" class="facebook-ico">facebook-ico</a></li>
                        <li><a href="https://twitter.com/RefugiateApp" class="twitter-ico">twitter-ico</a></li>
                        <li><a href="http://www.youtube.com/channel/UCe14ECuDFqcSS4VjvSLsHuw?feature=watch" class="skype-ico">Youtube</a></li>
                        <li><a href="https://plus.google.com/u/1/" class="rss-ico">+Google</a></li>
                    </ul>
                </div>
            </div>
            <!-- end of main -->
        </div>
        <!-- end of shell -->	
        <!-- footer -->
        <div id="footer">
            <!-- shell -->
            <div class="shell">
                <!-- footer-cols -->
                <div class="footer-cols">
                    <div class="col">
                        <h2>SERVICES</h2>
                        <ul>
                            <li><a href="#">Publicidad de establecimiento</a></li>
                            <li><a href="#">Reservas via movil</a></li>
                            <li><a href="#">Web de administracion de resrevas</a></li>							
                        </ul>
                    </div>
                    <div class="col">
                        <h2>SOLUTIONS</h2>
                        <ul>
                            <li><a href="#">Manejo de informacion</a></li>
                            <li><a href="#">Control de las reservas</a></li>                            
                        </ul>
                    </div>
                    <div class="col">
                        <h2>CONTACT us</h2>
                        <p>Email: <a href="#">refugiate.app.h@gmail.com</a></p>
                        <p>Phone: 655-606-605</p>
                        <p>Address: Av. Peru 1099, </p>
                        <p>Trujillo - Peru</p>
                    </div>
                    <div class="cl">&nbsp;</div>
                </div>
                <!-- end of footer-cols -->
                <div class="footer-bottom">					
                    <p class="copy">Copyright &copy; 2013<span>|</span>Design by: 
                        <a href="#" target="_blank">M&T</a>
                    </p>
                    <div class="cl">&nbsp;</div>
                </div>
            </div>
            <!-- end of shell -->
        </div>
        <!-- footer -->
    </div>
    <!-- end of wrapper -->
</body>
</html>