<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
    <meta charset="utf-8" />
    <title>Refugiate Web - Administrativa</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="Refugiate Web" name="desceription" />
    <meta content="Marvin de la Cruz Razon" name="author" />
    <!-- BEGIN PLUGIN CSS -->
    <link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/bootstrap-select2/select2.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/bootstrap-datepicker/css/datepicker.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/bootstrap-timepicker/css/bootstrap-timepicker.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/boostrap-checkbox/css/bootstrap-checkbox.css" rel="stylesheet" type="text/css" media="screen" />
    <link rel="stylesheet" href="assets/plugins/ios-switch/ios7-switch.css" type="text/css" media="screen" charset="utf-8" />
    <link href="assets/plugins/jquery-slider/css/jquery.sidr.light.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/datatables-responsive/css/datatables.responsive.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/jquery-datatable/css/jquery.dataTables.css" rel="stylesheet" type="text/css" />
    <!-- END PLUGIN CSS -->
    <!-- BEGIN CORE CSS FRAMEWORK -->
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/animate.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
    <!-- END CORE CSS FRAMEWORK -->
    <!-- BEGIN CSS TEMPLATE -->
    <link href="assets/css/style.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/custom-icon-set.css" rel="stylesheet" type="text/css" />
    <!-- END CSS TEMPLATE -->
</head>
<!-- BEGIN BODY -->
<body class="">
<!-- BEGIN HEADER -->
  
    <!-- BEGIN HEADER -->
    <div class="header navbar navbar-inverse ">
        <!-- BEGIN TOP NAVIGATION BAR -->
        <div class="navbar-inner">
            <div class="header-seperation">
                <ul class="nav pull-left notifcation-center" id="main-menu-toggle-wrapper" style="display:none">
                    <li class="dropdown"> 
                        <a id="main-menu-toggle" href="#main-menu" class="">
                            <div class="iconset top-menu-toggle-white"></div>
                        </a> 
                    </li>
                </ul>
                <!-- BEGIN LOGO -->
                <a href="intranet.jsp"><img src="assets/img/logo.png" class="logo" data-src="assets/img/logo.png" data-src-retina="assets/img/logo2x.png" width="106" height="92" /></a>
                <!-- END LOGO -->
                <ul class="nav pull-right notifcation-center">
                    <li class="dropdown" id="header_task_bar"> 
                        <a href="intranet.jsp" class="dropdown-toggle active" data-toggle="">
                            <div class="iconset top-home"></div>
                        </a> 
                    </li>
                    <li class="dropdown" id="portrait-chat-toggler" style="display:none"> 
                        <a href="#sidr" class="chat-menu-toggle">
                            <div class="iconset top-chat-white "></div>
                        </a> 
                    </li>
                </ul>
            </div>
            <!-- END RESPONSIVE MENU TOGGLER -->
   
            <div class="header-quick-nav">
               <!-- BEGIN TOP NAVIGATION MENU -->
               <div class="pull-left">
                   <ul class="nav quick-section">
                       <li class="quicklinks"> 
                           <a href="#" class="" id="layout-condensed-toggle">
                               <div class="iconset top-menu-toggle-dark"></div>
                           </a> 
                       </li>
                   </ul>       
                </div>
                <div id="header"></div><!-- aca la cabecera -->
            </div>   
            <!-- END TOP NAVIGATION MENU -->
        </div>
        <!-- END TOP NAVIGATION BAR -->
    </div>
    <!-- END HEADER -->

    <!-- BEGIN CONTAINER -->
    <div class="page-container row-fluid">

        <div id="sidebar" ></div><!-- aca va salir el sidebar -->
  
        <div id="container" class="page-content">
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
            <div id="portlet-config" class="modal hide">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"></button>
                    <h3>Widget Settings</h3>
                </div>
                <div class="modal-body"> Widget settings form goes here </div>
            </div>
            <div class="clearfix"></div>
            <div class="content">
                <ul class="breadcrumb">
                    <li><p>TU ESTAS EN</p></li>
                    <i class="icon-angle-right"></i>
                    <li><a href="#" class="active">GESTION DE TIPO DE SERVICIOS</a> </li>
                </ul>
                <div class="page-title"> <i class="icon-custom-left"></i>
                    <h3>Configuraciín - <span class="semi-bold">Tipo de Servicio</span></h3>
                </div>

                <div class="row-fluid">
                    <div class="span4">
                        <div class="grid simple">
                            <div class="grid-title no-border">
                                <h4>Traditional <span class="semi-bold">Validation</span></h4>
                                <div class="tools"> <a href="javascript:;" class="collapse"></a> </div>
                            </div>
                            <div class="grid-body no-border"> <br />
                                <form id="forml_validation" action="#">
                                    <div class="row-fluid">
                                        <div class="span12">
                                            <div class="control-group">
                                                <label class="control-label">Nombre: </label>
                                                <span class="help">Digite nombre de servicio.</span>
                                                <div class="input-with-icon  right">                                       
                                                    <i class=""></i>
                                                    <input type="text" name="txtNombre" id="txtNombre" class="span12" placeholder="ingrese nombre"  />                                 
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Estado:</label>
                                                <span class="help">seleccione un estado</span>
                                                <div class="input-with-icon  right">                                       
                                                    <i class=""></i>
                                                    <div class="radio radio-success">
                                                        <input id="yes" type="radio" name="rEstado" value="1" checked="checked" />
                                                        <label for="yes">Activo</label>
                                                        <input id="no" type="radio" name="rEstado" value="0" />
                                                        <label for="no">Inactivo</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-actions">  
					<div class="pull-right">
                                            <input type="hidden" id="Id"  name="Id" value="" />
                                            <button type="submit" class="btn btn-success btn-cons"><i class="icon-ok"></i> Aceptar</button>
                                            <button type="button" onclick="getLimpiar()" class="btn btn-white btn-cons">Cancelar</button>
					</div>
                                    </div>
				</form>
                            </div>
                        </div>
                    </div>		
                    <div class="span8">
                        <div class="grid simple">
                            <div class="grid-title no-border">
                                <h4>Icon <span class="semi-bold">Validation</span></h4>
                                <div class="tools"> <a href="javascript:;" class="collapse"></a> </div>
                            </div>                  
                            <div class="grid-body ">
                                <div id="tabla"></div><!-- aca se va mostrar la tabla -->
                            </div>
                        </div>
                    </div>
                </div>	 
            </div>
        </div>
    </div>
    <!-- END PAGE -->

    <!-- END CONTAINER -->
    <!-- BEGIN CORE JS FRAMEWORK-->
    <script src="assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="assets/plugins/breakpoints.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
    <!-- END CORE JS FRAMEWORK -->
    <!-- BEGIN PAGE LEVEL JS -->
    <script src="assets/plugins/jquery-slider/jquery.sidr.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-block-ui/jqueryblockui.js" type="text/javascript"></script> 
    <script src="assets/plugins/jquery-numberAnimate/jquery.animateNumbers.js" type="text/javascript"></script>
    <script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>
    <script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
    <script src="assets/plugins/bootstrap-select2/select2.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-datatable/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-datatable/extra/js/TableTools.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="assets/plugins/datatables-responsive/js/datatables.responsive.js"></script>
    <script type="text/javascript" src="assets/plugins/datatables-responsive/js/lodash.min.js"></script>
    <!-- END PAGE LEVEL PLUGINS -->

    <script src="assets/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="assets/js/core.js" type="text/javascript"></script>
    <script src="assets/js/demo.js" type="text/javascript"></script>
    <!-- END CORE TEMPLATE JS -->
    <!-- END JAVASCRIPTS -->
 
