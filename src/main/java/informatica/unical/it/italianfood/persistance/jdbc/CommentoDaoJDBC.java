package informatica.unical.it.italianfood.persistance.jdbc;

import informatica.unical.it.italianfood.model.Commento;
import informatica.unical.it.italianfood.persistance.CommentoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentoDaoJDBC implements CommentoDao
{
    Connection connection;
    public CommentoDaoJDBC(Connection connection){this.connection=connection;}

    @Override
    public boolean inserisciCommento(Commento commento) throws SQLException
    {
        if(connection.isClosed() || connection==null)
            return false;

        PreparedStatement p=connection.prepareStatement("INSERT INTO commento VALUES(?,?,?,?,DEFAULT)");
        p.setInt(1,commento.getIdRicetta());
        p.setString(2,commento.getEmailUtente());
        p.setString(3,commento.getContenuto());
        p.setString(4,commento.getDataPubblicazione());
        p.execute();

        return true;
    }

    @Override
    public ArrayList<Commento> caricaCommenti(int id) throws SQLException
    {
        ArrayList<Commento> commenti=new ArrayList<>();
        PreparedStatement p=connection.prepareStatement("SELECT* FROM commento WHERE id_ricetta=?");
        p.setInt(1,id);
        ResultSet r=p.executeQuery();
        while(r.next())
            commenti.add(new Commento(r.getInt("id_ricetta"),r.getString("email_utente"),r.getString("contenuto"),r.getString("data_pubblicazione"),r.getBoolean("segnalato")));
        return commenti;
    }
}
