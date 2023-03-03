package informatica.unical.it.italianfood.controller;

import informatica.unical.it.italianfood.model.Prodotto;
import informatica.unical.it.italianfood.persistance.jdbc.DatabaseJDBC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class ProdottoController
{
    @PostMapping("/recuperaProdotti")
    public ArrayList<Prodotto> recuperaProdotti(HttpServletResponse res) throws SQLException
    {
        ArrayList<Prodotto> prodotti=DatabaseJDBC.getInstance().getProdottoDao().recuperaProdotti();
        if(prodotti==null)
        {
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            return null;
        }
        res.setStatus(HttpServletResponse.SC_OK);
        return prodotti;
    }

    @PostMapping("/caricaProdotto")
    public Prodotto caricaProdotto(HttpServletResponse res,@RequestBody String nomeProdotto) throws SQLException
    {
        nomeProdotto=nomeProdotto.replaceAll("\"","");
        Prodotto p=DatabaseJDBC.getInstance().getProdottoDao().caricaProdotto(nomeProdotto);
        if(p!=null)
            res.setStatus(HttpServletResponse.SC_OK);
        else
            res.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

        return p;
    }
}
