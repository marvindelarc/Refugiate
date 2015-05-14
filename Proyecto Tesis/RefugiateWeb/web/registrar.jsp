<%-- 
    Document   : index
    Created on : 30-mar-2015, 19:45:41
    Author     : EdHam
--%>

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
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="error-body no-top">
<div class="error-wrapper">

	
      <div class="row-fluid">
        <div class="span12">
          <div class="grid simple">
            <div class="grid-title no-border">
              <h4>Condensed <span class="semi-bold">Layout</span></h4>
            </div>
            <div class="grid-body no-border">
            <form class="form-no-horizontal-spacing" id="form-condensed" />	
              <div class="row-fluid column-seperation">
                <div class="span3">
                  <h4>Datos de Empresas</h4>            
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtNombreEmpresa" id="txtNombreEmpresa" type="text" class="span12" placeholder="Nombre de Empresas" />
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                        <input name="txtNombreCEmpresa" id="txtNombreCEmpresa" type="text" class="span12" placeholder="Nombre Comercial" />
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                          <textarea name="SloganEmpresa" id="SloganEmpresa" placeholder="Slogan ..." class="span12" rows="2"></textarea>
                      </div>                     
                    </div>
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtRucEmpresa" id="txtRucEmpresa" type="text" class="span12" placeholder="RUC Empresa" />
                      </div>                     
                    </div>
                   
                  
                    <h4>Datos de Persona</h4>            
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtNombrePersona" id="txtNombrePersona" type="text" class="span12" placeholder="Nombres de Persona" />
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                        <input name="txtApellidoPersona" id="txtApellidoPersona" type="text" class="span12" placeholder="Apellidos de Persona" />
                      </div>                     
                    </div>
            
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtEmailPersoma" id="txtEmailPersoma" type="text" class="span12" placeholder="E-mail Persona" />
                      </div>                     
                    </div>
                  
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtCelularPersona" id="txtCelularPersona" type="text" class="span12" placeholder="Celular Persona" />
                      </div>                     
                    </div>
                   
                </div>
                    
                  
                  
                  
                  <div class="span3">
                  <h4>Datos de Sucursal</h4>            
                    <div class="row-fluid">
                      <div class="span11">
                          <select id="cbDepartamento" name="cbDepartamento" class="span12" onchange="getProvincia(this.value)" title="Por favor selecione un departamento!" required>
                            <option value="">espere un momento...</option>                                                       
                        </select>
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                         <select id="cbProvincia" name="cbProvincia"  class="span12" onchange="getDistrito(this.value)" title="Por favor selecione una provincia!" required>
                            <option value="">Selecione una opcción</option>
                        </select>
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                          <select id="cbDistrito" name="cbDistrito" class="span12" onchange="getMapa()" title="Por favor selecione un distrito!" required>
                            <option value="">Selecione una opcción</option>
                        </select>
                      </div>                     
                    </div>
                   <div class="row-fluid">
                      <div class="span11">
                          <textarea name="txtDireccionSucrusla" id="txtDireccionSucrusla" placeholder="Direccion Sucursal ..." class="span12" rows="2"></textarea>
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                        <input name="txtHorarioSucursal" id="txtHorarioSucursal" type="text" class="span12" placeholder="Horaario Sucursal" />
                      </div>                     
                    </div>
                  
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtTelefonoSucursal" id="txtTelefonoSucursal" type="text" class="span12" placeholder="Telefono Sucursal" />
                      </div>                     
                    </div>
                  
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtPisosSucursal" id="txtPisosSucursal" type="text" class="span12" placeholder="Número Pisos Sucursal" />
                      </div>                     
                    </div>
                    
                  <div class="row-fluid">
                      <div class="span11">
                        <input name="txtLatiud" id="txtLatiud" type="text" class="span12" placeholder="Latitud" readonly="readonly" />
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                        <input name="txtLongitud" id="txtLongitud" type="text" class="span12" placeholder="Longitud" readonly="readonly"  />
                      </div>                     
                    </div>
                </div>
                  
                  
                  
                  <div class="span3">
                  <h4>Basic Information</h4>       
                    <div id="g_map" style=" min-height:380px;" class="span10"  ></div>
                   
                 
                  
                  
                  
                </div>
                  
                  
                  
                   <div class="span3">
                  <h4>Datos de Empresas</h4>            
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtNombreEmpresa" id="txtNombreEmpresa" type="text" class="span12" placeholder="Nombre de Empresas" />
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                        <input name="txtNombreCEmpresa" id="txtNombreCEmpresa" type="text" class="span12" placeholder="Nombre Comercial" />
                      </div>                     
                    </div>
                  <div class="row-fluid">
                      <div class="span11">
                          <textarea name="SloganEmpresa" id="SloganEmpresa" placeholder="Slogan ..." class="span12" rows="2"></textarea>
                      </div>                     
                    </div>
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="txtRucEmpresa" id="txtRucEmpresa" type="text" class="span12" placeholder="RUC Empresa" />
                      </div>                     
                    </div>
                    <div class="input-prepend">     
                        <div class="span11">
                        <div id="foto"></div>    
                        <input class="btn btn-primary btn-xs btn-mini" type="file" name="archivo" id="archivo" />
                        <br>
                        <a id="Remover" data-dismiss="fileupload" class="btn btn-primary btn-xs btn-mini" href="#">Remover</a>
                        
                        </div>
                    </div>
                    <div class="input-prepend">
                        <input type="text" name="txtFoto" id="txtFoto"/> 
                    </div>
                  
                  
                  
                  
                    <div class="row-fluid">
                      <div class="span8">
                        <div class="radio">
                          <input id="male" type="radio" name="gender" value="male" checked="checked" />
                          <label for="male">Male</label>
                          <input id="female" type="radio" name="gender" value="female" />
                          <label for="female">Female</label>
                        </div>
                      </div>
                    </div>
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="form3Email" id="form3Email" type="text" class="span12" placeholder="email@address.com" />
                      </div>
                    </div>
                </div>
                  
                  
                  
                  
                  
                  
              </div>
				<div class="form-actions">
					<div class="pull-left">
					  <div class="checkbox checkbox check-success 	">
						<input type="checkbox" value="1" id="checkbox1" />
						<label for="checkbox1">I Here by agree on the Term and condition. </label>
					  </div>
					</div>
					<div class="pull-right">
					  <button class="btn btn-danger btn-cons" type="submit"><i class="icon-ok"></i> Save</button>
					  <button class="btn btn-white btn-cons" type="button">Cancel</button>
					</div>
				  </div>
			</form>
            </div>
          </div>
        </div>
      </div>
      

	  <div id="push"></div>
