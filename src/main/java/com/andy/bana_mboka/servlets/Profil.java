package com.andy.bana_mboka.servlets;

import com.andy.bana_mboka.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ir Andy
 */


@WebServlet(name = "Profil", urlPatterns = {"/profil"})
public class Profil extends HttpServlet {
    private static final String VUE = "/WEB-INF/profil.jsp";
    private User user;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User)req.getSession().getAttribute(Connexion.ATT_USER);
        if(user==null){
            resp.sendRedirect("accueil");
            return;
        }
        this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
    }
    
}
