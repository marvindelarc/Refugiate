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
<!-- END CSS TEMPLATE -->
<meta name="chromesniffer" id="chromesniffer_meta" content="{&quot;jQuery&quot;:&quot;1.8.3&quot;}"><script type="text/javascript" src="chrome-extension://homgcnaoacgigpkkljjjekpignblkeae/detector.js"></script></head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="error-body no-top  pace-done"><div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
  <div class="pace-progress-inner"></div>
</div>
<div class="pace-activity"></div></div>
<div class="container">
  <div class="row login-container column-seperation">  
        <div class="col-md-5 col-md-offset-1">
          <h2>Sign in to webarch</h2>
          <p>Use Facebook, Twitter or your email to sign in.<br>
            <a href="http://revox.io/webarch/2.7/login.html#">Sign up Now!</a> for a webarch account,It's free and always will be..</p>
          <br>

		   <button class="btn btn-block btn-info col-md-8" type="button">
            <span class="pull-left"><i class="icon-facebook"></i></span>
            <span class="bold">Login with Facebook</span> </button>
		   <button class="btn btn-block btn-success col-md-8" type="button">
            <span class="pull-left"><i class="icon-twitter"></i></span>
            <span class="bold">Login with Twitter</span>
		    </button>
        </div>
        <div class="col-md-5 "> <br>
		 <form id="login-form" class="login-form" action="http://revox.io/webarch/2.7/index.html" method="post" novalidate="novalidate">
		 <div class="row">
		 <div class="form-group col-md-10">
            <label class="form-label">Username</label>
            <div class="controls">
				<div class="input-with-icon  right">                                       
					<i class=""></i>
					<input type="text" name="txtusername" id="txtusername" class="form-control">                                 
				</div>
            </div>
          </div>
          </div>
		  <div class="row">
          <div class="form-group col-md-10">
            <label class="form-label">Password</label>
            <span class="help"></span>
            <div class="controls">
				<div class="input-with-icon  right">                                       
					<i class=""></i>
					<input type="password" name="txtpassword" id="txtpassword" class="form-control">                                 
				</div>
            </div>
          </div>
          </div>
		  <div class="row">
          <div class="control-group  col-md-10">
              <a href="registrar.jsp">Registrarme?</a>
          </div>
          </div>
          <div class="row">
            <div class="col-md-10">
              <button class="btn btn-primary btn-cons pull-right" type="submit">Login</button>
            </div>
          </div>
		  </form>
        </div>
     
    
  </div>
</div>
<!-- END CONTAINER -->
<!-- BEGIN CORE JS FRAMEWORK-->
<script src="./login_files/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="./login_files/bootstrap.min.js" type="text/javascript"></script>
<script src="./login_files/pace.min.js" type="text/javascript"></script>
<script src="./login_files/jquery.validate.min.js" type="text/javascript"></script>
<script src="./login_files/login.js" type="text/javascript"></script>
<!-- BEGIN CORE TEMPLATE JS -->
<!-- END CORE TEMPLATE JS -->

</body></html>