package com.andy.bana_mboka.forms;

import com.andy.bana_mboka.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Ir Andy
 */
public class UserForm {

    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String CONFIRM = "confirm";
    public static final String TELEPHONE = "telephone";

    private Map<String, String> erreur = new HashMap();

    public Map<String, String> getErreur() {
        return erreur;
    }

    public void addError(String key, String value) {
        erreur.put(key, value);
    }

    public Map<String, String> identifierGetter(HttpServletRequest req) {
        Map<String, String> identifier = new HashMap();
        String email = valueGetter(req, EMAIL);
        String password = valueGetter(req, PASSWORD);
        try {
            validationEmail(email);
            identifier.put(EMAIL, email);
        } catch (FormException ex) {
            addError(EMAIL, ex.getMessage());
        }
        password = passwordHasher(password);
        identifier.put(PASSWORD, password);
        return identifier;
    }

    public User userGetter(HttpServletRequest req) {
        User user = new User();
        String username = valueGetter(req, USERNAME);
        String email = valueGetter(req, EMAIL);
        String password = valueGetter(req, PASSWORD);
        String confirm = valueGetter(req, CONFIRM);
        String telephone = valueGetter(req,TELEPHONE);
        try {
            validationUsername(username);
            user.setUsername(username);
        } catch (FormException e) {
            addError(USERNAME, e.getMessage());
        }
        try {
            validationEmail(email);
            user.setEmail(email);
        } catch (FormException f) {
            addError(EMAIL, f.getMessage());
        }
        try {
            validationMotsDePasse(password, confirm);
            password = passwordHasher(password);
            user.setPassword(password);
        } catch (FormException f) {
            addError(PASSWORD, f.getMessage());
        }
        try {
            validationPhone(telephone);
            user.setTelephone(telephone);
        } catch (FormException ex) {
            addError(TELEPHONE,ex.getMessage());
        }
        return user;
    }

    static String valueGetter(HttpServletRequest req, String field) {
        String value = req.getParameter(field).trim();
        return value;
    }

    static void validationUsername(String username) throws FormException {
        if (username != null && username.trim().length() < 3) {
            throw new FormException("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

    /**
     * Valide les mots de passe saisis.
     */
    static void validationMotsDePasse(String motDePasse, String confirmation) throws FormException {
        if (motDePasse != null && motDePasse.trim().length() != 0
                && confirmation != null && confirmation.trim().length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                throw new FormException("Les mots de passe entrés sont différents , merci de les saisir à nouveau.");
            } else if (motDePasse.trim().length() < 3) {
                throw new FormException("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new FormException("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    /**
     * Valide l'adresse mail saisie.
     */
    static void validationEmail(String email) throws FormException {
        if (email != null && email.trim().length() != 0) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new FormException("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new FormException("Merci de saisir une adresse mail.");
        }
    }

    static void validationPhone(String phone) throws FormException {
        if (phone != null && phone.trim().length() != 0) {
            if (!phone.matches("\\d{9}")) {
                throw new FormException("Merci de saisir un numero  valide.");
            }
        }else {
            throw new FormException("Merci de saisir une numero mail.");
        }
    }

    static String passwordHasher(String password) {
        if (password != null && password.trim().length() != 0) {
            String sha256hex = DigestUtils.sha256Hex(password);
            return sha256hex;
        } else {
            return null;
        }
    }
}
