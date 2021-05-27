package com.andy.bana_mboka.servlets;

import com.andy.bana_mboka.config.DaoInit;
import com.andy.bana_mboka.dao.UserDao;
import com.andy.bana_mboka.forms.UserForm;
import com.andy.bana_mboka.model.User;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author Ir Andy
 */
@WebServlet(name = "Connexion", urlPatterns = {"/connexion"})
public class Connexion extends HttpServlet {

    private static final String VUE = "/WEB-INF/connexion.jsp";
    public static final String ATT_USER = "user";
    private static final String SESSION_USER = "session_user";
    public static final String CHAMP_MEMOIRE = "memoire";
     public static final String COOKIE_USER = "cookie_user";
    private UserForm form = new UserForm();
    private Session session;
    private UserDao udao;
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User)req.getSession().getAttribute(ATT_USER);
        if(user!=null){
            resp.sendRedirect("accueil");
            return;
        }
        getServletContext().getRequestDispatcher(VUE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> identifier = form.identifierGetter(req);
        udao = new UserDao(session);

        if (form.getErreur().isEmpty()) {
            user = udao.connexion(identifier.get(UserForm.EMAIL), identifier.get(UserForm.PASSWORD));
           HttpSession session = req.getSession();
            if (user != null) {
                
                session.setAttribute(ATT_USER, user);
                if(req.getParameter(CHAMP_MEMOIRE)!=null){
                    setCookie(resp,COOKIE_USER,SESSION_USER,1);
                }
                
            }else{
            session.setAttribute(ATT_USER, null);
            }
            resp.getWriter().println(user);
            resp.sendRedirect("accueil");
        } else {
            resp.sendRedirect("accueil");
        }
    }

    @Override
    public void init() throws ServletException {
        session = (Session) this.getServletContext().getAttribute(DaoInit.ATT_DAO_FACTORY);
    }

    /**
     * Méthode utilitaire gérant la récupération de la valeur d'un cookie donné
     * depuis la requête HTTP.
     */
    private static String getCookieValue(HttpServletRequest request, String nom) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null && nom.equals(cookie.getName()
                )) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /*
* Méthode utilitaire gérant la création d'un cookie et son ajout à
la
* réponse HTTP.
     */
    private static void setCookie(HttpServletResponse response, String nom, String valeur, int maxAge) {
        Cookie cookie = new Cookie(nom, valeur);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
}
