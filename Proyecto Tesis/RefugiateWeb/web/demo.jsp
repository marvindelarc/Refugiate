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
<link href="assets/plugins/bootstrap-select2/select2.css" rel="stylesheet" type="text/css" media="screen" />
<link href="assets/plugins/bootstrap-datepicker/css/datepicker.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap-timepicker/css/bootstrap-timepicker.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/boostrap-checkbox/css/bootstrap-checkbox.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="assets/plugins/ios-switch/ios7-switch.css" type="text/css" media="screen" charset="utf-8" />
<link href="assets/plugins/jquery-slider/css/jquery.sidr.light.css" rel="stylesheet" type="text/css" media="screen" />
<!-- END PLUGIN CSS -->
<!-- BEGIN CORE CSS FRAMEWORK -->
<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" />
<link href="assets/css/animate.min.css" rel="stylesheet" type="text/css" />
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
      <a href="index.html"><img src="assets/img/logo.png" class="logo" data-src="assets/img/logo.png" data-src-retina="assets/img/logo2x.png" width="106" height="92" /></a>
      <!-- END LOGO -->
      <ul class="nav pull-right notifcation-center">
        <li class="dropdown" id="header_task_bar"> <a href="index.html" class="dropdown-toggle active" data-toggle="">
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
      <div id="header"></div>
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
    
  <div id="sidebar" ></div>
  
  
  
  
  
  
  
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
          <p>YOU ARE HERE</p>
        </li>
        <i class="icon-angle-right"></i>
        <li><a href="#" class="active">Form layouts & Validations</a> </li>
      </ul>
      <div class="page-title"> <i class="icon-custom-left"></i>
        <h3>Form - <span class="semi-bold">Validations</span></h3>
      </div>
	  
       <div class="row-fluid">
            <div class="span6">
              <div class="grid simple">
                <div class="grid-title no-border">
                  <h4>Traditional <span class="semi-bold">Validation</span></h4>
                  <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                </div>
                <div class="grid-body no-border"> <br />
				<form id="form_traditional_validation" action="#" />
                  <div class="row-fluid">
                    <div class="span12">
                      <div class="control-group">
                        <label class="control-label">Amount</label>
                        <span class="help">e.g. "5000"</span>
						<div class="input-with-icon  right">                                       
							<i class=""></i>
							<input type="text" name="form1Amount" id="form1Amount" class="span12" />                                 
						</div>
                      </div>
                      <div class="control-group">
                        <label class="control-label">Card Holder's Name</label>
                        <span class="help">e.g. "Jane Smith"</span>
						<div class="input-with-icon  right">                                       
							<i class=""></i>
							<input type="text" name="form1CardHolderName" id="form1CardHolderName" class="span12" />                                 
						</div>
                      </div>
                      <div class="control-group">
                        <label class="control-label">Card Number</label>
                        <span class="help">e.g. "5689569985"</span>
						<div class="input-with-icon  right">                                       
							<i class=""></i>
							<input type="text" name="form1CardNumber" id="form1CardNumber" class="span12" />                                 
						</div>
                      </div>
                    </div>
                  </div>
				  <div class="form-actions">  
					<div class="pull-right">
					  <button type="submit" class="btn btn-success btn-cons"><i class="icon-ok"></i> Save</button>
					  <button type="button" class="btn btn-white btn-cons">Cancel</button>
					</div>
					</div>
				</form>
                </div>
              </div>
            </div>		
            <div class="span6">
              <div class="grid simple">
                <div class="grid-title no-border">
                  <h4>Icon <span class="semi-bold">Validation</span></h4>
                  <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                </div>
                <div class="grid-body no-border"> <br />
				<form id="form_iconic_validation" action="#" />
                  <div class="row-fluid">
                    <div class="span12">
                      <div class="control-group">
                        <label class="control-label">Your Name</label>
                        <span class="help">e.g. "Jonh Smith"</span>
						<div class="input-with-icon  right">                                       
							<i class=""></i>
							<input type="text" name="form1Name" id="form1Name" class="span12" />                                 
						</div>
                      </div>
                      <div class="control-group">
                        <label class="control-label">Your email</label>
                        <span class="help">e.g. "john@examp.com"</span>
						<div class="input-with-icon  right">                                       
							<i class=""></i>
							<input type="text" name="form1Email" id="form1Email" class="span12" />                                 
						</div>
                      </div>
                      <div class="control-group">
                        <label class="control-label">Website</label>
                        <span class="help">e.g. "http://www.webarc.com"</span>
						<div class="input-with-icon  right">                                       
							<i class=""></i>
							<input type="text" name="form1Url" id="form1Url" class="span12" />                                 
						</div>
                      </div>
                    </div>
                  </div>
				  <div class="form-actions">  
					<div class="pull-right">
					  <button type="submit" class="btn btn-danger btn-cons"><i class="icon-ok"></i> Save</button>
					  <button type="button" class="btn btn-white btn-cons">Cancel</button>
					</div>
					</div>
				</form>
                </div>
              </div>
            </div>
          </div>	  
      <div class="row-fluid">
        <div class="span12">
          <div class="grid simple">
            <div class="grid-title no-border">
              <h4>Condensed <span class="semi-bold">Layout</span></h4>
              <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
            </div>
            <div class="grid-body no-border">
			<form class="form-no-horizontal-spacing" id="form-condensed" />	
              <div class="row-fluid column-seperation">
                <div class="span6">
                  <h4>Basic Information</h4>            
                    <div class="row-fluid">
                      <div class="span5">
                        <input name="form3FirstName" id="form3FirstName" type="text" class="span12" placeholder="First Name" />
                      </div>
                      <div class="span6">
                        <input name="form3LastName" id="form3LastName" type="text" class="span12" placeholder="Last Name" />
                      </div>
                    </div>
                    <div class="row-fluid">
                      <div class="span5">
                        <select name="form3Gender" id="form3Gender" class="select2 span12">
                          <option value="1" />Male
                          <option value="2" />Female
                        </select>
                      </div>
                      <div class="span6">
                        <input name="form3DateOfBirth" id="form3DateOfBirth" type="text" class="span12" placeholder="Date of Birth" />
                      </div>
                    </div>
                    <div class="row-fluid">
                      <div class="span11">
                        <input name="form3Occupation" id="form3Occupation" type="text" class="span12" placeholder="Occupation" />
                      </div>
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
                <div class="span6">
				
                  <h4>Postal Information</h4>
                  
                    <div class="row-fluid">
                      <div class="span12">
                        <input name="form3Address" id="form3Address" type="text" class="span12" placeholder="Address" />
                      </div>
                    </div>
                    <div class="row-fluid">
                      <div class="span6">
                        <input name="form3City" id="form3City" type="text" class="span12" placeholder="City" />
                      </div>
                      <div class="span6">
                        <input name="form3State" id="form3State" type="text" class="span12" placeholder="State" />
                      </div>
                    </div>
                    <div class="row-fluid">
                      <div class="span8">
                        <input name="form3Country" id="form3Country" type="text" class="span12" placeholder="Country" />
                      </div>
                      <div class="span4">
                        <input name="form3PostalCode" id="form3PostalCode" type="text" class="span12" placeholder="Postal Code" />
                      </div>
                    </div>
                    <div class="row-fluid">
                      <div class="span4">
                        <input name="form3TeleCode" id="form3TeleCode" type="text" class="span12" placeholder="+94" />
                      </div>
                      <div class="span8">
                        <input name="form3TeleNo" id="form3TeleNo" type="text" class="span12" placeholder="Phone Number" />
                      </div>
                    </div>
                    <div class="row-fluid small-text"> NOTE - Facts to be considered, Simply remove or edit this as for what you desire. Disabled font Color and size</div>
             
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
      <div class="row-fluid">
        <div class="span8">
          <div class="grid simple transparent">
            <div class="grid-title">
              <h4>Form <span class="semi-bold">Wizard</span></h4>
              <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
            </div>
            <div class="grid-body ">
              <div class="row-fluid">
                <form id="commentForm" />
                  <div id="rootwizard" class="span12">
                    <div class="form-wizard-steps">
                      <ul class="wizard-steps">
                        <li class="" data-target="#step1"> <a href="#tab1" data-toggle="tab"> <span class="step">1</span> <span class="title">Basic information</span> </a> </li>
                        <li data-target="#step2" class=""> <a href="#tab2" data-toggle="tab"> <span class="step">2</span> <span class="title">Account information</span> </a> </li>
                        <li data-target="#step3" class=""> <a href="#tab3" data-toggle="tab"> <span class="step">3</span> <span class="title">User settings</span> </a> </li>
                        <li data-target="#step4" class=""> <a href="#tab4" data-toggle="tab"> <span class="step">4</span> <span class="title">Feedback <br />
                          </span> </a> </li>
                      </ul>
                      <div class="clearfix"></div>
                    </div>
                    <div class="tab-content transparent">
                      <div class="tab-pane" id="tab1"> <br />
                        <h4 class="semi-bold">Step 1 - <span class="light">Basic Information</span></h4>
                        <br />
                        <div class="row-fluid">
                          <div class="span12">
                            <input type="text" placeholder="Full Name" class="span12 no-boarder " name="txtFullName" id="txtFullName" />
                          </div>
                        </div>
                        <div class="row-fluid">
                          <div class="span6">
                            <input type="text" placeholder="First Name" class="span12 no-boarder " name="txtFirstName" id="txtFirstName" />
                          </div>
                          <div class="span6">
                            <input type="text" placeholder="Last Name" class="span12 no-boarder " name="txtLastName" id="txtLastName" />
                          </div>
                        </div>
                      </div>
                      <div class="tab-pane" id="tab2"> <br />
                        <h4 class="semi-bold">Step 2 - <span class="light">Account Information</span></h4>
                        <br />
                        <div class="row-fluid">
                          <div class="span8">
                            <input type="text" placeholder="Country" class="span12 no-boarder " name="txtCountry" id="txtCountry" />
                          </div>
                          <div class="span4">
                            <input type="text" placeholder="Postal Code" class="span12 no-boarder " name="txtPostalCode" id="txtPostalCode" />
                          </div>
                        </div>
                        <div class="row-fluid">
                          <div class="span4">
                            <input type="text" placeholder="+94" class="span12 no-boarder " name="txtPhoneCode" id="txtPhoneCode" />
                          </div>
                          <div class="span8">
                            <input type="text" placeholder="Phone Number" class="span12 no-boarder " name="txtPhoneNumber" id="txtPhoneNumber" />
                          </div>
                        </div>
                      </div>
                      <div class="tab-pane" id="tab3"> <br />
                        <h4 class="semi-bold">Step 3 - <span class="light">User Settings</span></h4>
                        <br />
                      </div>
                      <div class="tab-pane" id="tab4"> <br />
                        <h4 class="semi-bold">Step 4 - <span class="light">Feedback</span></h4>
                        <br />
                      </div>
                      <ul class=" wizard wizard-actions">
                        <li class="previous first" style="display:none;"><a href="javascript:;" class="btn">&nbsp;&nbsp;First&nbsp;&nbsp;</a></li>
                        <li class="previous"><a href="javascript:;" class="btn">&nbsp;&nbsp;Previous&nbsp;&nbsp;</a></li>
                        <li class="next last" style="display:none;"><a href="javascript:;" class="btn btn-primary">&nbsp;&nbsp;Last&nbsp;&nbsp;</a></li>
                        <li class="next"><a href="javascript:;" class="btn btn-primary">&nbsp;&nbsp;Next&nbsp;&nbsp;</a></li>
                      </ul>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="span4">
          <div class="grid simple">
            <div class="grid-title no-border">
              <h4>Ace <span class="semi-bold">Concepts</span></h4>
              <div class="tools"> <a class="collapse" href="javascript:;"></a> <a class="config" data-toggle="modal" href="#grid-config"></a> <a class="reload" href="javascript:;"></a> <a class="remove" href="javascript:;"></a> </div>
            </div>
            <div class="grid-body no-border">
              <div class="row-fluid">
                <h3>Login <span class="semi-bold">Here</span></h3>
                <p>Enter your username and password to login</p>
                <br />
                <div class="row-fluid">
                  <div class="input-append span12 primary">
                    <input type="text" id="appendedInput" class="span10" placeholder="someone@example.com" />
                    <span class="add-on"><span class="arrow"></span><i class="icon-align-justify"></i> </span> </div>
                </div>
                <div class="row-fluid">
                  <div class="input-append span12 primary">
                    <input type="password" id="appendedInput2" class="span10" placeholder="your password" />
                    <span class="add-on"><span class="arrow"></span><i class="icon-lock"></i> </span> </div>
                </div>
              </div>
              <div class="form-actions">
                <div class="pull-right">
                  <button type="submit" class="btn btn-primary btn-cons"> Login</button>
                  <button type="button" class="btn btn-white btn-cons">Cancel</button>
                </div>
              </div>
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
<!-- END PAGE LEVEL PLUGINS -->

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
	$(".select2").select2();
			 
	//Traditional form validation sample
	$('#form_traditional_validation').validate({
                focusInvalid: false, 
                ignore: "",
                rules: {
                    form1Amount: {
                        minlength: 2,
                        required: true
                    },
                    form1CardHolderName: {
						minlength: 2,
                        required: true,
                    },
                    form1CardNumber: {
                        required: true,
                        creditcard: true
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

                submitHandler: function (form) {
                
                }
            });	
	
	//Iconic form validation sample	
	   $('#form_iconic_validation').validate({
                errorElement: 'span', 
                errorClass: 'error', 
                focusInvalid: false, 
                ignore: "",
                rules: {
                    form1Name: {
                        minlength: 2,
                        required: true
                    },
                    form1Email: {
                        required: true,
                        email: true
                    },
                    form1Url: {
                        required: true,
                        url: true
                    }
                },

                invalidHandler: function (event, validator) {
					//display error alert on form submit    
                },

                errorPlacement: function (error, element) { // render error placement for each input type
                    var icon = $(element).parent('.input-with-icon').children('i');
                    var parent = $(element).parent('.input-with-icon');
                    icon.removeClass('icon-ok').addClass('icon-exclamation');  
                    parent.removeClass('success-control').addClass('error-control');  
                },

                highlight: function (element) { // hightlight error inputs
					
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    
                },

                success: function (label, element) {
                    var icon = $(element).parent('.input-with-icon').children('i');
					var parent = $(element).parent('.input-with-icon');
                    icon.removeClass("icon-exclamation").addClass('icon-ok');
					parent.removeClass('error-control').addClass('success-control'); 
                },

                submitHandler: function (form) {
                
                }
            });
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
	
	//Form Wizard Validations
	var $validator = $("#commentForm").validate({
		  rules: {
		    emailfield: {
		      required: true,
		      email: true,
		      minlength: 3
		    },
		    txtFullName: {
		      required: true,
		      minlength: 3
		    },
			txtFirstName: {
		      required: true,
		      minlength: 3
		    },
			txtLastName: {
		      required: true,
		      minlength: 3
		    },
			txtCountry: {
		      required: true,
		      minlength: 3
		    },
			txtPostalCode: {
		      required: true,
		      minlength: 3
		    },
			txtPhoneCode: {
		      required: true,
		      minlength: 3
		    },
			txtPhoneNumber: {
		      required: true,
		      minlength: 3
		    },
		    urlfield: {
		      required: true,
		      minlength: 3,
		      url: true
		    }
		  },
		  errorPlacement: function(label, element) {
				$('<span class="arrow"></span>').insertBefore(element);
				$('<span class="error"></span>').insertAfter(element).append(label)
			}
		});

	$('#rootwizard').bootstrapWizard({
	  		'tabClass': 'form-wizard',
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#commentForm").valid();
	  			if(!$valid) {
	  				$validator.focusInvalid();
	  				return false;
	  			}
				else{
					$('#rootwizard').find('.form-wizard').children('li').eq(index-1).addClass('complete');
					$('#rootwizard').find('.form-wizard').children('li').eq(index-1).find('.step').html('<i class="icon-ok"></i>');	
				}
	  		}
	 });	
	 
	 jQuery.validator.addMethod("name", function(value, element)
		{
			valid = false;
			check = /[^-\.a-zA-Z\s\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02AE]/.test(value);
			if(check==false)
				valid = true;
			return this.optional(element) || valid;
		},jQuery.format("Please enter a proper name."));
});	
	 
</script>
</body>

