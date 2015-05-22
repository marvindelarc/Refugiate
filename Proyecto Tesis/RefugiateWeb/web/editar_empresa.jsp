<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="Entidades.clsEncargado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
clsEncargado objEncargado=(clsEncargado) request.getSession().getAttribute("SessionEncargado");
if(objEncargado!=null)
{
    BASE64Encoder e = new BASE64Encoder();
%>
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
        <li class="dropdown"> <a id="main-menu-toggle" href="#main-menu" class="">
          <div class="iconset top-menu-toggle-white"></div>
          </a> </li>
      </ul>
      <!-- BEGIN LOGO -->
      <a href="intranet.jsp"><img src="assets/img/logo.png" class="logo" data-src="assets/img/logo.png" data-src-retina="assets/img/logo2x.png" width="106" height="92" /></a>
      <!-- END LOGO -->
      <ul class="nav pull-right notifcation-center">
        <li class="dropdown" id="header_task_bar"> <a href="intranet.jsp" class="dropdown-toggle active" data-toggle="">
          <div class="iconset top-home"></div>
          </a> </li>
        <li class="dropdown" id="portrait-chat-toggler" style="display:none"> <a href="#sidr" class="chat-menu-toggle">
          <div class="iconset top-chat-white "></div>
          </a> </li>
      </ul>
    </div>
    <!-- END RESPONSIVE MENU TOGGLER -->
   
 <div class="header-quick-nav">
      <!-- BEGIN TOP NAVIGATION MENU -->
      <div class="pull-left">
        <ul class="nav quick-section">
          <li class="quicklinks"> <a href="#" class="" id="layout-condensed-toggle">
            <div class="iconset top-menu-toggle-dark"></div>
            </a> </li>
        </ul>
       
      </div>
      <div id="header"></div><!-- aca la cabecera -->
    </div>   
    <!-- END TOP NAVIGATION MENU -->
  </div>
  <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->
<!-- END HEADER -->
<!-- BEGIN CONTAINER -->
<div class="page-container row-fluid">
  <!-- BEGIN SIDEBAR -->

  <!-- END SIDEBAR -->
  <!-- BEGIN PAGE CONTAINER-->
    
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
        <li>
          <p>TU ESTAS EN</p>
        </li>
        <i class="icon-angle-right"></i>
        <li><a href="#" class="active">GESTION DE EMPRESA</a> </li>
      </ul>
      <div class="page-title"> <i class="icon-custom-left"></i>
        <h3>Configuraciín - <span class="semi-bold">Empresa:</span></h3>
      </div>
	  
       <div class="row-fluid">
            <div class="span12">
              <div class="grid simple">
                <div class="grid-title no-border">
                  <h4>Traditional <span class="semi-bold">Validation</span></h4>
                  <div class="tools"> <a href="javascript:;" class="collapse"></a> </div>
                </div>
                <div class="grid-body no-border"> <br />
                    <form id="forml_validation" action="#" >
                        <div class="row-fluid">
                            <div class="span6">
                                <div class="control-group">
                                    <label class="control-label">Nombre Comercial: </label>
                                    <span class="help">de Empresa.</span>
                                    <div class="input-with-icon  right">                                       
                                        <i class=""></i>
                                        <input type="text" name="txtEmpresaNombreComercial" id="txtEmpresaNombreComercial" value="<%=objEncargado.getObjSucursal().getObjEmpresa().getNombre()%>" class="span12" placeholder="ingrese nombre comercial"  />                                 
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Nombre: </label>
                                    <span class="help">de Empresa.</span>
                                    <div class="input-with-icon  right">                                       
                                        <i class=""></i>
                                        <input type="text" name="txtEmpresaNombre" id="txtEmpresaNombre" value="<%=objEncargado.getObjSucursal().getObjEmpresa().getNombreComercial()%>" class="span12" placeholder="Ingrese nombre"  />                                 
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Slogan: </label>
                                    <span class="help">de Empresa.</span>
                                    <div class="input-with-icon  right">                                       
                                        <i class=""></i>
                                        <input type="text" name="txtSlogan" id="txtSlogan" value="<%=objEncargado.getObjSucursal().getObjEmpresa().getSlogan()%>" class="span12" placeholder="Ingrese nombre"  />                                 
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">R.U.C.: </label>
                                    <span class="help">de Empresa.</span>
                                    <div class="input-with-icon  right">                                       
                                        <i class=""></i>
                                        <input type="text" name="txtRuc" id="txtRuc" value="<%=objEncargado.getObjSucursal().getObjEmpresa().getRuc()%>" class="span12" placeholder="Ingrese R.U.C."  />                                 
                                    </div>
                                </div>
                                
                            </div>
                             <div class="span6">
                                 <div class="control-group">
                                    <label class="control-label">Logo: </label>
                                    <span class="help">de Empresa.</span>
                                    <div class="input-with-icon  right">           
                                        
                                        <div id="fotoLogo" class="fileupload-preview thumbnail" style="margin-bottom: -12px;">
                                            <img alt="" src="data:image/png;base64,<%=e.encodeBuffer(objEncargado.getObjSucursal().getObjEmpresa().getLogo())%>"  /> 
                                        </div>    
                                        <br/><a id="RemoverLogo" data-dismiss="fileupload" class="btn btn-inverse btn-xs btn-mini" href="#">Remover</a>
                                        <input class="btn btn-primary btn-mini" type="file" name="archivoLogo" id="archivoLogo" style="margin-bottom: 3px;"/>                            
                                        <input type="text" name="txtFotoLogo" id="txtFotoLogo" value="data:image/png;base64,<%=e.encodeBuffer(objEncargado.getObjSucursal().getObjEmpresa().getLogo())%>"/> 
                                    </div> 
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Banner: </label>
                                    <span class="help">de Empresa.</span>
                                    <div class="input-with-icon  right">                                       
                                        
                                        <div id="fotoBanner" class="fileupload-preview thumbnail" style="margin-bottom: -12px;">
                                            <img alt="" src="data:image/png;base64,<%=e.encodeBuffer(objEncargado.getObjSucursal().getObjEmpresa().getBanner())%>" /> 
                                        </div>    
                                        <br/><a id="RemoverBanner" data-dismiss="fileupload" class="btn btn-inverse btn-xs btn-mini" href="#">Remover</a>
                                        <input class="btn btn-primary btn-xs btn-mini" type="file" name="archivoBanner" id="archivoBanner" style="margin-bottom: 3px;"/>                        
                                        <input type="text" name="txtFotoBanner" value="data:image/png;base64,<%=e.encodeBuffer(objEncargado.getObjSucursal().getObjEmpresa().getBanner())%>" id="txtFotoBanner"/> 

                                    </div>
                                </div>                 
                            </div>
                        </div>
                        
                        <div class="form-actions">  
                            <div class="pull-right">
                                <input type="hidden" id="Id"  name="Id" value="" />
                                <button type="submit" class="btn btn-success btn-cons"><i class="icon-ok"></i> Aceptar</button>
                            </div>
                        </div>
                    </form>                                  
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


      $(document).ready(function() {			
 			
$( "#RemoverLogo" ).hide();
 $( "#txtFotoLogo" ).hide();
 
 $('#archivoLogo').change(function (e) {
    var input=e.target,fr=new FileReader(),
	tipos=/^image\/jpg|image\/jpeg|image\/png|image\/gif$/i;
	if(input.files.length===0)return;
	if(!tipos.test(input.files[0].type)){alert("Archivo selecionado es inválido");return;}
	fr.onload=function(evt){
		var im=evt.target.result;
		redimensionar(im,100,100,0);
	}
    fr.readAsDataURL(input.files[0]);
});
$( "#RemoverLogo" ).click(function() {
    $("#fotoLogo").html('<div id="fotoLogo"></div>');
    $('#txtFotoLogo').val("");
    $( "#Remover" ).hide();
     $("#archivoLogo").val("");
});


$( "#RemoverBanner" ).hide();
 $( "#txtFotoBanner" ).hide();
 
 $('#archivoBanner').change(function (e) {
    var input=e.target,fr=new FileReader(),
	tipos=/^image\/jpg|image\/jpeg|image\/png|image\/gif$/i;
	if(input.files.length===0)return;
	if(!tipos.test(input.files[0].type)){alert("Archivo selecionado es inválido");return;}
	fr.onload=function(evt){
		var im=evt.target.result;
		redimensionar(im,280,280,1);
	}
    fr.readAsDataURL(input.files[0]);
});
$( "#RemoverBanner" ).click(function() {
    $("#fotoBanner").html('<div id="fotoBanner"></div>');
    $('#txtFotoBanner').val("");
    $( "#RemoverBanner" ).hide();
     $("#archivoBanner").val("");
});

function redimensionar(im,maxWidth,maxHeight,img){
	var i=new Image();
	i.onload=function(){
		var w=this.width,
		h=this.height,
		scale=Math.min(maxWidth/w,maxHeight/h),
		canvas=document.createElement('canvas'),
		ctx=canvas.getContext('2d');
		canvas.width=w*scale;
		canvas.height=h*scale;
		ctx.drawImage(i,0,0,w*scale,h*scale);
                if(img==0)
                {
                    $("#fotoLogo").html('<img class="fileupload-preview thumbnail" src="'+canvas.toDataURL()+'">');
                    $('#txtFotoLogo').val(canvas.toDataURL());
                    $( "#RemoverLogo" ).show()();
                }
                else
                {
                    $("#fotoBanner").html('<img class="fileupload-preview thumbnail" src="'+canvas.toDataURL()+'">');
                    $('#txtFotoBanner').val(canvas.toDataURL());
                    $( "#RemoverBanner" ).show()();
                }
		
	}
	i.src=im;
}  
	//Traditional form validation sample
	$('#forml_validation').validate({
                focusInvalid: false, 
                ignore: "",
                rules: {
                    txtEmpresaNombreComercial: {
                        minlength: 3,
                        required: true
                    },
                      txtEmpresaNombre: {
                        minlength: 3,
                        required: true
                    },txtSlogan: {
                        minlength: 3,
                        required: true
                    },txtRuc:{
                        digits: true,
                        minlength: 11,
                        maxlength: 11,
                        required: true
                    },
                     txtFotoLogo: {
                        required: true
                    },
                    txtFotoBanner: {
                        required: true
                    }
                },
                 messages: 
                         {
                    txtEmpresaNombreComercial: "Ingrese Nombre Comercial de la Empresa",
                    txtEmpresaNombre: "Ingrese Nombre de la Empresa",
                    txtSlogan: "Ingrese Slogan",
                    txtRuc: "Ingrese R.U.C. de la Empresa",
                    txtPuntos: "Ingresar Puntos"
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
                   
                       var url = "controles/empresa/insert.jsp"; 
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
	 
</script>
</body>

<%}else  
    response.sendRedirect("index.jsp");%>   

