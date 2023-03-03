package informatica.unical.it.italianfood.persistance;

import informatica.unical.it.italianfood.model.Commento;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CommentoDao
{
    public boolean inserisciCommento(Commento commento) throws SQLException;
    public ArrayList<Commento> caricaCommenti(int id) throws SQLException;
}
