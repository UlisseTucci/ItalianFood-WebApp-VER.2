package informatica.unical.it.italianfood.model;

public class Commento
{
    private int idRicetta=0;
    private String emailUtente="";
    private String contenuto="";
    private String dataPubblicazione="";
    private boolean segnalato=false;

    public Commento(int idRicetta,String emailUtente,String contenuto,String dataPubblicazione,boolean segnalato)
    {
        this.idRicetta=idRicetta;
        this.emailUtente=emailUtente;
        this.contenuto=contenuto;
        this.dataPubblicazione=dataPubblicazione;
        this.segnalato=segnalato;
    }

    public int getIdRicetta()
    {
        return idRicetta;
    }
    public String getEmailUtente()
    {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente)
    {
        this.emailUtente=emailUtente;
    }

    public String getContenuto()
    {
        return  contenuto;
    }
    public String getDataPubblicazione()
    {
        return dataPubblicazione;
    }
    public boolean isSegnalato()
    {
        return segnalato;
    }
}
