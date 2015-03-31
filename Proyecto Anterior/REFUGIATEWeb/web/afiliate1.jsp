<%-- 
    Document   : afiliate
    Created on : 12/06/2013, 03:09:46 PM
    Author     : Paulo
--%>

<%@page import="Entidades.clsDepartamento"%>
<%@page import="java.util.List"%>
<%@page import="COM.clsGestor"%>
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
        
        <script type="text/javascript" src="new/js/jquery.ketchup.js"></script>
        <script type="text/javascript" src="new/js/jquery.ketchup.helpers.js"></script>
        <script type="text/javascript" src="new/js/jquery.ketchup.validations.js"></script>
        <link rel="stylesheet" href="new/css/jquery.ketchup.css" type="text/css" media="screen">
                
        <Script src="AJAX/ajax_Provincia.js"></Script>
        <Script src="AJAX/ajax_Distrito.js"></Script>       
        <%  
            clsGestor objGestor = new clsGestor();
            List<clsDepartamento> ListDepartamento = objGestor.listarDepartamento();
        %>
        <script type="text/javascript">
            jQuery(document).ready(function(){	
                $('#default-behavior').ketchup();
                $("#Departamento").change();
                $("#Distrito").change();
            });
        </script> 
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
                            <li><a href="index.jsp">Inicio</a></li>
                            <li class="active home"><a href="afiliate1.jsp">Afiliate</a></li>
                            <li><a href="conocenos.jsp">Conocenos</a></li>
                            <li><a href="servicios.jsp">Servicios</a></li>
                            <li><a href="InciarSesion.jsp">Iniciar Sesion</a></li>																					
                        </ul>
                    </nav>
                    <div class="cl">&nbsp;</div>
                </div>
                <div class="slider">
                    <div id="bg"></div>
                        <form  id="default-behavior" class="table_cs" method="post" action="afiliate2.jsp">
                            <center>
                                <h2 id="h2_cs">Ingresar Datos De La Empresa</h2>
                                <table>
                                    <tr class="tr_cs">
                                        <td class="td_cs"><label class="label_cs">Nombre Comercial:</label></td>
                                        <td class="td_cs">
                                            <input class="texto_cs" id="nombreComercial" name="nombreComercial" type="text" placeholder="nombre comercial" data-validate="validate(required)" autofocus >   
                                        </td>                                
                                    </tr>
                                    <tr class="tr_cs">
                                        <td class="td_cs"><label class="label_cs">Nombre:</label></td>
                                        <td class="td_cs">
                                            <input class="texto_cs" id="nombre" name="nombre" type="text" placeholder="nombre" data-validate="validate(required)" autofocus >   
                                        </td>                                
                                    </tr>
                                    <tr class="tr_cs">
                                        <td class="td_cs"><label class="label_cs">Slogan:</label></td>
                                        <td class="td_cs">
                                            <input class="texto_cs" id="slogan" name="slogan" type="text" placeholder="slogan" data-validate="validate(required)" autofocus >   
                                        </td>                                
                                    </tr>
                                    <tr class="tr_cs">
                                        <td class="td_cs"><label class="label_cs">RUC:</label></td>
                                        <td class="td_cs">
                                             <input class="texto_cs" style="width: 200px" id="ruc" name="ruc" type="text" placeholder="RUC" data-validate="validate(required, digits, maxlength(11) ,minlength(11))" autofocus >   
                                        </td>                                
                                    </tr>
                                    <tr class="tr_cs">
                                        <td class="td_cs"><label class="label_cs">Departamento:</label></td>
                                        <td class="td_cs">
                                             <select class="select_cs" name="cbDepartamento" id="Departamento" onchange="getProvincia(this.value)">
                                            <%  if(ListDepartamento!=null) 
                                                for(clsDepartamento objDepartamento : ListDepartamento ) {%>

                                                <option value="<%=objDepartamento.getInt_IdDepartamento()%>"><%=objDepartamento.getStr_Nombre()%></option>
                                             <%  }%>
                                             </select>
                                        </td>                                
                                    </tr>
                                    <tr class="tr_cs">
                                        <td class="td_cs"><label class="label_cs">Proviancia:</label></td>
                                        <td id="result_detalle" class="td_cs">
                                            <select class="select_cs" name="cbProvincia" id="cbProvincia" >
                                            </select>
                                        </td>                            
                                    </tr>
                                    <tr class="tr_cs">
                                        <td class="td_cs"><label class="label_cs">Distrito:</label></td>
                                        <td id="result_mas_detalle" class="td_cs">
                                            <select class="select_cs" name="cbDistrito" id="cbDistrito" >
                                            </select>
                                        </td>                     
                                    </tr>
                                    <tr class="tr_cs">
                                         <td colspan="2" class="td_cs espacio_cs">
                                            <center><input class="btn" type="submit" value="Aceptar" /></center>
                                        </td>
                                    </tr>
                                </table>
                            </center>
                        </form> 
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
                              
                            