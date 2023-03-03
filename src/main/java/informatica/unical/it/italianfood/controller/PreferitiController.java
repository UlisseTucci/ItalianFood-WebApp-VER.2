package informatica.unical.it.italianfood.controller;

import informatica.unical.it.italianfood.model.Utente;
import informatica.unical.it.italianfood.persistance.jdbc.DatabaseJDBC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class PreferitiController
{
    @PostMapping("/aggiungiPreferiti")
    public void aggiungiPreferiti(HttpServletRequest req, HttpServletResponse res, @RequestBody int id) throws SQLException
    {
        Utente u=(Utente)req.getSession().getAttribute("utente");
        if(DatabaseJDBC.getInstance().getPreferitiDao().aggiungiPreferiti(u.getEmail(),id))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    @PostMapping("/recuperaPreferiti")
    public ArrayList<Integer> recuperaPreferiti(HttpServletRequest req, HttpServletResponse res) throws SQLException
    {
        ArrayList<Integer> preferiti;
        Utente u=(Utente)req.getSession().getAttribute("utente");
        preferiti=DatabaseJDBC.getInstance().getPreferitiDao().recuperaPreferiti(u.getEmail());
        if(preferiti.isEmpty())
        {
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            return null;
        }
        res.setStatus(HttpServletResponse.SC_OK);
        return preferiti;
    }
    @PostMapping("/rimuoviPreferito")
    public void rimuoviPreferito(HttpServletResponse res,HttpServletRequest req,@RequestBody int id) throws SQLException
    {
        Utente u=(Utente)req.getSession().getAttribute("utente");
        if(DatabaseJDBC.getInstance().getPreferitiDao().rimuoviPreferito(u.getEmail(),id))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }
}
