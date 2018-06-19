<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>Add Employee</title>
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
                        <a href="adminhome.jsp" title="Admin Template"><img src="images/logo.png" height="60" width="75" alt="logo"></a>
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
                <a href="Designation?action=data&page=addemployee"><i class="zmdi zmdi-view-dashboard"></i><span class="list-label">Add Employee</span></a>
               
            </li>
            
             <li>
                <a href="Employee?action=viewEmp"><i class="zmdi zmdi-view-dashboard"></i><span class="list-label">View Employees</span></a>
               
            </li>
             <li>
                <a href="PreUpdate"><i class="zmdi zmdi-check"></i><span class="list-label">Update Salary</span></a>
               
            </li>
            <li class="list-title">Payroll</li>
            <li>
                <a href="addDesignation.jsp"><i class="zmdi zmdi-view-web"></i><span class="list-label">Add Designation</span></a>
                
            </li>
            <li>
                <a href="Designation?action=data&page=benefits"><i class="zmdi zmdi-check"></i><span class="list-label">Add Benefits</span></a>
               
            </li>
            <li>
                <a href="Designation?action=data&page=deductions"><i class="zmdi zmdi-swap"></i><span class="list-label">Add Deductions</span></a>
               
            </li>
            <li>
                <a href="viewPaySlip.jsp"><i class="zmdi zmdi-swap"></i><span class="list-label">View Pay Slip</span></a>
               
            </li>
             <li class="list-title">Account</li>
            <li>
                <a href="Logout"><i class="zmdi zmdi-swap"></i><span class="list-label">Logout</span></a>
               
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
                    <h2>Add Employee</h2>
                    <p>Fill the relevant fields:</p>
                </div>
               
            </div>
        </div>
<%String msg = (String)request.getAttribute("msg"); 
ArrayList<String[]> data = (ArrayList<String[]>)request.getAttribute("data"); %>
        <div class="row">
            <div class="col-md-12">
                <div class="widget-wrap">
                  
                    <div class="widget-container">
                        <div class="widget-content">
                            <div class="row">
                                <div class="col-md-6">
                                      <span style="color:green"><p style="font-weight:bold"><%if(msg != null){out.print(msg);} %></p></span> 
                                    
                                    <form class="form-horizontal" action="Employee" method="post">
                                        <input type="hidden" name="action" value="addEmp">
                                        
                                        
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Employee Code<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter text" name="employeecode" required>
                                                
                                            </div>
                                        </div>
                                        
                                        
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">First Name<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter First Name" name="fname" required>
                    
                                            </div>
                                        </div>
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Last Name<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter Last Name" name="lname" required>
                    
                                            </div>
                                        </div>
                                        
                                          <div class="form-group">
                                            <label class="col-md-4 control-label">Designation<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <select class="form-control" name="designation">
                                                    <%if(data != null) {
                                                      for(int i=0;i< data.size();i++){
                                                      String d[] = data.get(i);%>
                                                    <option value="<%=d[0]%>"><%=d[0] %></option>
                                                   
                                                    <%}} %> 
                                                </select>
                    
                                            </div>
                                        </div>
                                        
                                          <div class="form-group">
                                            <label class="col-md-4 control-label">Email<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter email" name="email" required>
                                               
                                            </div>
                                        </div>
                                     
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Date of Birth<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                               <input type="date" name="dob" required>
                    
                                            </div>
                                        </div>
                                        
                                        
                                        
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Gender<span style="color:red">*</span>:</label>
                                            <div class="col-md-8">
                                                <select class="form-control" name="gender">
                                                     <option>Select...</option>
                                                    <option>Male</option>
                                                    <option>Female</option>
                                                   
                                                </select>
                                            </div>
                                        </div>
                                        
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Address Line 1<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter address line 1" name="al1" required>
                    
                                            </div>
                                        </div>
                                        
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Address Line 2:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter Address Line 2" name="al2">
                    
                                            </div>
                                        </div> 
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">City<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter City" name="city" required>
                    
                                            </div>
                                        </div> 
                                       
                                     
                                          
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">State<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter State" name="state" required>
                    
                                            </div>
                                        </div> 
                                
                                          
                                        
                                        
                                          <div class="form-group">
                                            <label class="col-md-4 control-label">Zip Code<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter Zip code" name="zipcode" required>
                    
                                            </div>
                                        </div> 
                                        
                                          
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Phone Number<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter Phone Number" name="phonenumber" required>
                    
                                            </div>
                                        </div> 
                                          (<span style="color:red">*</span> - Required)
                                        
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">&nbsp;</label>
                                            <div class="col-md-8">
                                                <div class="form-actions">
                                                    <input type="submit" class="btn btn-primary" value="Save changes">
                                                   
                                                </div>
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