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
      

	  <div id="push"></div>
</div>
 <div id="footer">
      <div class="span12 error-container">
	  <ul class="footer-links">
			<li><a href="#">Template Guidelines</a></li>
			<li><a href="#">Copyrights & Privacy </a></li>
			<li><a href="#">Help & FAQ</a></li>
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">Reports</a></li>
			<li><a href="#">Search</a></li>
			<li><a href="#">Buy theme</a></li>
		</ul>
		<br />
		<ul class="footer-links small-links">
			<li><a href="#">Home</a></li>
			<li><a href="#">About Us </a></li>
			<li><a href="#">UI Elements</a></li>
			<li><a href="#">Charts</a></li>
			<li><a href="#">Mobile Apps</a></li>
			<li><a href="#">Responsive Design</a></li>
			<li><a href="#">Design</a></li>
		</ul>
		<br />
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

<!-- BEGIN CORE TEMPLATE JS --> 
<script type="text/javascript">
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
