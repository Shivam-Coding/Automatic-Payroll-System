<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>View Pay Slip</title>
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
                    <h2>Pay Slip:</h2>
                    
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
 
 <%String[] pay = (String[])request.getAttribute("pay"); 
 if(pay == null){ %>
                                    
                                    
                                      <form class="form-horizontal" action="PaySlip" method="post">
                                       <input type="hidden" name="action" value="paySlip" > 
                                         
                                        
                                      
                                        
                                          
                                           <div class="form-group">
                                            <label class="col-md-4 control-label">Choose Month<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <select class="form-control" name="month">
                                                 <option selected value='1'>Janaury</option>
                                                <option value='2'>February</option>
                                                <option value='3'>March</option>
                                                <option value='4'>April</option>
                                                <option value='5'>May</option>
                                                <option value='6'>June</option>
                                                <option value='7'>July</option>
                                                <option value='8'>August</option>
                                                <option value='9'>September</option>
                                                <option value='10'>October</option>
                                                <option value='11'>November</option>
                                                <option value='12'>December</option>      
                                                
                                                </select>
                    
                                                
                                            </div>
                                        </div>
                                        
                                          
                                          
                                           <div class="form-group">
                                            <label class="col-md-4 control-label">Year:<span style="color:red">*</span>:</label>
                                            <div class=" col-md-8">
                                                <input type="text" class="form-control" placeholder="Enter year" name="year" required>
                                                
                                            </div>
                                        </div>
                                         <div class="form-group">
                                           
                                            <label class="col-md-4 control-label">&nbsp;</label>
                                            <div class="col-md-8">
                                                <div class="form-actions">
                                                    <input type="submit" class="btn btn-primary" value="View Pay Slip">
                                                   
                                                </div>
                                            </div>
                                        </div>
                                          
                                    </form>
 <%}else{ %> 
                                    <div>
                                    <br>
                                    <h3>Pay Slip:</h3>
                                    <br>
                                    
                                    <table class="table">
                                        <tr>
                                        <td>Name: </td>
                                        <td><%=pay[0] %></td>
                                        </tr>
                                        <tr>
                                        <td>Basic Salary: </td>
                                        <td><%=pay[1] %></td>
                                        </tr>
                                        <tr>
                                        <td><span style="font-weight: bold">Benefits</span></td>
                                        <td></td>
                                        </tr>
                                        <tr>
                                        <td>House Rent Allowance:</td>
                                        <td><%=pay[2]%></td>
                                        </tr>
                                        <tr>
                                        <td>Dearness Allowance:</td>
                                        <td><%=pay[3]%></td>
                                        </tr>
                                        <tr>
                                        <td>Work Allowance:</td>
                                        <td><%=pay[4] %></td>
                                        </tr>
                                        <tr>
                                        <td><span style="font-weight: bold">Deductions</span></td>
                                        <td></td>
                                        </tr>
                                        <tr>
                                        <td>General Provident Fund:</td>
                                        <td><%=pay[5] %></td>
                                        </tr>
                                        <tr>
                                        <td>Employer Provident Fund:</td>
                                        <td><%=pay[8] %></td>
                                        </tr>
                                        <tr>
                                        <td>State Tax:</td>
                                        <td><%=pay[6] %></td>
                                        </tr>
                                        <tr>
                                        <td>Federal Tax:</td>
                                        <td><%=pay[7] %></td>
                                        </tr>
                                        <tr>
                                        <td>Insurance:</td>
                                        <td><%=pay[9] %></td>
                                        </tr>
                                        
                                        
                                    </table>
                                    <p><span style="font-weight: bold">Salary: </b><%=pay[10] %>
                                </div>
                                
                                
 <%} %>
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