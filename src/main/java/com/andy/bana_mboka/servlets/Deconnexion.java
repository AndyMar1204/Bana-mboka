package com.andy.bana_mboka.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ir Andy
 */
@WebServlet(name = "Deconnexion", urlPatterns = {"/deconnexion"})
public class Deconnexion extends HttpServlet {

    public static final String URL_REDIRECTION = "accueil";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = req.getSession();
        session.invalidate();
        /* Redirection vers le Site du Zéro ! */
        resp.sendRedirect(URL_REDIRECTION);
    }

}
