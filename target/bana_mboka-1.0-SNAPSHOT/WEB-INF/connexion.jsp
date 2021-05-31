<%-- 
    Document   : connexion
    Created on : 26 mai 2021, 13:29:32
    Author     : Ir Andy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/Assets/header.jsp"></c:import>
<main class="page login-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">CONNEXION</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo.</p>
            </div>
            <form method="POST" action="connexion">
                <div class="form-group"><label for="email">Email</label><input class="form-control item" type="email" id="email" name="email"></div>
                <div class="form-group"><label for="password">Mot de passe</label><input class="form-control" type="password" id="password" name="password"></div>
                <div class="form-group">
                    <div class="form-check"><input class="form-check-input" name="memoire" type="checkbox" id="checkbox"><label class="form-check-label" for="checkbox">Remember me</label></div>
                </div><button class="btn btn-primary btn-block" type="submit">Connexion</button></form>
                
        </div>
        <c:import url="/Assets/footer.jsp"></c:import>