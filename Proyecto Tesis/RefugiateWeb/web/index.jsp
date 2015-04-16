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
<title>Webarch - Responsive Admin Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta content="" name="desceription" />
<meta content="" name="author" />
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
        <li class="dropdown" id="header_inbox_bar"> <a href="email.html" class="dropdown-toggle">
          <div class="iconset top-messages"></div>
          <span class="badge" id="msgs-badge">2</span> </a></li>
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
      <!-- END TOP NAVIGATION MENU -->
      <!-- BEGIN CHAT TOGGLER -->
      <div class="pull-right"> 
		<div class="chat-toggler">	
				<a href="#" class="dropdown-toggle" id="my-task-list" data-placement="bottom" data-content='
						<div style="width:300px" class="scroller" data-height="100px">
						  <div class="notification-messages info">
									<div class="user-profile">
										<img src="assets/img/profiles/d.jpg" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" width="35" height="35">
									</div>
									<div class="message-wrapper">
										<div class="heading">
											David Nester - Commented on your wall
										</div>
										<div class="description">
											Meeting postponed to tomorrow
										</div>
										<div class="date pull-left">
										A min ago
										</div>										
									</div>
									<div class="clearfix"></div>									
								</div>	
							<div class="notification-messages danger">
								<div class="iconholder">
									<i class="icon-warning-sign"></i>
								</div>
								<div class="message-wrapper">
									<div class="heading">
										Server load limited
									</div>
									<div class="description">
										Database server has reached its daily capicity
									</div>
									<div class="date pull-left">
									2 mins ago
									</div>
								</div>
								<div class="clearfix"></div>
							</div>	
							<div class="notification-messages success">
								<div class="user-profile">
									<img src="assets/img/profiles/h.jpg" data-src="assets/img/profiles/h.jpg" data-src-retina="assets/img/profiles/h2x.jpg" width="35" height="35">
								</div>
								<div class="message-wrapper">
									<div class="heading">
										You haveve got 150 messages
									</div>
									<div class="description">
										150 newly unread messages in your inbox
									</div>
									<div class="date pull-left">
									An hour ago
									</div>									
								</div>
								<div class="clearfix"></div>
							</div>							
						</div>' data-toggle="dropdown" data-original-title="Notifications">
					<div class="user-details"> 
						<div class="username">
							<span class="badge badge-important">3</span> 
							John <span class="bold">Smith</span>									
						</div>						
					</div> 
					<div class="iconset top-down-arrow"></div>
				</a>						
				<div class="profile-pic"> 
					<img alt="" src="assets/img/profiles/avatar_small.jpg" data-src="assets/img/profiles/avatar_small.jpg" data-src-retina="assets/img/profiles/avatar_small2x.jpg" width="35" height="35" /> 
				</div>       			
			</div>
		 <ul class="nav quick-section ">
			<li class="quicklinks"> 
				<a data-toggle="dropdown" class="dropdown-toggle  pull-right" href="#">						
					<div class="iconset top-settings-dark "></div> 	
				</a>
				<ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="dropdownMenu">
                  <li><a href="user-profile.html"> My Account</a>
                  </li>
                  <li><a href="calender.html">My Calendar</a>
                  </li>
                  <li><a href="email.html"> My Inbox&nbsp;&nbsp;<span class="badge badge-important animated bounceIn">2</span></a>
                  </li>
                  <li class="divider"></li>                
                  <li><a href="login.html"><i class="icon-off"></i>&nbsp;&nbsp;Log Out</a></li>
               </ul>
			</li> 
			<li class="quicklinks"> <span class="h-seperate"></span></li> 
			
		</ul>
      </div>
      <!-- END CHAT TOGGLER -->
    </div>
    <!-- END TOP NAVIGATION MENU -->
  </div>
  <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->