</div>
 <div id="footer">
      <div class="span12 error-container">
          <br><br><br><br><br>
          
		<div class="copyright">
			All work copyright of respective owner, 2013 webarch Incorporated
		</div>
		
    </div>
</div>
<!-- END CONTAINER --> 

<!-- BEGIN CORE JS FRAMEWORK--> 
<script src="assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script> 
<script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script> 
<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>  
<script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script src="assets/plugins/jquery-gmap/gmap3.min.js" type="text/javascript"></script> 	

<script src="assets/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS --> 	
<!-- PAGE JS -->
<script src="assets/js/google_maps.js" type="text/javascript"></script> 
<!-- BEGIN CORE TEMPLATE JS --> 
<script type="text/javascript">
function comboDepartamento()
{
     $.ajax({
        url: 'controles/ubigeo/combo_departamento.jsp',
        type: 'POST',
        success: function (data) {     
                 $('#cbDepartamento').html(data);
        },
        contentType: false,
        processData: false
    });          
 };
 function getUbigeo(departamento,provincia,distrito){
                $("select#cbDepartamento").val(departamento);
                 
                $('#cbProvincia option[value=]').text('espere un momento...');               
                var url = "controles/ubigeo/combo_provincia.jsp?id="+departamento; 

                                    $.ajax({
                                           type: "POST",
                                           url: url,
                                           success: function(data)
                                           {
                                               $("#cbProvincia").html(data);
                                               $("select#cbProvincia").val(provincia);
                                               url = "controles/ubigeo/combo_distrito.jsp?id="+provincia; 

                                                $.ajax({
                                                       type: "POST",
                                                       url: url,
                                                       success: function(data)
                                                       {
                                                            $("#cbDistrito").html(data);
                                                            $("select#cbDistrito").val(distrito);

                                                       }
                                                     });    
                                           }
                                         });    
                  
  }
  function getProvincia(id){
     
                if(id!="")
                {
                 $('#cbProvincia option[value=]').text('espere un momento...');
                 $("#cbDistrito").val(0);
                var url = "controles/ubigeo/combo_provincia.jsp?id="+id; 

                                    $.ajax({
                                           type: "POST",
                                           url: url,
                                           success: function(data)
                                           {
                                                $("#cbProvincia").html(data);
                                                $("#cbProvincia").change();
                                           }
                                         });    
                  }
                   else
                  {
                      $("#cbProvincia").val(0);
                  }
            }
  function getDistrito(id){
                
                if(id!="")
                {
                $('#cbDistrito option[value=]').text('espere un momento...');
                var url = "controles/ubigeo/combo_distrito.jsp?id="+id; 

                                    $.ajax({
                                           type: "POST",
                                           url: url,
                                           success: function(data)
                                           {
                                                $("#cbDistrito").html(data);
                                                
                                           }
                                         });    
                  }
                  else
                  {
                      $("#cbDistrito").val(0);
                  }
            }
            
    function getMapa(){
        
          gebo_maps.search_location('Perú '+$( "#cbDepartamento option:selected" ).text()+
                  " "+$( "#cbProvincia option:selected" ).text()+" "+$( "#cbDistrito option:selected" ).text());
    };
  comboDepartamento();
   
                                          
      $(document).ready(function() {			
 
	//Form Condensed Validation
	$('#form-condensed').validate({
                errorElement: 'span', 
                errorClass: 'error', 
                focusInvalid: false, 
                ignore: "",
                rules: {
                    form3FirstName: {
						name: true,
                        minlength: 3,
                        required: true
                    },
					form3LastName: {
                        minlength: 3,
                        required: true
                    },
                    form3Gender: {
                        required: true,
                    },
					form3DateOfBirth: {
                        required: true,
                    },
					form3Occupation: {
						 minlength: 3,
                        required: true,
                    },
					form3Email: {
                        required: true,
						email: true
                    },
                    form3Address: {
						minlength: 10,
                        required: true,
                    },
					form3City: {
						minlength: 5,
                        required: true,
                    },
					form3State: {
						minlength: 3,
                        required: true,
                    },
					form3Country: {
						minlength: 3,
                        required: true,
                    },
					form3PostalCode: {
						number: true,
						maxlength: 4,
                        required: true,
                    },
					form3TeleCode: {
						minlength: 3,
						maxlength: 4,
                        required: true,
                    },
					form3TeleNo: {
						maxlength: 10,
                        required: true,
                    },
                },

                invalidHandler: function (event, validator) {
					//display error alert on form submit    
                },

                errorPlacement: function (label, element) { // render error placement for each input type   
					$('<span class="error"></span>').insertAfter(element).append(label)
                },

                highlight: function (element) { // hightlight error inputs
					
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    
                },

                success: function (label, element) {
                  
                },

                submitHandler: function (form) {
                
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
<!-- END CORE TEMPLATE JS --> 
</body>
