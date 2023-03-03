function caricaPreferiti()
{
    $.ajax(
        {
            type:"POST",
            url:"/recuperaPreferiti",
            success:function(preferiti)
            {
                console.log(1);
                var index=0;
                while(index!==preferiti.length)
                {
                    $.ajax(
                        {
                            type:"POST",
                            url:"/caricaRicetta",
                            contentType: "application/json",
                            data: JSON.stringify(preferiti[index++]),
                            success:function(ricetta)
                            {
                                document.getElementById("inserisciQuiPreferiti").append(creaCardPreferiti(ricetta))
                            }
                        })
                }
            },
            error:function ()
            {
                var tex=document.createElement("div");
                tex.innerHTML="<h4 style='text-align: center'>Non hai nessuna ricetta nei preferiti...</h4>"
                document.getElementById("inserisciQuiPreferiti").before(tex);
            }
        })
}

function creaCardPreferiti(ricetta)
{
    var card=document.createElement("div");
    card.className="col-sm";
    card.innerHTML= "<div class=\"card\" style=\"max-width:350px\">\n" +
        "                <img class=\"card-img-top\" src='"+ricetta.thumbnail+"' alt=\"Card image cap\">\n" +
        "                <div class=\"card-body\">\n" +
        "                    <h5 style='text-align: center' class=\"card-title\">"+ricetta.nomeRicetta+"</h5>\n" +
        "                    <a href='http://localhost:8081/visualizza?id="+ricetta.id+"' class=\"btn btn-primary\">Visualizza</a>\n" +
        "                    <button style='margin-top: 10px' onclick='rimuoviPreferito("+ricetta.id+")' class=\"btn btn-outline-danger\">Rimuovi dai preferiti</button>\n" +
        "                </div>\n" +
        "            </div>";
    return card;
}

function rimuoviPreferito(id)
{
    $.ajax(
        {
            type:"POST",
            url:"/rimuoviPreferito",
            contentType: "application/json",
            data: JSON.stringify(id),
            success:function ()
            {
                alert("Ricetta rimossa con successo!");
                window.location.href="http://localhost:8081/preferiti";
            }
        })
}