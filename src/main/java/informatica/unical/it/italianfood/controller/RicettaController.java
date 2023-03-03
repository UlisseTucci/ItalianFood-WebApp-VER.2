package informatica.unical.it.italianfood.controller;

import informatica.unical.it.italianfood.model.Ricetta;
import informatica.unical.it.italianfood.model.Utente;
import informatica.unical.it.italianfood.persistance.jdbc.DatabaseJDBC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class RicettaController
{
    @PostMapping("/caricaRicetta")
    public Ricetta ric(HttpServletResponse res, @RequestBody int id) throws SQLException
    {
       Ricetta ricetta=DatabaseJDBC.getInstance().getRicettaDao().cercaEPrelevaRicetteById(id);
       res.setStatus(HttpServletResponse.SC_OK);
       return ricetta;
    }

    @PostMapping("/effettuaRicerca")
    public ArrayList<Ricetta> ricerca(HttpServletResponse res, @RequestBody String parola) throws SQLException
    {
        parola = parola.replaceAll("\"", "");
        ArrayList<Ricetta> ricette = DatabaseJDBC.getInstance().getRicettaDao().cercaEPrelevaRicette(parola);

        res.setStatus(HttpServletResponse.SC_OK);
        return ricette;
    }

    @PostMapping("/inviaRicetta")
    public void inviaRicetta(HttpServletResponse res, @RequestBody Ricetta ricetta) throws SQLException
    {
        if(DatabaseJDBC.getInstance().getRicettaDao().inserisciRicetta(ricetta))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

    }

    @PostMapping("/cercaRicetteEmail")
    public ArrayList<Ricetta> cercaRicetteEmail(HttpServletResponse res, HttpServletRequest req) throws SQLException
    {
        ArrayList<Ricetta> ricette;
        Utente u=(Utente)req.getSession().getAttribute("utente");
        ricette=DatabaseJDBC.getInstance().getRicettaDao().cercaEPrelevaRicetteByEmail(u.getEmail());

        if(ricette.isEmpty())
        {
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            return null;
        }
        res.setStatus(HttpServletResponse.SC_OK);
        return ricette;
    }

    @PostMapping("eliminaById")
    public void eliminaById(HttpServletResponse res,@RequestBody int id) throws SQLException
    {
        if(DatabaseJDBC.getInstance().getRicettaDao().eliminaById(id))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    @PostMapping("/segnalaRicetta")
    public void segnalaRicetta(HttpServletResponse res,@RequestBody int id) throws SQLException
    {
        if(DatabaseJDBC.getInstance().getRicettaDao().inserisciORimuoviSegnalazione(id,true))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }
}
