<%--
  Created by IntelliJ IDEA.
  User: Crist
  Date: 8/25/2020
  Time: 2:21 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>
        <g:layoutTitle default="Bueno Service"/>
    </title>
<asset:stylesheet src="mybootstrap.min.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">

    <asset:stylesheet src="styles.min.css"/>
    <g:layoutHead/>
</head>
<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="/">Bueno's Service</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="/">Inicio</a></li>

                <li class="nav-item" role="presentation"><a class="nav-link" href="/evento">Eventos</a></li>
                <g:if test="${session["infoUsuario"] != null}">
                    <g:if test="${session["infoUsuario"].rol == "ROLE_ADMIN"}">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="/usuario">Usuarios</a></li>
                    </g:if>
                    <g:if test="${session["infoUsuario"].rol == "ROLE_ADMIN"}">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="/estadistica">Estadistica</a></li>
                    </g:if>
                    <g:elseif test="${session["infoUsuario"].rol == "ROLE_CLIENTE"}">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="/evento/mispedidos">Mis Pedidos</a></li>
                    </g:elseif>
                    <g:else>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="/evento/pedidosempleado">Pedidos</a></li>
                    </g:else>
                    <li class="nav-item" role="presentation"><g:link class="nav-link" controller="login" action="logout">Salir</g:link></li>
                </g:if>
                <g:else>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="/login">Acceder</a></li>
                </g:else>
            </ul>
        </div>
    </div>
</nav>

<!--body-->
<g:layoutBody/>


<footer class="page-footer dark">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <h5>Get started</h5>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Sign up</a></li>
                    <li><a href="#">Downloads</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
                <h5>About us</h5>
                <ul>
                    <li><a href="#">Company Information</a></li>
                    <li><a href="#">Contact us</a></li>
                    <li><a href="#">Reviews</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
                <h5>Support</h5>
                <ul>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">Help desk</a></li>
                    <li><a href="#">Forums</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
                <h5>Legal</h5>
                <ul>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Terms of Use</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <p>© 2020 Copyright Text</p>
    </div>
</footer>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="assets/js/script.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.bundle.min.js"></script>
</body>

</html>