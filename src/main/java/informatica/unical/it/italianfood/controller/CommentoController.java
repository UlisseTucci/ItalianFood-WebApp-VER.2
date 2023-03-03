package informatica.unical.it.italianfood.controller;

import com.sun.tools.jconsole.JConsoleContext;
import informatica.unical.it.italianfood.model.Commento;
import informatica.unical.it.italianfood.model.Utente;
import informatica.unical.it.italianfood.persistance.jdbc.DatabaseJDBC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class CommentoController
{
    @PostMapping("/inviaCommento")
    public void inviaCommento(HttpServletResponse res, HttpServletRequest req, @RequestBody Commento commento) throws SQLException
    {
        Utente u=(Utente)req.getSession().getAttribute("utente");
        commento.setEmailUtente(u.getEmail());
        if(DatabaseJDBC.getInstance().getCommentoDao().inserisciCommento(commento))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    @PostMapping("/caricaCommenti")
    public ArrayList<Commento> caricaCommenti(HttpServletResponse res,@RequestBody int id) throws SQLException
    {
        ArrayList<Commento> commenti=DatabaseJDBC.getInstance().getCommentoDao().caricaCommenti(id);
        if(!commenti.isEmpty())
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
        return commenti;
    }
}
