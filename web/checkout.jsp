<%-- 
    Document   : checkout
    Created on : Mar 13, 2021, 10:59:35 AM
    Author     : PC
--%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Boutique | Ecommerce bootstrap template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Lightbox-->
        <link rel="stylesheet" href="vendor/lightbox2/css/lightbox.min.css">
        <!-- Range slider-->
        <link rel="stylesheet" href="vendor/nouislider/nouislider.min.css">
        <!-- Bootstrap select-->
        <link rel="stylesheet" href="vendor/bootstrap-select/css/bootstrap-select.min.css">
        <!-- Owl Carousel-->
        <link rel="stylesheet" href="vendor/owl.carousel2/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="vendor/owl.carousel2/assets/owl.theme.default.css">
        <!-- Google fonts-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Libre+Franklin:wght@300;400;700&amp;display=swap">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Martel+Sans:wght@300;400;800&amp;display=swap">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- Tweaks for older IEs--><!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body>
        <div class="page-holder">
            <!-- navbar-->
            <header class="header bg-white">
                <div class="container px-0 px-lg-3">
                    <nav class="navbar navbar-expand-lg navbar-light py-3 px-lg-0"><a class="navbar-brand" href="home.jsp"><span class="font-weight-bold text-uppercase text-dark">Smart Phone</span></a>
                        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <!-- Link--><a class="nav-link active" href="home.jsp">Home</a>
                                </li>
                                <li class="nav-item">
                                    <!-- Link--><a class="nav-link" href="ShopController">Shop</a>
                                </li>

                            </ul>
                            <ul class="navbar-nav ml-auto">               
                                <li class="nav-item"><a class="nav-link" href="cart.jsp"> <i class="fas fa-dolly-flatbed mr-1 text-gray"></i>Cart<small class="text-gray">(${sessionScope.CART.getCart().size()})</small></a></li>


                                <c:if test="${sessionScope.LOGIN_USER != null}" >
                                    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="pagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${sessionScope.LOGIN_USER.fullName}</a>
                                        <div class="dropdown-menu mt-3" aria-labelledby="pagesDropdown">
                                            <c:if test="${sessionScope.LOGIN_USER.roleID == 'AD'}" >
                                                <a class="dropdown-item border-0 transition-link" href="ManagementController">Manage products</a>
                                            </c:if>
                                            <a class="dropdown-item border-0 transition-link" href="LogoutController">Logout</a>

                                        </div>
                                    </li>

                                </c:if>
                                <c:if test="${sessionScope.LOGIN_USER == null}" >
                                    <li class="nav-item"><a class="nav-link" href="login.jsp"> <i class="fas fa-user-alt mr-1 text-gray"></i>Login</a></li>
                                    </c:if>
                            </ul>
                        </div>
                    </nav>
                </div>
            </header>

            <div class="container">
                <!-- HERO SECTION-->
                <section class="py-5 bg-light">
                    <div class="container">
                        <div class="row px-4 px-lg-5 py-lg-4 align-items-center">
                            <div class="col-lg-6">
                                <h1 class="h2 text-uppercase mb-0">Checkout</h1>
                            </div>
                            <div class="col-lg-6 text-lg-right">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb justify-content-lg-end mb-0 px-0">
                                        <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
                                        <li class="breadcrumb-item"><a href="cart.jsp">Cart</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Checkout</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </section>
                <section class="py-5">
                    <!-- BILLING ADDRESS-->
                    <h2 class="h5 text-uppercase mb-4">Billing details</h2>
                    <div class="row">
                        <div class="col-lg-8">
                            <form action="#">
                                <div class="row">
                                    <div class="col-lg-6 form-group">
                                        <label class="text-small text-uppercase" for="firstName">Full name</label>
                                        <p >${sessionScope.LOGIN_USER.fullName}</p>
                                    </div>

                                    <div class="col-lg-6 form-group">
                                        <label class="text-small text-uppercase" for="email">Email address</label>
                                        <p >${sessionScope.LOGIN_USER.email}</p>
                                    </div>
                                    <div class="col-lg-6 form-group">
                                        <label class="text-small text-uppercase" for="phone">Phone number</label>
                                        <p >${sessionScope.LOGIN_USER.phone}</p>
                                    </div>

                                    <div class="col-lg-12 form-group">
                                        <label class="text-small text-uppercase" for="address">Address</label>
                                        <p >${sessionScope.LOGIN_USER.address}</p>
                                    </div>
                                    <div class="col-lg-12 form-group">
                                                                               
                                        <button class="btn btn-dark" type="submit"><a href="MainController?action=Check out" >Place order</a></button>
                                        
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- ORDER SUMMARY-->
                        <div class="col-lg-4">
                            <div class="card border-0 rounded-0 p-lg-4 bg-light">
                                <div class="card-body">
                                    <h5 class="text-uppercase mb-4">Your order</h5>
                                    <ul class="list-unstyled mb-0">
                                        <c:set var="total" value="${0}"/>
                                        <c:forEach items="${sessionScope.LIST_ALL}" var="p" >
                                            <c:forEach items="${sessionScope.CART.getCart().values()}" var="od" >
                                                <c:if test="${p.productID == od.productID}" >
                                                    <li class="d-flex align-items-center justify-content-between">
                                                        <strong class="small font-weight-bold">${p.name}</strong>
                                                        <c:set var="total" value="${total + (p.price * od.quantity)}"/>
                                                        <span class="text-muted small">$<fmt:formatNumber value="${p.price * od.quantity}" minFractionDigits="2" maxFractionDigits="2" ></fmt:formatNumber> </span>
                                                        </li>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>
                                        <li class="d-flex align-items-center justify-content-between"><strong class="text-uppercase small font-weight-bold">Total</strong>
                                            <span>$<fmt:formatNumber value="${total}" minFractionDigits="2" maxFractionDigits="2" ></fmt:formatNumber></span></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <footer class="bg-dark text-white">
                <div class="container py-4">
                    <div class="row py-5">
                        <div class="col-md-4 mb-3 mb-md-0">
                            <h6 class="text-uppercase mb-3">Customer services</h6>
                            <ul class="list-unstyled mb-0">
                                <li><a class="footer-link" href="#">Help &amp; Contact Us</a></li>
                                <li><a class="footer-link" href="#">Returns &amp; Refunds</a></li>
                                <li><a class="footer-link" href="#">Online Stores</a></li>
                                <li><a class="footer-link" href="#">Terms &amp; Conditions</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4 mb-3 mb-md-0">
                            <h6 class="text-uppercase mb-3">Company</h6>
                            <ul class="list-unstyled mb-0">
                                <li><a class="footer-link" href="#">What We Do</a></li>
                                <li><a class="footer-link" href="#">Available Services</a></li>
                                <li><a class="footer-link" href="#">Latest Posts</a></li>
                                <li><a class="footer-link" href="#">FAQs</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4">
                            <h6 class="text-uppercase mb-3">Social media</h6>
                            <ul class="list-unstyled mb-0">
                                <li><a class="footer-link" href="#">Twitter</a></li>
                                <li><a class="footer-link" href="#">Instagram</a></li>
                                <li><a class="footer-link" href="#">Tumblr</a></li>
                                <li><a class="footer-link" href="#">Pinterest</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="border-top pt-4" style="border-color: #1d1d1d !important">
                        <div class="row">
                            <div class="col-lg-6">
                                <p class="small text-muted mb-0">&copy; 2020 All rights reserved.</p>
                            </div>
                            <div class="col-lg-6 text-lg-right">
                                <p class="small text-muted mb-0">Template designed by <a class="text-white reset-anchor" href="https://bootstraptemple.com/p/bootstrap-ecommerce">Bootstrap Temple</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- JavaScript files-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <script src="vendor/lightbox2/js/lightbox.min.js"></script>
            <script src="vendor/nouislider/nouislider.min.js"></script>
            <script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
            <script src="vendor/owl.carousel2/owl.carousel.min.js"></script>
            <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
            <script src="js/front.js"></script>
            <script>
                // ------------------------------------------------------- //
                //   Inject SVG Sprite - 
                //   see more here 
                //   https://css-tricks.com/ajaxing-svg-sprite/
                // ------------------------------------------------------ //
                function injectSvgSprite(path) {

                    var ajax = new XMLHttpRequest();
                    ajax.open("GET", path, true);
                    ajax.send();
                    ajax.onload = function (e) {
                        var div = document.createElement("div");
                        div.className = 'd-none';
                        div.innerHTML = ajax.responseText;
                        document.body.insertBefore(div, document.body.childNodes[0]);
                    }
                }
                // this is set to BootstrapTemple website as you cannot 
                // inject local SVG sprite (using only 'icons/orion-svg-sprite.svg' path)
                // while using file:// protocol
                // pls don't forget to change to your domain :)
                injectSvgSprite('https://bootstraptemple.com/files/icons/orion-svg-sprite.svg');

            </script>
            <!-- FontAwesome CSS - loading as last, so it doesn't block rendering-->
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        </div>
    </body>
</html>
