<%-- 
    Document   : header
    Created on : 15 mai 2021, 15:55:39
    Author     : Ir Andy
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title> Bana - Mboka</title>
        <meta name="description" content="Nous servons vos ....">
        <link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <link rel="stylesheet" href="Assets/fonts/simple-line-icons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" href="Assets/css/smoothproducts.css">
    </head>
    <body>
        <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
            <div class="container"><a class="navbar-brand logo" href="#">Bana - Mboka</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse"
                     id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link active" href="accueil">Accueil</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="service-page.html">Services</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="features.html">Tarification</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="pricing.html">Reservation</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="about-us.html">A propos de nous</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="contact-us.html">Nous contacter</a></li>
                            <c:if test="${!empty sessionScope.user}">
                                <c:set var="usr" value="${  sessionScope.user}" scope="session" ></c:set>
                            </c:if>

                        <c:choose>
                            <c:when test="${user!=null}">
                                <li class="nav-item" role="presentation"><a class="nav-link" href="profil">Profil <span><c:out value="${user.username}" ></c:out></span></a></li>
                                <li class="nav-item" role="presentation"><a class="nav-link" href="deconnexion">Deconnexion</a></li>
                                </c:when>
                                <c:otherwise>
                                <li class="nav-item" role="presentation"><a class="nav-link" href="connexion">Connexion</a></li>
                                <li class="nav-item" role="presentation"><a class="nav-link" href="inscription">Inscription</a></li>
                                </c:otherwise>
                            </c:choose>

                    </ul>
                </div>
            </div>
        </nav>


