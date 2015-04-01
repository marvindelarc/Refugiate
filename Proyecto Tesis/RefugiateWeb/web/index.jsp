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
  <div class="page-content">
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
<script src="assets/js/form_validations.js" type="text/javascript"></script>
<!-- BEGIN CORE TEMPLATE JS -->
<script src="assets/js/core.js" type="text/javascript"></script>
<script src="assets/js/demo.js" type="text/javascript"></script>
<!-- END CORE TEMPLATE JS -->
<!-- END JAVASCRIPTS -->
</body>

