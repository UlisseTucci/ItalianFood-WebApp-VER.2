package informatica.unical.it.italianfood.model;

public class Carrello
{
    private String nomeProdotto="";
    private int quantita=0;


    public Carrello(String nomeProdotto,int quantita)
    {
        this.nomeProdotto=nomeProdotto;
        this.quantita=quantita;
    }

    public String getNomeProdotto()
    {
        return nomeProdotto;
    }
    public int getQuantita()
    {
        return quantita;
    }

}
