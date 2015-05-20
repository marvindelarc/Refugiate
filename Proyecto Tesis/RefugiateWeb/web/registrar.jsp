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
              <h3>Inscripcion de Empresa a <span class="semi-bold">Refugiate</span></h3>
            </div>
            <div class="grid-body no-border">
            <form class="form-no-horizontal-spacing" id="form-condensed" >	
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
                          <textarea name="txtSloganEmpresa" id="txtSloganEmpresa" placeholder="Slogan ..." class="span12" rows="2"></textarea>
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
                          <select id="cbNivel" name="cbNivel" class="span12" title="Por favor selecione un nivel!" required>
                            <option value="">Selecione un Nivel</option>
                            <option value="1">Una Estrella</option>
                            <option value="2">Dos Estrellas</option>
                            <option value="3">Tres Estrellas</option>
                            <option value="4">Cuatro Estrellas</option>
                            <option value="5">Cinco Estrellas</option>
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
                    <h4>Marcar Ubicacion Geografica</h4>       
                    <div id="g_map" style=" min-height:420px;" class="span10"  ></div>                  
                </div>
                  
                <div class="span3">
                    <h4>Datos de Ingreso:</h4>                               
                    <div class="row-fluid">
                        <div class="span11">
                            <input name="txtUsuario" id="txtUsuario" type="text" class="span12" placeholder="Ingrese Usuario" />
                        </div>                     
                    </div>
                    <div class="row-fluid">
                        <div class="span11">
                            <input name="txtContrasena" id="txtContrasena" type="password" class="span12" placeholder="Ingrese Contraseña" />              
                        </div>                     
                    </div>
                  
                    <div class="row-fluid">
                        <div class="span11">
                            <input name="txtRContrasena" id="txtRContrasena" type="password" class="span12" placeholder="Repita Contraseña" />
                        </div>                     
                    </div>                  
                </div>
                
                <div class="span3">
                    <h4>Subir Logo</h4>                                                        
                    <div class="span11">
                        <div id="fotoLogo" class="fileupload-preview thumbnail" style="margin-bottom: -12px;"></div>    
                         <br/><a id="RemoverLogo" data-dismiss="fileupload" class="btn btn-inverse btn-xs btn-mini" href="#">Remover</a>
                         <input class="btn btn-primary btn-mini" type="file" name="archivoLogo" id="archivoLogo" style="margin-bottom: 3px;"/>                            
                    </div>                    
                    <div class="input-prepend row-fluid">
                        <input type="text" name="txtFotoLogo" id="txtFotoLogo"/> 
                    </div>
                    <h4  style="margin-top: -14px;">Subir Banner</h4>                                
                    <div class="span11">
                        <div id="fotoBanner" class="fileupload-preview thumbnail" style="margin-bottom: -12px;"></div>    
                        <br/><a id="RemoverBanner" data-dismiss="fileupload" class="btn btn-inverse btn-xs btn-mini" href="#">Remover</a>
                        <input class="btn btn-primary btn-xs btn-mini" type="file" name="archivoBanner" id="archivoBanner" style="margin-bottom: 3px;"/>                        
                    </div>                    
                    <div class="input-prepend row-fluid">
                        <input type="text" name="txtFotoBanner" id="txtFotoBanner"/> 
                    </div>
                </div>                  
            </div>
            <div class="form-actions">                
                <div class="pull-right">
                    <button class="btn btn-danger btn-cons" type="submit"><i class="icon-ok"></i> Save</button>
                    <button class="btn btn-white btn-cons" onclick="cancelar()" type="button">Cancel</button>
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
        <br><br><br>
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

<!-- PAGE JS -->
<script src="assets/js/google_maps.js" type="text/javascript"></script> 
<!-- BEGIN CORE TEMPLATE JS --> 
<script type="text/javascript">
function cancelar(){
 if (confirm('¿Estas seguro querer regresar?')){ 
      window.location='index.jsp';
    } 
};
     
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
                $('#form-condensed').validate({
                focusInvalid: false, 
                ignore: "",
                rules: {
                    txtNombreEmpresa: {
                        minlength: 2,
                        required: true
                    },
                    txtNombreCEmpresa: {
                        minlength: 2,
                        required: true
                    },
                    txtSloganEmpresa: {
                        minlength: 2,
                        required: true
                    },
                    txtRucEmpresa: {
                        digits: true,
                        minlength: 11,
                        maxlength: 11,
                        required: true
                    },
                    txtNombrePersona: {
                        minlength: 2,
                        required: true
                    },
                    txtApellidoPersona: {
                        minlength: 2,
                        required: true
                    },
                    txtEmailPersoma: {
                        minlength: 2,
                        email: true,
                        required: true
                    },
                    txtCelularPersona: {
                        digits: true,
                        minlength: 9,
                        maxlength: 9,
                        required: true
                    },
                    txtDireccionSucrusla: {
                        minlength: 2,
                        required: true
                    },
                    txtHorarioSucursal: {
                        minlength: 2,
                        required: true
                    },
                    txtTelefonoSucursal: {
                        digits: true,
                        minlength: 9,
                        maxlength: 9,
                        required: true
                    },
                    txtPisosSucursal: {
                        digits: true,
                        maxlength: 4,
                        required: true
                    },
                    txtLatiud: {
                        required: true
                    },
                    txtLongitud: {
                        required: true
                    },
                    txtFotoLogo: {
                        required: true
                    },
                    txtFotoBanner: {
                        required: true
                    },
                    txtContrasena: {
                        minlength: 6,
                        required: true
                    },
                    txtRContrasena: {
                        equalTo: "#txtContrasena",
                        required: true
                    }
                    ,
                    txtUsuario: {
                        minlength: 4,
                        required: true
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
                
                submitHandler: function() {   
                    $("#myModal").modal('show');                                   
                   
                       var url = "controles/encargado/registrar.jsp"; 
                       $.ajax({
                            type: "POST",
                            url: url,
                            data: $("#form-condensed").serialize(), 
                            success: function(data)
                            {
                              $('#myModal').modal('hide');
                              if(data>0)
                              {
                                  sendMessage("Se Grabo Correctamente.");
                                   getTabla();    
                                   $('#form-condensed')[0].reset();
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
<!-- END CORE TEMPLATE JS --> 
</body>
