
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Best Phone Store</title>
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

            <!--HERO SECTION-->
            <div class="container">
                <section class="hero pb-3 bg-cover bg-center d-flex align-items-center" style="background: url(img/banner.jpg)">
                    <div class="container py-5">
                        <div class="row px-4 px-lg-5">
                            <div class="col-lg-6">
                                <p class="text-muted small text-uppercase mb-2">New Technology 2021</p>
                                <h1 class="h2 text-uppercase mw-3">Special discount for new user</h1><a class="btn btn-dark" href="ShopController">Get one</a>
                            </div>
                        </div>
                    </div>
                </section>
                <!--CATEGORIES SECTION-->
                <section class="pt-5">
                    <header class="text-center">
                        <p class="small text-muted small text-uppercase mb-1">diversified Product Models</p>
                        <h2 class="h5 text-uppercase mb-4">With free Shipping</h2>
                    </header>
                    <div class="row">
                        <div class="col-md-4 mb-4 mb-md-0"><a class="category-item" href="MainController?action=ProductByCate&categoryID=IP"><img class="img-fluid" src="img/iphone-cat.jpg" alt=""><strong class="category-item-title">IPhone</strong></a></div>
                        <div class="col-md-4 mb-4 mb-md-0"><a class="category-item mb-4" href="MainController?action=ProductByCate&categoryID=NK"><img class="img-fluid" src="img/nokia-cat.jpg" alt=""><strong class="category-item-title">Nokia</strong></a><a class="category-item" href="MainController?action=ProductByCate&categoryID=MI"><img class="img-fluid" src="img/xiaomi-cat.jpg" alt=""><strong class="category-item-title">Xiaomi</strong></a></div>
                        <div class="col-md-4"><a class="category-item" href="MainController?action=ProductByCate&categoryID=SS"><img class="img-fluid" src="img/samsung-cat.jpg" alt=""><strong class="category-item-title">Samsung</strong></a></div>
                    </div>
                </section>
                <!--                 TRENDING PRODUCTS
                                <section class="py-5">
                                    <header>
                                        <p class="small text-muted small text-uppercase mb-1">The best technology with the best price</p>
                                        <h2 class="h5 text-uppercase mb-4">Best Offer</h2>
                                    </header>
                                    <div class="row">
                                         PRODUCT
                                        <div class="col-xl-3 col-lg-4 col-sm-6">
                                            <div class="product text-center">
                                                <div class="position-relative mb-3">
                                                    <div class="badge text-white badge-"></div><a class="d-block" href="detail.jsp"><img class="img-fluid w-100" src="img/product-1.jpg" alt="..."></a>
                                                    <div class="product-overlay">
                                                        <ul class="mb-0 list-inline">
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#"><i class="far fa-heart"></i></a></li>
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="cart.jsp">Add to cart</a></li>
                                                            <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-toggle="modal"><i class="fas fa-expand"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <h6> <a class="reset-anchor" href="detail.jsp">Kui Ye Chen’s AirPods</a></h6>
                                                <p class="small text-muted">$250</p>
                                            </div>
                                        </div>
                                         PRODUCT
                                        <div class="col-xl-3 col-lg-4 col-sm-6">
                                            <div class="product text-center">
                                                <div class="position-relative mb-3">
                                                    <div class="badge text-white badge-primary">Sale</div><a class="d-block" href="detail.jsp"><img class="img-fluid w-100" src="img/product-2.jpg" alt="..."></a>
                                                    <div class="product-overlay">
                                                        <ul class="mb-0 list-inline">
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#"><i class="far fa-heart"></i></a></li>
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="cart.jsp">Add to cart</a></li>
                                                            <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-toggle="modal"><i class="fas fa-expand"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <h6> <a class="reset-anchor" href="detail.jsp">Air Jordan 12 gym red</a></h6>
                                                <p class="small text-muted">$300</p>
                                            </div>
                                        </div>
                                         PRODUCT
                                        <div class="col-xl-3 col-lg-4 col-sm-6">
                                            <div class="product text-center">
                                                <div class="position-relative mb-3">
                                                    <div class="badge text-white badge-"></div><a class="d-block" href="detail.jsp"><img class="img-fluid w-100" src="img/product-3.jpg" alt="..."></a>
                                                    <div class="product-overlay">
                                                        <ul class="mb-0 list-inline">
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#"><i class="far fa-heart"></i></a></li>
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="cart.jsp">Add to cart</a></li>
                                                            <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-toggle="modal"><i class="fas fa-expand"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <h6> <a class="reset-anchor" href="detail.jsp">Cyan cotton t-shirt</a></h6>
                                                <p class="small text-muted">$25</p>
                                            </div>
                                        </div>
                                         PRODUCT
                                        <div class="col-xl-3 col-lg-4 col-sm-6">
                                            <div class="product text-center">
                                                <div class="position-relative mb-3">
                                                    <div class="badge text-white badge-info">New</div><a class="d-block" href="detail.jsp"><img class="img-fluid w-100" src="img/product-4.jpg" alt="..."></a>
                                                    <div class="product-overlay">
                                                        <ul class="mb-0 list-inline">
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#"><i class="far fa-heart"></i></a></li>
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="cart.jsp">Add to cart</a></li>
                                                            <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-toggle="modal"><i class="fas fa-expand"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <h6> <a class="reset-anchor" href="detail.jsp">Timex Unisex Originals</a></h6>
                                                <p class="small text-muted">$351</p>
                                            </div>
                                        </div>
                                         PRODUCT
                                        <div class="col-xl-3 col-lg-4 col-sm-6">
                                            <div class="product text-center">
                                                <div class="position-relative mb-3">
                                                    <div class="badge text-white badge-danger">Sold</div><a class="d-block" href="detail.jsp"><img class="img-fluid w-100" src="img/product-5.jpg" alt="..."></a>
                                                    <div class="product-overlay">
                                                        <ul class="mb-0 list-inline">
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#"><i class="far fa-heart"></i></a></li>
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="cart.jsp">Add to cart</a></li>
                                                            <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-toggle="modal"><i class="fas fa-expand"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <h6> <a class="reset-anchor" href="detail.jsp">Red digital smartwatch</a></h6>
                                                <p class="small text-muted">$250</p>
                                            </div>
                                        </div>
                                         PRODUCT
                                        <div class="col-xl-3 col-lg-4 col-sm-6">
                                            <div class="product text-center">
                                                <div class="position-relative mb-3">
                                                    <div class="badge text-white badge-"></div><a class="d-block" href="detail.jsp"><img class="img-fluid w-100" src="img/product-6.jpg" alt="..."></a>
                                                    <div class="product-overlay">
                                                        <ul class="mb-0 list-inline">
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#"><i class="far fa-heart"></i></a></li>
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="cart.jsp">Add to cart</a></li>
                                                            <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-toggle="modal"><i class="fas fa-expand"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <h6> <a class="reset-anchor" href="detail.jsp">Nike air max 95</a></h6>
                                                <p class="small text-muted">$300</p>
                                            </div>
                                        </div>
                                         PRODUCT
                                        <div class="col-xl-3 col-lg-4 col-sm-6">
                                            <div class="product text-center">
                                                <div class="position-relative mb-3">
                                                    <div class="badge text-white badge-"></div><a class="d-block" href="detail.jsp"><img class="img-fluid w-100" src="img/product-7.jpg" alt="..."></a>
                                                    <div class="product-overlay">
                                                        <ul class="mb-0 list-inline">
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#"><i class="far fa-heart"></i></a></li>
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="cart.jsp">Add to cart</a></li>
                                                            <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-toggle="modal"><i class="fas fa-expand"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <h6> <a class="reset-anchor" href="detail.jsp">Joemalone Women prefume</a></h6>
                                                <p class="small text-muted">$25</p>
                                            </div>
                                        </div>
                                         PRODUCT
                                        <div class="col-xl-3 col-lg-4 col-sm-6">
                                            <div class="product text-center">
                                                <div class="position-relative mb-3">
                                                    <div class="badge text-white badge-"></div><a class="d-block" href="detail.jsp"><img class="img-fluid w-100" src="img/product-8.jpg" alt="..."></a>
                                                    <div class="product-overlay">
                                                        <ul class="mb-0 list-inline">
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-outline-dark" href="#"><i class="far fa-heart"></i></a></li>
                                                            <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="cart.jsp">Add to cart</a></li>
                                                            <li class="list-inline-item mr-0"><a class="btn btn-sm btn-outline-dark" href="#productView" data-toggle="modal"><i class="fas fa-expand"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <h6> <a class="reset-anchor" href="detail.jsp">Apple Watch</a></h6>
                                                <p class="small text-muted">$351</p>
                                            </div>
                                        </div>
                                    </div>
                                </section>-->
                <!-- SERVICES-->
                <section class="py-5 bg-light">
                    <div class="container">
                        <div class="row text-center">
                            <div class="col-lg-4 mb-3 mb-lg-0">
                                <div class="d-inline-block">
                                    <div class="media align-items-end">
                                        <svg class="svg-icon svg-icon-big svg-icon-light">
                                        <use xlink:href="#delivery-time-1"> </use>
                                        </svg>
                                        <div class="media-body text-left ml-3">
                                            <h6 class="text-uppercase mb-1">Free shipping</h6>
                                            <p class="text-small mb-0 text-muted">Free shipping worlwide</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 mb-3 mb-lg-0">
                                <div class="d-inline-block">
                                    <div class="media align-items-end">
                                        <svg class="svg-icon svg-icon-big svg-icon-light">
                                        <use xlink:href="#helpline-24h-1"> </use>
                                        </svg>
                                        <div class="media-body text-left ml-3">
                                            <h6 class="text-uppercase mb-1">24 x 7 service</h6>
                                            <p class="text-small mb-0 text-muted">Free shipping worlwide</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="d-inline-block">
                                    <div class="media align-items-end">
                                        <svg class="svg-icon svg-icon-big svg-icon-light">
                                        <use xlink:href="#label-tag-1"> </use>
                                        </svg>
                                        <div class="media-body text-left ml-3">
                                            <h6 class="text-uppercase mb-1">Festival offer</h6>
                                            <p class="text-small mb-0 text-muted">Free shipping worlwide</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- NEWSLETTER-->
                <!--                <section class="py-5">
                                    <div class="container p-0">
                                        <div class="row">
                                            <div class="col-lg-6 mb-3 mb-lg-0">
                                                <h5 class="text-uppercase">Let's be friends!</h5>
                                                <p class="text-small text-muted mb-0">Nisi nisi tempor consequat laboris nisi.</p>
                                            </div>
                                            <div class="col-lg-6">
                                                <form action="#">
                                                    <div class="input-group flex-column flex-sm-row mb-3">
                                                        <input class="form-control form-control-lg py-3" type="email" placeholder="Enter your email address" aria-describedby="button-addon2">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-dark btn-block" id="button-addon2" type="submit">Subscribe</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </section>-->
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