<script type="text/javascript">
function getLimpiar()
{   
   sendMessage("Se Limpio correctamente");
      $('#forml_validation')[0].reset();
       $('#Id').val("");
};
function getHeader()
{
     $.ajax({
            url: 'controles/header.jsp',
            type: 'POST',
            success: function (data) {     
                     $('#header').html(data);
            },
            contentType: false,
            processData: false
        });
};
getHeader();
 function getSidebar()
{
     $.ajax({
            url: 'controles/sidebar.jsp',
            type: 'POST',
            success: function (data) {     
                     $('#sidebar').html(data);
            },
            contentType: false,
            processData: false
        });
};
getSidebar();
 function getTabla()
{
     $('#tabla').html('<center><h4><img width="60" height="60" src="assets/img/cargando.gif" alt=""/>Espere <span class="semi-bold">...</span></h4></center>');
     $.ajax({
            url: 'controles/servicio/tabla.jsp',
            type: 'POST',
            success: function (data) {     
                     $('#tabla').html(data);
            },
            contentType: false,
            processData: false
        });
};
getTabla();
      $(document).ready(function() {			
 
	//Traditional form validation sample
	$('#forml_validation').validate({
                focusInvalid: false, 
                ignore: "",
                rules: {
                    txtNombre: {
                        minlength: 2,
                        required: true
                    }
                },
                 messages: 
                         {
                    txtNombre: "Ingrese Tipo de Habitación"
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
                
                submitHandler: function() {   
                    $("#myModal").modal('show');                                   
                   
                       var url = "controles/servicio/insert.jsp"; 
                       $.ajax({
                            type: "POST",
                            url: url,
                            data: $("#forml_validation").serialize(), 
                            success: function(data)
                            {
                              $('#myModal').modal('hide');
                              if(data>0)
                              {
                                  sendMessage("Se Grabo Correctamente.");
                                   getTabla();    
                                   $('#forml_validation')[0].reset();
                                    $('#Id').val("");
                              }else if(data==0)
                              {
                                    sendMessage("Se actulizo correctamente.");
                                    getTabla();
                                     $('#forml_validation')[0].reset();
                                      $('#Id').val("");
                              }else if(data==-1)
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
function edit_form(id,nombre,estado) {
    $('#Id').val(id);
    $('#txtNombre').val(nombre);

    if(estado==1)
        $('input:radio[name=rEstado]')[0].checked = true;
    else
        $('input:radio[name=rEstado]')[1].checked = true;
};  	 
</script>
</body>

