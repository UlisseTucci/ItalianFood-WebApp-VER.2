package informatica.unical.it.italianfood.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PreferitiDao
{
    public boolean aggiungiPreferiti(String email,int id) throws SQLException;
    public ArrayList<Integer> recuperaPreferiti(String email) throws  SQLException;
    public boolean rimuoviPreferito(String email,int id) throws SQLException;
}
