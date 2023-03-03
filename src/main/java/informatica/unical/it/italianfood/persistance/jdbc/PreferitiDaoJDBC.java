package informatica.unical.it.italianfood.persistance.jdbc;

import informatica.unical.it.italianfood.persistance.PreferitiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreferitiDaoJDBC implements PreferitiDao
{
    Connection connection;
    public PreferitiDaoJDBC(Connection connection){this.connection=connection;}
    @Override
    public boolean aggiungiPreferiti(String email, int id) throws SQLException
    {
        if(connection.isClosed() || connection==null)
            return false;

        PreparedStatement p=connection.prepareStatement("INSERT INTO preferiti VALUES(?,?)");
        p.setString(1,email);
        p.setInt(2,id);
        p.execute();
        return true;
    }

    @Override
    public ArrayList<Integer> recuperaPreferiti(String email) throws SQLException
    {
        ArrayList<Integer> preferiti=new ArrayList<>();
        PreparedStatement p=connection.prepareStatement("SELECT* FROM preferiti WHERE emailutente=?");
        p.setString(1,email);
        ResultSet r=p.executeQuery();
        while(r.next())
            preferiti.add(r.getInt("idricetta"));

        return preferiti;
    }

    @Override
    public boolean rimuoviPreferito(String email, int id) throws SQLException
    {
        if(connection.isClosed() || connection==null)
            return false;

        PreparedStatement p=connection.prepareStatement("DELETE FROM preferiti WHERE emailutente=? AND idricetta=?");
        p.setString(1,email);
        p.setInt(2,id);
        p.execute();
        return true;
    }
}
