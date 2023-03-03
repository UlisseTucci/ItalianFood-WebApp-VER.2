package informatica.unical.it.italianfood.persistance.jdbc;

import informatica.unical.it.italianfood.model.Ricetta;
import informatica.unical.it.italianfood.persistance.RicettaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RicettaDaoJDBC implements RicettaDao
{
    Connection connection;
    public RicettaDaoJDBC(Connection connection){this.connection=connection;}

    @Override
    public boolean inserisciRicetta(Ricetta ricetta) throws SQLException
    {
        if(connection==null || connection.isClosed())
            return false;

        PreparedStatement p=connection.prepareStatement("INSERT INTO ricetta VALUES(DEFAULT,?,?,?,?,?,?,?,?,?,?,?)");
        p.setString(1,ricetta.getEmailUtente());
        p.setString(2,ricetta.getNomeRicetta());
        p.setString(3,ricetta.getDescrizioneRicetta());
        p.setString(4,ricetta.getPreparazioneRicetta());
        p.setString(5,ricetta.getDataPubblicazione());
        p.setString(6, ricetta.getCategoria());
        p.setBoolean(7,false);
        if(ricetta.getThumbnail()!=null)
            p.setString(8,ricetta.getThumbnail());
        else
        {
            p.setString(8,ricetta.getDefaultImg());
            System.out.println(1);
        }
        p.setString(9,ricetta.getDifficolta());
        p.setString(10,ricetta.getIngredientiRicetta());
        p.setInt(11,ricetta.getCalorie());
        p.executeUpdate();
        return true;
    }

    @Override
    public ArrayList<Ricetta> cercaEPrelevaRicette(String parola) throws SQLException
    {
        ArrayList<Ricetta> ricette=new ArrayList<>();
        PreparedStatement p=connection.prepareStatement("SELECT* FROM ricetta");
        ResultSet r=p.executeQuery();

        while(r.next())
        {
            if(r.getString("nome").toLowerCase().contains(parola.toLowerCase()))
            {
                ricette.add(new Ricetta(r.getInt("id"),r.getString("email_utente"),r.getString("nome"),r.getString("descrizione"),r.getString("preparazione"),r.getString("data"),r.getString("categoria"),r.getBoolean("segnalata"),r.getString("immagine"),r.getString("difficolta"),r.getString("ingredienti"),r.getInt("calorie")));
            }
        }
        if(ricette.isEmpty())
            return null;
        return ricette;

    }

    @Override
    public Ricetta cercaEPrelevaRicetteById(int id) throws SQLException
    {
        PreparedStatement p=connection.prepareStatement("SELECT* FROM ricetta WHERE id=?");
        p.setInt(1,id);
        ResultSet r=p.executeQuery();
        Ricetta ricetta;
        if(r.next())
        {
            ricetta=new Ricetta(r.getInt("id"),r.getString("email_utente"),r.getString("nome"),r.getString("descrizione"),r.getString("preparazione"),r.getString("data"),r.getString("categoria"),r.getBoolean("segnalata"),r.getString("immagine"),r.getString("difficolta"),r.getString("ingredienti"),r.getInt("calorie"));
        }
        else
            return null;
        return ricetta;
    }

    @Override
    public ArrayList<Ricetta> cercaEPrelevaRicetteByEmail(String emailUtente) throws SQLException
    {
        ArrayList<Ricetta> ricette=new ArrayList<>();
        PreparedStatement p=connection.prepareStatement("SELECT * FROM ricetta WHERE email_utente=?");
        p.setString(1,emailUtente);
        ResultSet r=p.executeQuery();
        while(r.next())
        {
            ricette.add(new Ricetta(r.getInt("id"),emailUtente,r.getString("nome"),r.getString("descrizione"),null,null,null,r.getBoolean("segnalata"),r.getString("immagine"),null,null,0));
        }
        return ricette;
    }

    @Override
    public boolean eliminaById(int id) throws SQLException
    {
        if(connection.isClosed() ||connection==null)
            return false;

        PreparedStatement p=connection.prepareStatement("DELETE FROM ricetta WHERE id=?");
        p.setInt(1,id);
        p.executeUpdate();
        return true;
    }

    @Override
    public boolean inserisciORimuoviSegnalazione(int id,boolean inserisci) throws SQLException
    {
        if(connection.isClosed() ||connection==null)
            return false;

        if(inserisci)
        {
            PreparedStatement p=connection.prepareStatement("UPDATE ricetta SET segnalata=? WHERE id=?");
            p.setBoolean(1,true);
            p.setInt(2,id);
            p.executeUpdate();
        }
        else
        {
            PreparedStatement p=connection.prepareStatement("UPDATE ricetta SET segnalata=? WHERE id=?");
            p.setBoolean(1,false);
            p.setInt(2,id);
            p.executeUpdate();
        }
        return true;
    }

    @Override
    public ArrayList<Ricetta> recuperaSegnalazioni() throws SQLException
    {
        ArrayList<Ricetta> segnalazioni=new ArrayList<>();
        PreparedStatement p=connection.prepareStatement("SELECT* FROM ricetta WHERE segnalata=?");
        p.setBoolean(1,true);
        ResultSet r=p.executeQuery();
        while(r.next())
        {
            segnalazioni.add(new Ricetta(r.getInt("id"),r.getString("email_utente"),r.getString("nome"),r.getString("descrizione"),null,null,null,r.getBoolean("segnalata"),r.getString("immagine"),null,null,0));
        }
        return segnalazioni;
    }
}