<!-- BEGIN CONTAINER -->
<div class="page-container row-fluid">
  <!-- BEGIN SIDEBAR -->
  <div class="page-sidebar" id="main-menu">
    <!-- BEGIN MINI-PROFILE -->
    <div class="user-info-wrapper">
      <div class="profile-wrapper"> <img src="assets/img/profiles/avatar.jpg" data-src="assets/img/profiles/avatar.jpg" data-src-retina="assets/img/profiles/avatar2x.jpg" width="69" height="69" /> </div>
      <div class="user-info">
        <div class="greeting">Welcome</div>
        <div class="username">John <span class="semi-bold">Smith</span></div>
        <div class="status">Status<a href="#">
          <div class="status-icon green"></div>
          Online</a></div>
      </div>
    </div>
    <!-- END MINI-PROFILE -->
    <!-- BEGIN MINI-WIGETS -->
    <!-- END MINI-WIGETS -->
    <!-- BEGIN SIDEBAR MENU -->
    <p class="menu-title">BROWSE <span class="pull-right"><i class="icon-refresh"></i></span></p>
    <ul>
      <li class="start active "> <a href="index.html"> <i class="icon-custom-home"></i> <span class="title">Dashboard</span> <span class="selected"></span> <span class="badge badge-important pull-right">5</span></a> </li>
      <li class=""> <a href="email.html"> <i class="icon-envelope"></i> <span class="title">Email</span> <span class=" badge badge-disable pull-right ">203</span></a> </li>
      <li class=""> <a href="javascript:;"> <i class="icon-custom-ui"></i> <span class="title">UI Elements</span> <span class="arrow "></span> </a>
        <ul class="sub-menu">
          <li> <a href="typography.html"> Typography </a> </li>
          <li> <a href="messages_notifications.html"> Messages & Notifications </a> </li>
          <li> <a href="icons.html">Icons</a> </li>
          <li> <a href="buttons.html">Buttons</a> </li>
          <li> <a href="tabs_accordian.html"> Tabs & Accordions </a> </li>
          <li> <a href="sliders.html">Sliders</a> </li>
          <li> <a href="group_list.html">Group list </a> </li>
        </ul>
      </li>
      <li class=""> <a href="javascript:;"> <i class="icon-custom-form"></i> <span class="title">Forms</span> <span class="arrow "></span> </a>
        <ul class="sub-menu">
          <li> <a href="form_elements.html">Form Elements </a> </li>
          <li> <a href="form_validations.html">Form Validations</a> </li>
        </ul>
      </li>
      <li class=""> <a href="javascript:;"> <i class="icon-custom-portlets"></i> <span class="title">Grids</span> <span class="arrow "></span> </a>
        <ul class="sub-menu">
          <li> <a href="grids_simple.html">Simple Grids</a> </li>
          <li> <a href="grids_draggable.html">Draggable Grids </a> </li>
        </ul>
      </li>
      <li class=""> <a href="javascript:;"> <i class="icon-custom-thumb"></i> <span class="title">Tables</span> <span class="arrow "></span> </a>
        <ul class="sub-menu">
          <li> <a href="tables.html"> Basic Tables </a> </li>
          <li> <a href="datatables.html"> Data Tables </a> </li>
        </ul>
      </li>
      <li class=""> <a href="javascript:;"> <i class="icon-custom-map"></i> <span class="title">Maps</span> <span class="arrow "></span> </a>
        <ul class="sub-menu">
          <li> <a href="google_map.html"> Google Maps </a> </li>
          <li> <a href="vector_map.html"> Vector Maps </a> </li>
        </ul>
      </li>
      <li class=""> <a href="charts.html"> <i class="icon-custom-chart"></i> <span class="title">Charts</span> </a> </li>
      <li class=""> <a href="javascript:;"> <i class="icon-custom-extra"></i> <span class="title">Extra</span> <span class="arrow "></span> </a>
        <ul class="sub-menu">
          <li> <a href="user-profile.html"> User Profile </a> </li>
          <li> <a href="gallery.html"> Gallery</a> </li>
          <li class=""><a href="calender.html"> Calendar</a> </li>
          <li> <a href="invoice.html"> Invoice </a> </li>
          <li> <a href="404.html"> 404 Page </a> </li>
          <li> <a href="500.html"> 500 Page </a> </li>
          <li> <a href="blank_template.html"> Blank Page </a> </li>
        </ul>
      </li>
      <li class="hidden-desktop hidden-phone visible-tablet" id="more-widgets" style="display:"> <a href="javascript:;"> <i class="icon-ellipsis-horizontal"></i></a>
        <ul class="sub-menu">
          <div class="side-bar-widgets">
            <p class="menu-title">FOLDER <span class="pull-right"><a href="#" class="create-folder"><i class="icon-plus"></i></a></span></p>
            <ul class="folders" id="folders">
              <li><a href="#">
                <div class="status-icon green"></div>
                My quick tasks </a> </li>
              <li><a href="#">
                <div class="status-icon red"></div>
                To do list </a> </li>
              <li><a href="#">
                <div class="status-icon blue"></div>
                Projects </a> </li>
              <li id="folder-input" class="folder-input" style="display:none">
                <input type="text" placeholder="Name of folder" class="no-boarder folder-name" name="" id="folder-name" />
              </li>
            </ul>
            <p class="menu-title">PROJECTS </p>
            <div class="status-widget">
              <div class="status-widget-wrapper">
                <div class="title">Freelancer<a href="#" class="remove-widget"><i class="icon-custom-cross"></i></a></div>
                <p>Redesign home page</p>
              </div>
            </div>
            <div class="status-widget">
              <div class="status-widget-wrapper">
                <div class="title">envato<a href="#" class="remove-widget"><i class="icon-custom-cross"></i></a></div>
                <p>Statistical report</p>
              </div>
            </div>
          </div>
        </ul>
      </li>
    </ul>
    <div class="side-bar-widgets">
      <p class="menu-title">FOLDER <span class="pull-right"><a href="#" class="create-folder"><i class="icon-plus"></i></a></span></p>
      <ul class="folders" id="folders">
        <li><a href="#">
          <div class="status-icon green"></div>
          My quick tasks </a> </li>
        <li><a href="#">
          <div class="status-icon red"></div>
          To do list </a> </li>
        <li><a href="#">
          <div class="status-icon blue"></div>
          Projects </a> </li>
        <li id="folder-input" class="folder-input" style="display:none">
          <input type="text" placeholder="Name of folder" class="no-boarder folder-name" name="" id="folder-name" />
        </li>
      </ul>
      <p class="menu-title">PROJECTS </p>
      <div class="status-widget">
        <div class="status-widget-wrapper">
          <div class="title">Freelancer<a href="#" class="remove-widget"><i class="icon-custom-cross"></i></a></div>
          <p>Redesign home page</p>
        </div>
      </div>
      <div class="status-widget">
        <div class="status-widget-wrapper">
          <div class="title">envato<a href="#" class="remove-widget"><i class="icon-custom-cross"></i></a></div>
          <p>Statistical report</p>
        </div>
      </div>
    </div>
    <a href="#" class="scrollup">Scroll</a>
    <div class="clearfix"></div>
    <!-- END SIDEBAR MENU -->
  </div>
  <div class="footer-widget">
    <div class="progress transparent progress-success progress-small no-radius no-margin">
      <div data-percentage="79%" class="bar animate-progress-bar"></div>
    </div>
    <div class="pull-right">
      <div class="details-status"> <span data-animation-duration="560" data-value="86" class="animate-number"></span>% </div>
      <a href="login.html"><i class="icon-off"></i></a></div>
  </div>
  <!-- END SIDEBAR -->
  <!-- BEGIN PAGE CONTAINER-->
    
  <div id="container"></div>
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
<script>
function getContainer()
{
    $.ajax({
            url: 'crud.jsp',
            type: 'POST',
            success: function (data) {     
                     $('#container').html(data);
            },
            contentType: false,
            processData: false
        });
};  
getContainer();
</script>
</body>

