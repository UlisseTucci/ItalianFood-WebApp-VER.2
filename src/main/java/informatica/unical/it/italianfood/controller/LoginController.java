package informatica.unical.it.italianfood.controller;

import informatica.unical.it.italianfood.model.Utente;
import informatica.unical.it.italianfood.persistance.jdbc.DatabaseJDBC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController
{
    @PostMapping("/doLogin")
    public void accedi(HttpServletRequest req, HttpServletResponse res, @RequestBody Utente utente) throws SQLException
    {
        Utente u=DatabaseJDBC.getInstance().getUtenteDao().Login(utente.getEmail(),utente.getPassword());
        if(u!=null && !u.isBannato())
        {
            HttpSession session = req.getSession(true);
            session.setAttribute("utente",u);
            res.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
        }
    }

}
