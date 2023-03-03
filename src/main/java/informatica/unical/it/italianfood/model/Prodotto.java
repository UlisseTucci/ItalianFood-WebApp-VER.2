package informatica.unical.it.italianfood.model;

public class Prodotto
{
    private String nomeProdotto="";
    private int disponibilita=0;
    private String scadenza="";
    private double prezzo=0;
    private String immagine="";

    public Prodotto(String nomeProdotto,int disponibilita,String scadenza,double prezzo,String immagine)
    {
        this.nomeProdotto=nomeProdotto;
        this.disponibilita=disponibilita;
        this.scadenza=scadenza;
        this.prezzo=prezzo;
        this.immagine=immagine;
    }

    public String getNomeProdotto()
    {
        return nomeProdotto;
    }

    public int getDisponibilita()
    {
        return  disponibilita;
    }

    public String getScadenza()
    {
        return scadenza;
    }

    public double getPrezzo()
    {
        return prezzo;
    }
    public String getImmagine()
    {
        return immagine;
    }
}
