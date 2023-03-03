function Prodotto(nomeProdotto,disponibilita,scadenza,prezzo,immagine)
{
    this.nomeProdotto=nomeProdotto;
    this.disponibilita=disponibilita;
    this.scadenza=scadenza;
    this.prezzo=prezzo;
    this.immagine=immagine;
}

let im="";
function getBase64()
{
    const file = document.querySelector('#selezionaImmagine').files[0];
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
        im=reader.result;
        document.querySelector('#showImage').src=im;
    };
}

function aggiungiProdotto()
{
    var nome=$("#nomeProdotto").val();
    var disponibilita=$("#disponibilita").val();
    var scadenza=$("#scadenza").val();
    var prezzo=$("#prezzo").val();

    var prodotto=new Prodotto(nome,disponibilita,scadenza,prezzo,im);
    $.ajax(
        {
            type:"POST",
            url:"/inviaProdotto",
            contentType: "application/json",
            data: JSON.stringify(prodotto),
            success:function ()
            {
                alert("Il prodotto è stato aggiunto con successo!");
            }
        })
}