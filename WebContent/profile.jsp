<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>Profile</title>
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
                       <a href="emphome.jsp" title="Admin Template"><img src="images/logo.png" height="60" width="75" alt="logo"></a>
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
            <li class="list-title"><a href="PreProfile" >Edit Profile</a></li>
            
            <li  class="list-title"><a href="viewPaySlipEmp.jsp">View Pay Slip</a></li>
          
            <li  class="list-title"><a href="timepunch.jsp">Enter Time Punch</a></li>
                      
            <li  class="list-title"><a href="Logout">Logout</a></li>
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
                    <h2>Profile</h2>
                    <p>Fill the relevant fields:</p>
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
                                      <span style="color:green"><p style="font-weight:bold">${success}</p></span> 
                                    
                                    
                                    
                                    <% Map<String, ArrayList> emp = (Map)request.getAttribute("emp"); 
                                    
                                	 
                                    
                                	ArrayList<String> empcode=emp.get("empcode");
                                	ArrayList<String> firstName=	emp.get("firstName");
                                	ArrayList<String> lastName=emp.get("lastName");
                                	ArrayList<String> emailid=emp.get("emailid");
                                	ArrayList<String> password=emp.get("password");
                                	ArrayList<String> designation=	emp.get("designation");
                                	ArrayList<String> dob=	emp.get("dob");
                                	ArrayList<String> al1=	emp.get("al1");
                                	ArrayList<String> al2=	emp.get("al2");
                                	ArrayList<String> city=	emp.get("city");
                                	ArrayList<String> state= 	emp.get("state");
                                	ArrayList<String> zipcode=	emp.get("zipcode");
                                	ArrayList<String> phone=emp.get("phone");
                                    
                                    %>
                                    <form class="form-horizontal" action="UpdateProfile" method="post">
                                        
                                        
                                        
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Employee Code<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=empcode.get(0) %>" name="employeecode" disabled="disabled">
                                                
                                            </div>
                                        </div>
                                        
                                        
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">First Name<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=firstName.get(0) %>" name="fname"  disabled="disabled">
                    
                                            </div>
                                        </div>
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Last Name<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=lastName.get(0) %>" name="lname"  disabled="disabled">
                    
                                            </div>
                                        </div>
                                        
                                          <div class="form-group">
                                            <label class="col-md-4 control-label">Designation<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                               <input type="text" class="form-control" value="<%=designation.get(0) %>" disabled="disabled">
                    
                                            </div>
                                        </div>
                                        
                                          <div class="form-group">
                                            <label class="col-md-4 control-label">Email<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=emailid.get(0) %>" name="email" required>
                                               
                                            </div>
                                        </div>
                                        
                                        
                                              <div class="form-group">
                                            <label class="col-md-4 control-label">Password<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=password.get(0) %>" name="password" required>
                                               
                                            </div>
                                        </div>
                                     
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Date of Birth<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                               <input type="text" class="form-control" value="<%=dob.get(0) %>"  disabled="disabled">
                    
                                            </div>
                                        </div>
                               
                                        
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Address Line 1<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=al1.get(0) %>" name="al1" >
                    
                                            </div>
                                        </div>
                                        
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Address Line 2:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=al2.get(0) %>" name="al2">
                    
                                            </div>
                                        </div> 
                                        
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">City<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=city.get(0) %>" name="city" >
                    
                                            </div>
                                        </div> 
                                       
                                     
                                          
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">State<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=state.get(0) %>" name="state" >
                    
                                            </div>
                                        </div> 
                                
                                          
                                        
                                        
                                          <div class="form-group">
                                            <label class="col-md-4 control-label">Zip Code<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=zipcode.get(0) %>" name="zipcode" >
                    
                                            </div>
                                        </div> 
                                        
                                          
                                         <div class="form-group">
                                            <label class="col-md-4 control-label">Phone Number<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" value="<%=phone.get(0) %>" name="phonenumber">
                    
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