
<%@page import="Entidades.clsEmpresa"%>
<%@page import="Entidades.clsSucursal"%>
<%@page import="Entidades.clsDistrito"%>
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
        <link rel="stylesheet" href="new/css/jquery.ketchup.css" type="text/css" media="screen">
        <link rel="stylesheet" href="new/css/style.css" type="text/css" media="all" />
        
        <script src="new/js/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="new/js/jquery.touchwipe.1.1.1.js" type="text/javascript"></script>
        <script src="new/js/jquery.carouFredSel-5.5.0-packed.js" type="text/javascript"></script>
        <!--[if lt IE 9]><script src="new/js/modernizr.custom.js"></script><![endif]-->
        <script src="new/js/functions.js" type="text/javascript"></script>     
        
        <%  
            clsGestor objGestor=new clsGestor(); 
            clsSucursal objSucursal =(clsSucursal) request.getSession(true).getAttribute("SessionSucursal");
            if( request.getParameter("longitud") != null && request.getParameter("longitud") != "" &&
                request.getParameter("latitud") != null && request.getParameter("latitud") != "" &&     
                request.getParameter("direcion") != null && request.getParameter("direcion") != ""){

                objSucursal.setDou_Longitud(Double.parseDouble(request.getParameter("longitud")));
                objSucursal.setDou_Latitud(Double.parseDouble(request.getParameter("latitud")));
                objSucursal.setStr_Direccion(request.getParameter("direcion"));
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("SessionSucursal",objSucursal); 
            }
        %>

        <script type="text/javascript" src="new/js/jquery.ketchup.js"></script>
        <script type="text/javascript" src="new/js/jquery.ketchup.helpers.js"></script>
        <script type="text/javascript" src="new/js/jquery.ketchup.validations.js"></script>
                
        <script type="text/javascript">
        $(document).ready(function () {
            $('#default-behavior').ketchup();

            $('#entrada').timepicker({
               showMinutes: false,
               showPeriod: true,
                  showLeadingZero: true,
                onHourShow: tpStartOnHourShowCallback,
                onMinuteShow: tpStartOnMinuteShowCallback
            });
            $('#salida').timepicker({
               showMinutes: false,
                 showPeriod: true,
               showLeadingZero: true,
                onHourShow: tpEndOnHourShowCallback,
                onMinuteShow: tpEndOnMinuteShowCallback
            });

        });
        function tpStartOnHourShowCallback(hour) {
            var tpEndHour = $('#salida').timepicker('getHour');
            if ($('#salida').val() == '') { return true; }
            if (hour <= tpEndHour) { return true; }
            return false;
        }
        function tpStartOnMinuteShowCallback(hour, minute) {
            var tpEndHour = $('#salida').timepicker('getHour');
            var tpEndMinute = $('#salida').timepicker('getMinute');
            if ($('#salida').val() == '') { return true; }
            if (hour < tpEndHour) { return true; }
            if ((hour == tpEndHour) && (minute < tpEndMinute)) { return true; }
            return false;
        }

        function tpEndOnHourShowCallback(hour) {
            var tpStartHour = $('#entrada').timepicker('getHour');
            if ($('#entrada').val() == '') { return true; }
            if (hour >= tpStartHour) { return true; }
            return false;
        }
        function tpEndOnMinuteShowCallback(hour, minute) {
            var tpStartHour = $('#entrada').timepicker('getHour');
            var tpStartMinute = $('#entrada').timepicker('getMinute');
            if ($('#entrada').val() == '') { return true; }
            if (hour > tpStartHour) { return true; }
            if ((hour == tpStartHour) && (minute > tpStartMinute)) { return true; }
            return false;
        }
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
                <div class="slider" style="height: 510px;">
                    <div id="bg"></div>                    
                        <form class="table_cs" id="default-behavior" method="get" action="afiliate4.jsp">
                            <center>
                                <h1 id="h1_cs"><center>Datos de Empresa</center></h1>
                                <table>
                                    <tr class="tr_cs">
                                       <td class="td_cs">
                                           <label class="label_cs">Nombre Comercial:</label>
                                       </td>
                                       <td class="td_cs">
                                           <label class="texto_cs"><%=objSucursal.getObjEmpresa().getStr_NombreComercial()%></label>  
                                       </td>
                                       <td class="td_cs">
                                           <label class="label_cs">Nombre:</label>
                                       </td>
                                       <td class="td_cs">
                                           <label class="texto_cs"><%=objSucursal.getObjEmpresa().getStr_Nombre()%></label>
                                       </td>
                                       <td class="td_cs">
                                            <label class="label_cs">Distrito:</label>
                                       </td>
                                       <td class="td_cs">
                                           <label class="texto_cs"><%=objSucursal.getObjDistrito().getStr_Nombre()%></label>  
                                        </td>                                                        
                                   </tr>
                                    <tr class="tr_cs">
                                       <td class="td_cs">
                                           <label class="label_cs">Slogan:</label>
                                       </td>
                                       <td class="td_cs">
                                           <label class="texto_cs"><%=objSucursal.getObjEmpresa().getStr_Slogan()%></label>
                                       </td>                                
                                       <td class="td_cs">
                                           <label class="label_cs">RUC:</label>
                                       </td>
                                       <td class="td_cs">
                                           <label class="texto_cs"><%=objSucursal.getObjEmpresa().getStr_Ruc()%></label>
                                       </td>                                
                                    </tr>                                                              
                                    <tr>
                                        <td colspan="3">
                                            <h2 id="h2_cs"><center> Datos de Encargado</center></h3>
                                            <table>
                                                <tr class="tr_cs">                                       
                                                    <td class="td_cs">                                                        
                                                       <label class="label_cs">Nombres:</label>
                                                   </td>
                                                   <td class="td_cs">
                                                        <input class="texto_cs" id="nombres" name="nombres" type="text" placeholder="nombres" autofocus data-validate="validate(required)">   
                                                   </td>                                
                                               </tr>
                                                <tr class="tr_cs">
                                                    <td class="td_cs">                                                        
                                                       <label class="label_cs">Apellidos:</label>
                                                    </td>
                                                    <td class="td_cs">
                                                        <input class="texto_cs" id="apellidos" name="apellidos" type="text" placeholder="apellidos" autofocus data-validate="validate(required)" >   
                                                    </td>                                
                                                </tr>
                                                <tr class="tr_cs">
                                                    <td class="td_cs">                                                        
                                                       <label class="label_cs">Usuario:</label>
                                                    </td>
                                                    <td class="td_cs">
                                                        <input class="texto_cs" id="usuario" name="usuario" type="text" placeholder="usuario" autofocus data-validate="validate(required)">   
                                                    </td>                                
                                                </tr>
                                                <tr class="tr_cs">
                                                    <td class="td_cs">                                                        
                                                        <label class="label_cs">Password:</label>
                                                    </td>
                                                    <td class="td_cs">
                                                        <input class="texto_cs" id="pass" name="pass" type="password" placeholder="password" autofocus data-validate="validate(required)">   
                                                    </td>                                
                                                </tr>
                                                <tr class="tr_cs">
                                                    <td class="td_cs">                                                        
                                                        <label class="label_cs">Email:</label>
                                                   </td>
                                                   <td class="td_cs">
                                                        <input class="texto_cs" id="email" name="email" type="text" placeholder="email" autofocus data-validate="validate(required,email)">   
                                                   </td>                                
                                                </tr>
                                                <tr class="tr_cs">
                                                    <td class="td_cs">                                                        
                                                        <label class="label_cs">Celular:</label>
                                                   </td>
                                                   <td class="td_cs">
                                                        <input class="texto_cs" id="celular" name="celular" type="text" placeholder="celular"  autofocus  data-validate="validate(required, digits, maxlength(9) ,minlength(9))">   
                                                   </td>                                
                                                </tr>                                            
                                            </table>
                                        </td>
                                        <td colspan="3">
                                            <h2 id="h2_cs"><center>Datos de Sucursal</center></h3>
                                            <table>
                                                <tr class="tr_cs">
                                                    <td class="td_cs">                                                        
                                                        <label class="label_cs">Dirección:</label>
                                                    </td>
                                                    <td class="td_cs">
                                                        <label class="texto_cs"><%=objSucursal.getStr_Direccion()%></label>
                                                    </td>
                                                </tr>
                                                <tr class="tr_cs">
                                                    <td class="td_cs">                                                        
                                                        <label class="label_cs">Pisos:</label>
                                                    </td>
                                                    <td class="td_cs">
                                                        <input class="texto_cs" name="pisos" type="text" placeholder="nª de pisos" autofocus data-validate="validate(required, digits, min(0))">
                                                    </td>
                                                </tr>
                                             <tr class="tr_cs">
                                                <td class="td_cs">                                                        
                                                    <label class="label_cs">Telefono:</label>
                                                </td>
                                                <td class="td_cs">
                                                    <input class="texto_cs" name="telefono" type="text" placeholder="telefono" autofocus data-validate="validate(required, digits, maxlength(9) ,minlength(9))">
                                                </td>
                                            </tr>                                       
                                            <tr class="tr_cs">
                                                <td class="td_cs">                                                        
                                                    <label class="label_cs">Hora Entrada:</label>
                                                </td>
                                                <td class="td_cs">
                                                    <input class="texto_cs" id="entrada" name="entrada" type="text" placeholder="hora de entrada" autofocus data-validate="validate(required)" >
                                                </td>
                                            </tr>
                                            <tr class="tr_cs">
                                                <td class="td_cs">                                                        
                                                    <label class="label_cs">Hora Salida:</label>
                                                </td>
                                                <td class="td_cs">
                                                    <input class="texto_cs" id="salida" name="salida"  type="text" placeholder="hora de salida" autofocus data-validate="validate(required)" >
                                                </td>
                                            </tr>
                                            <tr class="tr_cs">
                                                <td class="td_cs">                                                        
                                                    <label class="label_cs">Nivel:</label>
                                                </td>
                                                <td class="td_cs">                                                    
                                                       <select class="select_cs" name="cbNivel" id="cbNivel">
                                                            <option value="1">1 Estrella</option>
                                                            <option value="2">2 Estrella</option>
                                                            <option value="3">3 Estrella</option>
                                                            <option value="4">4 Estrella</option>
                                                            <option value="5">5 Estrella</option></select>
                                                </td>
                                            </tr>
                                        </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="6" class="td_cs espacio_cs">
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