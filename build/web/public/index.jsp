<%-- 
    Document   : index
    Created on : 28 May, 2019, 9:10:51 PM
    Author     : DIVIJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>JSP Title</title>

	<link href="https://fonts.googleapis.com/css?family=Poppins:300,500,600" rel="stylesheet">
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
		<!--
		CSS
		============================================= -->
                <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/linearicons.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/owl.carousel.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/font-awesome.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/animate.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/bootstrap.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/main.css">
    </head>
    <body>
        <div id="top"></div>
        <!-- Start Header Area -->
        <header class="default-header">
            <div class="sticky-header">
                <div class="container">
                    <div class="header-content d-flex justify-content-between align-items-center">
                        <div class="logo">
                        </div>
                        <div class="right-bar d-flex align-items-center">
                            <nav class="d-flex align-items-center">
                                <ul class="main-menu">
                                    <a href="#"><li>Home</li></a>
                                    <!-- <li><a href="#services">Services</a></li>
                                    <li><a href="#protfolio">Portfolio</a></li>
                                    <li><a href="#team">Team</a></li>-->
                                    <a href="admin.html"><li>Admin</li></a> 
                                    <a class="smooth" href="feedback.html"><li>Feedback</li></a>

                                </ul>
                                <a href="#" class="mobile-btn"><span class="lnr lnr-menu"></span></a>
                            </nav>
                            <div class="search relative">
                                <span class="lnr lnr-magnifier"></span>
                                <form action="#" class="search-field">
                                    <input type="text" placeholder="Search here" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Search here'">
                                    <button class="search-submit"><span class="lnr lnr-magnifier"></span></button>
                                </form>
                            </div>
                            <div class="header-social d-flex align-items-center">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- End Header Area -->
        <!-- Start Banner Area -->
        <section class="banner-area relative">
            <div class="overlay overlay-bg"></div>
            <div class="container">
                <div class="row fullscreen justify-content-center align-items-center">
                    <div class="col-lg-8">
                        <div class="banner-content text-center">




                            <div class="modal fade" id="elegantModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <!--Content-->
                                    <div class="modal-content form-elegant">
                                        <!--Header-->
                                        <div class="modal-header text-center">
                                            <h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel"><strong>Log in</strong></h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <!--Body-->
                                        <form method="post" action="login">
                                            <div class="modal-body mx-4">
                                                <!--Body-->
                                                <div class="md-form mb-5">
                                                    <input type="text" name="username" id="username" class="form-control validate" placeholder="Your email" onkeyup="loginClick()" required>
                                                </div>

                                                <div class="md-form pb-3">
                                                    <input type="password" name="userpass" id="password" class="form-control validate" placeholder="Password" onkeyup="loginClick()" required>
                                                    <span id="error" style="color:red;"></span>
                                                </div>

                                                <div class="text-center mb-3">
                                                    <button type="submit" id="btn1" name="sub" class="btn blue-gradient btn-block btn-rounded z-depth-1a">Log in</button>
                                                </div>

                                            </div>
                                        </form>


                                    </div>

                                </div>
                            </div>



<!--                            <div class="modal fade" id="elegantModalFormRegistration" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    Content
                                    <div class="modal-content form-elegant">
                                        Header
                                        <div class="modal-header text-center">
                                            <h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel"><strong>Sign Up</strong></h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        Body
                                        <form method="post" action="register">
                                            <div class="modal-body mx-4">
                                                Body
                                                <div class="md-form mb-5">
                                                    <input type="text" id="name" name="name" class="form-control validate" placeholder="Your name">

                                                </div>

                                                <div class="md-form mb-5">
                                                    <input type="email" id="Form-email1" name="email" class="form-control validate" placeholder="Your email">

                                                </div>

                                                <div class="md-form mb-5">
                                                    <input type="number" id="number" name="number" class="form-control validate" placeholder="Your phone number" maxlength="10">

                                                </div>
                                                <div class="md-form mb-5">
                                                    <input type="text" id="username" name="username" class="form-control validate" placeholder="Enter your Username">

                                                </div>
                                                <div class="md-form mb-5">
                                                    <input type="date" id="dob" name="dob" class="form-control validate" placeholder="Date of Birth">

                                                </div>

                                                <div class="md-form pb-3">
                                                    <input type="password" id="Form-pass1" name="userpass" class="form-control validate" placeholder="Password">

                                                </div>

                                                <div class="md-form pb-3">
                                                    <input type="password" id="Form-pass1" name="cpass" class="form-control validate" placeholder="Confirm password">

                                                </div>

                                                <div class="text-center mb-3">
                                                    <button type="submit" class="btn blue-gradient btn-block btn-rounded z-depth-1a" name="sub">Sign Up</button>
                                                </div>


                                            </div>
                                        </form>


                                    </div>

                                </div>
                            </div>-->



                            <p class="text-uppercase text-white">A Fancy Tag Line</p>
                            <h1 class="text-uppercase text-white">National Informatics Center</h1>
<!--                            <a href="#" class="primary-btn banner-btn" data-toggle="modal" data-target="#elegantModalFormRegistration">Sign Up</a>-->
                            <a href="#" class="primary-btn banner-btn" data-toggle="modal" data-target="#elegantModalForm">Log in</a>

                            


                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        
        <script>
  
            
            function loginClick() {
              var username = document.getElementById('username').value;
      
               var password = document.getElementById('password').value;
               var text = document.getElementById('error');
               
      var btn1 = document.getElementById('btn1');
    
      if(username==='' || password===''){
        btn1.disabled = true;
        text.innerHTML = "Username or password is empty."
      } else{
        btn1.disabled = false;
        text.innerHTML = "";
      }
     
    }
       </script>
        
     

        <script src="${pageContext.request.contextPath}/public/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/public/js/vendor/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/jquery.ajaxchimp.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/jquery.sticky.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/mixitup.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/main.js"></script>
    </body>
</html>
