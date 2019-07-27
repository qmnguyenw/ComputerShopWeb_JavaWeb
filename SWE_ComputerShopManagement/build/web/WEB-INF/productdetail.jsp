<%-- 
    Document   : productdetail
    Created on : Jun 17, 2019, 9:15:40 PM
    Author     : Quang Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css1/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css1/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css1/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css1/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css1/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css1/style.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>${product.name}'s Information</title>
        <style>
            body{
                /*                padding-left: 15%;
                                padding-right: 15%;*/
                font-family: Lucida Sans, Verdana;
                /*background-color: #fff8c6;*/
            }
            h1 {
                /*mix-blend-mode: color-dodge;*/
                font-family: Candara;
                font-size: 5rem;
                text-align: center;
                color: #ffad33;
            }
            th {
                border: 1px solid grey;
            }
            table,tr,td{
                border: 1px solid grey;
            }
            table{
                border-spacing: 0;
            }
            th,td{
                width: 40px;
            }
            tr {
                height:20px;
                width: 40px;
            }
            button{
                border-radius: 20px;
                color: white;
                padding: 10px 20px;
                font-size: 15px;
                border: 0;
            }
            #submit {
                background-color: #00ff00;     
                border-radius: 20px;
                color: white;
                border: 0;
                padding: 10px 20px;
                font-size: 15px;
                margin-left:500px;
                margin-top: 20px;
            }
            .title {
                color:red; 
            }
            #back{
                background-color: purple;
                margin-top: 150px;
            }
            .rec {
                width: 270px;
                padding: 0px;
                line-height: 19px;
            }
            #text{
                float:left;
                line-height: 22px;
            }
            .textItem{
                margin-bottom: 10px;
            }
            #enter{
                text-align: left;
                margin-left: 100px;
                float:left;
                /*margin-right: 200px;*/
            }
            button:hover, input:hover {
                text-decoration: none;
                cursor: pointer;
            }
            a:visited, a:link, a:active {
                color:white;
            }
            .error{
                color: red;
            }
            #container{
                padding-left: 20%;
                padding-right: 20%;
            }
        </style>
    </head>
    <body>

        <header>
            <!-- TOP HEADER -->
            <div id="top-header">
                <div class="container">
                    <ul class="header-links pull-left">
                        <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <li><a href="#"><i class="fa fa-dollar"></i> LS</a></li>
                        <li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
                    </ul>
                </div>
            </div>
            <!-- /TOP HEADER -->

            <!-- MAIN HEADER -->
            <div id="header">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- LOGO -->
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="#" class="logo">
                                    <img src="img1/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <!-- /LOGO -->

                        <!-- SEARCH BAR -->
                        <div class="col-md-6">
                            <div class="header-search">
                                <form>
                                    <select class="input-select">
                                        <option value="0">All Categories</option>
                                        <option value="1">Category 01</option>
                                        <option value="1">Category 02</option>
                                    </select>
                                    <input class="input" placeholder="Search here">
                                    <button class="search-btn">Search</button>
                                </form>
                            </div>
                        </div>
                        <!-- /SEARCH BAR -->

                        <!-- ACCOUNT -->
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <!-- Wishlist -->
                                <div>
                                    <a href="#">
                                        <i class="fa fa-heart-o" style="font-size:24px"></i>
                                        <span>Your Wishlist</span>
                                        <div class="qty">2</div>
                                    </a>
                                </div>
                                <!-- /Wishlist -->

                                <!-- Cart -->
                                <div class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                        <i class="fa fa-shopping-cart" style="font-size:24px"></i>
                                        <span>Your Cart</span>
                                        <div class="qty">3</div>
                                    </a>
                                    <div class="cart-dropdown">
                                        <div class="cart-list">
                                            <div class="product-widget">
                                                <div class="product-img">
                                                    <img src="img1/product01.png" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                                    <h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
                                                </div>
                                                <button class="delete"><i class="fa fa-close"></i></button>
                                            </div>

                                            <div class="product-widget">
                                                <div class="product-img">
                                                    <img src="img1/product02.png" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                                    <h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
                                                </div>
                                                <button class="delete"><i class="fa fa-close"></i></button>
                                            </div>
                                        </div>
                                        <div class="cart-summary">
                                            <small>3 Item(s) selected</small>
                                            <h5>SUBTOTAL: $2940.00</h5>
                                        </div>
                                        <div class="cart-btns">
                                            <a href="#">View Cart</a>
                                            <a href="#">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /Cart -->

                                <!-- Menu Toogle -->
                                <div class="menu-toggle">
                                    <a href="#">
                                        <i class="fa fa-bars"></i>
                                        <span>Menu</span>
                                    </a>
                                </div>
                                <!-- /Menu Toogle -->
                            </div>
                        </div>
                        <!-- /ACCOUNT -->
                    </div>
                    <!-- row -->
                </div>
                <!-- container -->
            </div>
            <!-- /MAIN HEADER -->
        </header>
        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <nav id="navigation">
            <!-- container -->
            <div class="container">
                <!-- responsive-nav -->
                <div id="responsive-nav">
                    <!-- NAV -->
                    <ul class="main-nav nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">Hot Deals</a></li>
                        <li><a href="#">Categories</a></li>
                        <li><a href="#">Laptops</a></li>
                        <li><a href="#">Smartphones</a></li>
                        <li><a href="#">Cameras</a></li>
                        <li><a href="#">Accessories</a></li>
                    </ul>
                    <!-- /NAV -->
                </div>
                <!-- /responsive-nav -->
            </div>
            <!-- /container -->
        </nav>
        <!-- /NAVIGATION -->

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="breadcrumb-header">Admin Page</h3>
                        <ul class="breadcrumb-tree">
                            <li><a href="#">Home</a></li>
                            <li class="active">Admin</li>
                            <li class="active">Product Management</li>
                            <li class="active">Details Information Product</li>
                        </ul>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /BREADCRUMB -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <h2 style="font-family: Candara;text-align: center;color: red;">Information about <span class="title"><b>${product.name}</b></span> -  ProductID <span class="title"><b>${product.id}</b></span></span> -  ProductID <span class="title"><b>${product.id}</b></span></h2>
                    <div id="container">
                        <div id="text">
                            <b class="textItem">Product ID:</b> <br><br>
                            <b class="textItem">Product Name:</b> <br><br>
                            <b class="textItem">Brand:</b> <br><br>
                            <b class="textItem">Brand Describe:</b> <br><br>
                            <b class="textItem">Price:</b> <br><br>
                            <b class="textItem">Quantity:</b> <br><br> 
                            <b class="textItem">Describe:</b> <br><br> 
                            <b class="textItem">AddDate:</b> <br><br> 
                        </div>
                        <div id="enter">
                            <input class="rec" type ="text" name="id" value="${product.id}" readonly /><br><br>
                            <input class="rec" type ="text" name="name" value="${product.name}" readonly /><br><br>
                            <input class="rec" type ="text" name="brand" value="${category.name}" readonly /><br><br>
                            <input class="rec" type ="text" name="describe" value="${category.describe}" readonly /><br><br>
                            <input class="rec" type ="text" name="price" value="${product.price}" readonly /><br><br>
                            <input class="rec" type ="text" name="quantity" value="${product.quantity}" readonly /><br><br>   
                            <input class="rec" type ="text" name="describe" value="${product.describe}" readonly /><br><br>   
                            <input class="rec" type ="text" name="addDate" value="${product.addDate}" readonly /><br><br>   

                        </div>
                    </div>
                    <br><br>
                    <p>
                        <c:if test="${product.id==null}">
                            <b><i style="color:red">Product is not exist</i></b>
                        </c:if>
                    </p>
                    <div style="margin: 200px">
                        <a id="aback" href="productlist"><button class="button" id="back">Back to Product list</button></a>
                    </div>
                </div>
            </div>
        </div>
        <footer id="footer">
            <div class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">About Us</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
                                <ul class="footer-links">
                                    <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
                                    <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
                                    <li><a href="#"><i class="fa fa-envelope-o"></i>guest@email.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Categories</h3>
                                <ul class="footer-links">
                                    <li><a href="#">Hot deals</a></li>
                                    <li><a href="#">Laptops</a></li>
                                    <li><a href="#">Smartphones</a></li>
                                    <li><a href="#">Cameras</a></li>
                                    <li><a href="#">Accessories</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="clearfix visible-xs"></div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Information</h3>
                                <ul class="footer-links">
                                    <li><a href="#">About Us</a></li>
                                    <li><a href="#">Contact Us</a></li>
                                    <li><a href="#">Privacy Policy</a></li>
                                    <li><a href="#">Orders and Returns</a></li>
                                    <li><a href="#">Terms & Conditions</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Service</h3>
                                <ul class="footer-links">
                                    <li><a href="#">My Account</a></li>
                                    <li><a href="#">View Cart</a></li>
                                    <li><a href="#">Wishlist</a></li>
                                    <li><a href="#">Track My Order</a></li>
                                    <li><a href="#">Help</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="bottom-footer" class="section">
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <ul class="footer-payments">
                                <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                                <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                            </ul>
                            <span class="copyright">
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Guest</a>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- jQuery Plugins -->
        <script src="js1/jquery.min.js"></script>
        <script src="js1/bootstrap.min.js"></script>
        <script src="js1/slick.min.js"></script>
        <script src="js1/nouislider.min.js"></script>
        <script src="js1/jquery.zoom.min.js"></script>
        <script src="js1/main.js"></script>


    </body>
</html>
