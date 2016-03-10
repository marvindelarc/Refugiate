<%@page import="Entidades.clsEncargado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    clsEncargado objEncargado = (clsEncargado) request.getSession().getAttribute("SessionEncargado");
    if (objEncargado == null) {
%>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <title>Refugiate Web - Administrativa</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="Refugiate Web" name="desceription" />
        <meta content="Marvin de la Cruz Razon" name="author" />
        <!-- BEGIN CORE CSS FRAMEWORK -->
        <link href="./login_files/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen">
        <link href="./login_files/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="./login_files/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="./login_files/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="./login_files/animate.min.css" rel="stylesheet" type="text/css">
        <!-- END CORE CSS FRAMEWORK -->
        <!-- BEGIN CSS TEMPLATE -->
        <link href="./login_files/style.css" rel="stylesheet" type="text/css">
        <link href="./login_files/responsive.css" rel="stylesheet" type="text/css">
        <link href="./login_files/custom-icon-set.css" rel="stylesheet" type="text/css">
        <link href="assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
        <!-- END CSS TEMPLATE -->
        <meta name="chromesniffer" id="chromesniffer_meta" content="{&quot;jQuery&quot;:&quot;1.8.3&quot;}">
        <script type="text/javascript" src="chrome-extension://homgcnaoacgigpkkljjjekpignblkeae/detector.js"></script>
    </head>
    <!-- END HEAD -->
    <!-- BEGIN BODY -->
    <body class="error-body no-top  pace-done">
        <div class="pace pace-inactive">
            <div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
                <div class="pace-progress-inner"></div>
            </div>
            <div class="pace-activity"></div>            
        </div>
        <div class="container">
            <div class="row login-container column-seperation">  
                <div class="col-md-5 col-md-offset-1 ">
                    <img src="assets/img/logo.png" alt="" class="center-block"/>
                    <a href="registrar.jsp"> <img src="assets/img/register.png" style="width:290px;" class="center-block"/> </a>
                    <button class="btn btn-block btn-info col-md-8" type="button">                    
                        <font color="white" size="4px">Siguenos en Facebook</font>
                    </button>
                </div>
                <div class="col-md-5 "> <br>
                    <form id="login-form" class="login-form" >
                        <div class="row">
                            <div class="form-group col-md-10">
                                <label class="form-label">Usuario:</label>
                                <div class="controls">
                                    <div class="input-with-icon  right">                                       
                                        <i class=""></i>
                                        <input type="text" name="txtUsername" id="txtUsername" class="form-control">                                 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-10">
                                <label class="form-label">Contrase&ntilde;a:</label>
                                <span class="help"></span>
                                <div class="controls">
                                    <div class="input-with-icon  right">                                       
                                        <i class=""></i>
                                        <input type="Password" name="txtPassword" id="txtPassword" class="form-control">                                 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="control-group  col-md-10">
                                <a href="#">¿Olvidaste tu contrase&ntilde;a?</a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-10">
                                <button class="btn btn-primary btn-cons pull-right" type="submit">Ingresar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="myModal" class="modal hide fade" tabindex="-2" style="width:200px; height:70; display: block; margin-top: auto;  margin-left: auto;margin-right: auto;"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
            <div class="modal-body">
                <div class="row-fluid">
                    <center><h4><img width="60" height="60" src="assets/img/cargando.gif" alt=""/>Espere <span class="semi-bold">...</span></h4></center>
                </div>
            </div>
        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN CORE JS FRAMEWORK-->
        <script src="./login_files/jquery-1.8.3.min.js" type="text/javascript"></script>
        <script src="./login_files/bootstrap.min.js" type="text/javascript"></script>
        <script src="./login_files/pace.min.js" type="text/javascript"></script>
        <script src="./assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="assets/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>
        <!-- BEGIN CORE TEMPLATE JS -->
        <!-- END CORE TEMPLATE JS -->
        <script type="text/javascript">
            $(document).ready(function () {
                $('#login-form').validate({
                    focusInvalid: false,
                    ignore: "",
                    rules: {
                        txtUsername: {
                            minlength: 2,
                            required: true
                        },
                        txtPassword: {
                            required: true,
                        }
                    },
                    invalidHandler: function (event, validator) {
                        //display error alert on form submit    
                    },
                    errorPlacement: function (label, element) { // render error placement for each input type   
                        $('<span class="error"></span>').insertAfter(element).append(label)
                        var parent = $(element).parent('.input-with-icon');
                        parent.removeClass('success-control').addClass('error-control');
                    },
                    highlight: function (element) { // hightlight error inputs

                    },
                    unhighlight: function (element) { // revert the change done by hightlight

                    },
                    success: function (label, element) {
                        var parent = $(element).parent('.input-with-icon');
                        parent.removeClass('error-control').addClass('success-control');
                    },
                    submitHandler: function () {
                        $("#myModal").modal('show');

                        var url = "controles/encargado/login.jsp";
                        $.ajax({
                            type: "POST",
                            url: url,
                            data: $("#login-form").serialize(),
                            success: function (data)
                            {
                                $('#myModal').modal('hide');
                                if (data > 0)
                                {
                                    window.location = 'intranet.jsp';

                                } else if (data == 0)
                                {
                                    sendMessage("Error de Credenciales");

                                } else if (data == -1)
                                {
                                    sendMessage("problemas con el servidor intentelo mas tarde");
                                }
                            }
                        });
                    }
                });
            });
            function sendMessage(sms)
            {
                $.gritter.add({
                    // (string | mandatory) the heading of the notification
                    title: 'Mensaje',
                    // (string | mandatory) the text inside the notification
                    text: sms
                });
            };
        </script>
    </body>
</html>
<%} else response.sendRedirect("intranet.jsp");%>   