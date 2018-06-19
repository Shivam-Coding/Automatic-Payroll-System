<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>View Business Unit</title>
    <link type="text/css" rel="stylesheet" href="css/font-awesome.css">
    <link type="text/css" rel="stylesheet" href="css/material-design-iconic-font.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/animate.css">
    <link type="text/css" rel="stylesheet" href="css/layout.css">
    <link type="text/css" rel="stylesheet" href="css/components.css">
    <link type="text/css" rel="stylesheet" href="css/widgets.css">
    <link type="text/css" rel="stylesheet" href="css/plugins.css">
    <link type="text/css" rel="stylesheet" href="css/pages.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-extend.css">
    <link type="text/css" rel="stylesheet" href="css/common.css">
    <link type="text/css" rel="stylesheet" href="css/responsive.css">
    
</head>
<body class="leftbar-view">
<!--Topbar Start Here-->
<header class="topbar clearfix">
    <!--Top Search Bar Start Here-->
    <div class="top-search-bar">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="search-input-addon">
                        <span class="addon-icon"><i class="zmdi zmdi-search"></i></span>
                        <input type="text" class="form-control top-search-input" placeholder="Search">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--Top Search Bar End Here-->
    <!--Topbar Left Branding With Logo Start-->
    <div class="topbar-left pull-left">
        <div class="clearfix">
            <ul class="left-branding pull-left clickablemenu ttmenu dark-style menu-color-gradient">
                <li><span class="left-toggle-switch"><i class="zmdi zmdi-menu"></i></span></li>
                <li>
                    <div class="logo">
                        <a href="index.html" title="Admin Template"><img src="images/logo" alt="logo"></a>
                    </div>
                </li>
            </ul>
          
        </div>
    </div>
    <!--Topbar Left Branding With Logo End-->
  
</header>
<!--Topbar End Here-->
<!--Leftbar Start Here-->
<aside class="leftbar material-leftbar">
    <div class="left-aside-container">
       
        <ul class="list-accordion">
            <li class="list-title">Employees</li>
            <li>
                <a href="addEmployee.html"><i class="zmdi zmdi-view-dashboard"></i><span class="list-label">Add Employee</span></a>
               
            </li>
            
             <li>
                <a href="viewEmployee.html"><i class="zmdi zmdi-view-dashboard"></i><span class="list-label">View Employees</span></a>
               
            </li>
            <li class="list-title">Payroll</li>
            <li>
                <a href="addDesignation.html"><i class="zmdi zmdi-view-web"></i><span class="list-label">Add Designation</span></a>
                
            </li>
            <li>
                <a href="addBenefits.html"><i class="zmdi zmdi-check"></i><span class="list-label">Add Benefits</span></a>
               
            </li>
            <li>
                <a href="addDeductions.html"><i class="zmdi zmdi-swap"></i><span class="list-label">Add Deductions</span></a>
               
            </li>
             <li class="list-title">Company</li>
            <li>
                <a href="addCompany.html"><i class="zmdi zmdi-grid"></i><span class="list-label">Add Company</span></a>
               
            </li>
            
            <li>
                <a href="viewCompany.html"><i class="zmdi zmdi-grid"></i><span class="list-label">View Company</span></a>
               
            </li>
            <li class="list-title">Charts</li>
            <li>
                <a href="#"><i class="zmdi zmdi-chart"></i><span class="list-label">Charts & Graphs</span></a>
              
            </li>
            <li class="list-title">Ui Kits</li>
            <li>
                <a href="#"><i class="zmdi zmdi-apps"></i><span class="list-label">Ui Elements</span></a>
               
            </li>
           
            
        </ul>
    </div>
</aside>
<!--Leftbar End Here-->
<!--Page Container Start Here-->
<section class="main-container">
    <div class="container-fluid">
        <div class="page-header filled full-block light">
            <div class="row">
                <div class="col-md-6">
                    <h2>View Business Unit:</h2>
                    
                </div>
               
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="widget-wrap">
                  
                    <div class="widget-container">
                        <div class="widget-content">
                            <div class="row">
                                <div class="col-md-6">
                                     
                                    
                                   
                                    <table class="table table-inverse">
                                        <thead>
                                          <tr>
                                            <th style="font-weight:bold">Name</th>
                                            <th style="font-weight:bold">Start date</th>
                                            <th style="font-weight:bold">City</th>
                                             <th style="font-weight:bold">Phone Number</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <td>John</td>
                                            <td>Doe</td>
                                            <td>john@example.com</td>
                                            <td>john@example.com</td>
                                          </tr>
                                        
                                        </tbody>
                                      </table>
                                    
                                    
                                </div>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
        

    </div>
    <!--Footer Start Here -->
    <footer class="footer-container">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div class="footer-left">
                        <span>© 2016 <a href="">Pay Me!</a></span>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6">
                    <div class="footer-right">
                        <span class="footer-meta">Crafted by&nbsp;<i class="fa fa-heart"></i>&nbsp;by&nbsp;<a href="">Payme!</a></span>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--Footer End Here -->
</section>
<!--Page Container End Here-->
<!--Rightbar Start Here-->

<!--Rightbar End Here-->
     
<script src="js/lib/jquery.js"></script>
<script src="js/lib/jquery-migrate.js"></script>
<script src="js/lib/bootstrap.js"></script>
<script src="js/lib/jquery.ui.js"></script>
<script src="js/lib/jRespond.js"></script>
<script src="js/lib/nav.accordion.js"></script>
<script src="js/lib/hover.intent.js"></script>
<script src="js/lib/hammerjs.js"></script>
<script src="js/lib/jquery.hammer.js"></script>
<script src="js/lib/jquery.fitvids.js"></script>
<script src="js/lib/scrollup.js"></script>
<script src="js/lib/smoothscroll.js"></script>
<script src="js/lib/jquery.slimscroll.js"></script>
<script src="js/lib/jquery.syntaxhighlighter.js"></script>
<script src="js/lib/velocity.js"></script>
<script src="js/lib/smart-resize.js"></script>

<!--Forms-->
<script src="js/lib/jquery.maskedinput.js"></script>
<script src="js/lib/jquery.validate.js"></script>
<script src="js/lib/jquery.form.js"></script>
<script src="js/lib/j-forms.js"></script>
<script src="js/lib/jquery.loadmask.js"></script>
<script src="js/apps.js"></script>
</body>
</html>