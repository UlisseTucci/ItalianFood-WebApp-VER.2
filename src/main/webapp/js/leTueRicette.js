function cercaECarica()
{
    $.ajax(
        {
            type:"POST",
            url:"/cercaRicetteEmail",
            success:function (ricette)
            {
                var index=0;
                while(index!==ricette.length)
                {
                    $("#inserisciQui").append(creaCard(ricette[index++]));
                }
            }
        })
}

function creaCard(ricetta)
{
    var card=document.createElement("div");
    card.className="row_grid_item";
    card.innerHTML= "<div class=\"card\" style=\"max-width:350px\">\n" +
        "                <img class=\"card-img-top\" src='"+ricetta.thumbnail+"' alt=\"Card image cap\">\n" +
        "                <div class=\"card-body\">\n" +
        "                    <h5 style='text-align: center' class=\"card-title\">"+ricetta.nomeRicetta+"</h5>\n" +
        "                    <a href='http://localhost:8081/visualizza?id="+ricetta.id+"' class=\"btn btn-primary\">Apri</a>\n" +
        "                    <button onclick='elimina("+ricetta.id+")'  class=\"btn btn-outline-danger\">Elimina</button>\n" +
        "                </div>\n" +
        "            </div>";
    return card;
}

function elimina(id)
{
    if(confirm("Sei sicuro di voler eliminare la ricetta?"))
    {
        $.ajax(
            {
                type:"POST",
                url:"/eliminaById",
                contentType: "application/json",
                data: JSON.stringify(id),
                success:function ()
                {
                    window.location.href="http://localhost:8081/leTueRicette";
                }
            })
    }
}