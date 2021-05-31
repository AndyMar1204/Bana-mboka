<%-- Document : inscription Created on : 15 mai 2021, 15:40:40 Author : Ir Andy --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/Assets/header.jsp"></c:import>
    <main class="page registration-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Enregistrez vous ici</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urn
                    a, dignissim nec auctor in, mattis vitae leo.</p>
                </div>
                <form action="user" method="post">
                    <div class="form-group"><label for="username">Nom d'utilisateur : </label> <input class="form-control item" type="text" name="username" id="username" minlength="3" required> </div>
                    <div class="form-group"><label for="email">E-Mail :</label><input class="form-control item" type="email" name="email" id="email" required></div>
                     <div class="form-group"><label for="telephone">Telephone :</label><span>+243</span><input class="form-control item" type="tel" name="telephone" id="telephone" maxlength="9" minlength="9" required></div>
                    <div class="form-group"><label for="password">Mot de passe :</label><input class="form-control item" type="password" name="password" id="" required></div>
                    <div class="form-group"><label for="confirm">Retapez mot de passe :</label> <input class="form-control item" type="password" name="confirm" id="confirm" required>
                    </div>
                    <div><input type="submit" value="Enregistrer"></div>
                </form>
            </div>
        <c:import url="/Assets/footer.jsp"></c:import>