package informatica.unical.it.italianfood.controller;

import informatica.unical.it.italianfood.model.Prodotto;
import informatica.unical.it.italianfood.model.Ricetta;
import informatica.unical.it.italianfood.persistance.jdbc.DatabaseJDBC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class AdminController
{
    @PostMapping("/inviaProdotto")
    public void inviaProdotto(HttpServletResponse res, @RequestBody Prodotto prodotto) throws SQLException
    {
        if(DatabaseJDBC.getInstance().getProdottoDao().aggiungiProdotto(prodotto))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

    }
    @PostMapping("/segnalazioni")
    public ArrayList<Ricetta> segnalazioni(HttpServletResponse res) throws SQLException
    {
        ArrayList<Ricetta> segnalazioni= DatabaseJDBC.getInstance().getRicettaDao().recuperaSegnalazioni();
        if(segnalazioni.isEmpty())
        {
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            return null;
        }
        res.setStatus(HttpServletResponse.SC_OK);
        return segnalazioni;
    }
    @PostMapping("/rimuoviSegnalazione")
    public void rimuoviSegnalazione(HttpServletResponse res,@RequestBody int id) throws SQLException
    {
        if(DatabaseJDBC.getInstance().getRicettaDao().inserisciORimuoviSegnalazione(id,false))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    @PostMapping("/bannaUtente")
    public void bannUtente(HttpServletResponse res,@RequestBody String email) throws SQLException
    {
        email=email.replaceAll("\"","");
        if(DatabaseJDBC.getInstance().getUtenteDao().bannaUtente(email))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }
}
