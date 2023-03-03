function caricaRicetteSegnalate()
{
    $.ajax(
        {
            type:"POST",
            url:"/segnalazioni",
            success:function (ricette)
            {
                var index=0;
                while(index!==ricette.length)
                {
                    $("#inserisciSegnalazioniQui").append(creaCardSegnalazione(ricette[index++]));
                }
            }
        })
}

function creaCardSegnalazione(ricetta)
{
    var card=document.createElement("div");
    card.className="row_grid_item";
    card.innerHTML= "<div class=\"card\">\n" +
        "                <img class=\"card-img-top\" src='"+ricetta.thumbnail+"' alt=\"Card image cap\">\n" +
        "                <div style='display:flex;flex-direction: column' class=\"card-body\">\n" +
        "                    <h5 style='text-align: center' class=\"card-title\">"+ricetta.nomeRicetta+"</h5>\n" +
        "                    <div style='margin-top: 20px'>\n"+
        "                    <a href='http://localhost:8081/visualizza?id="+ricetta.id+"' class=\"btn btn-primary\">Visualizza</a>\n" +
        "                    <button onclick='eliminaRicetta("+ricetta.id+")' class=\"btn btn-outline-danger\">Elimina</button>\n" +
        "                    </div>\n"+
        "                    <div>\n"+
        "                    <button onclick='eliminaSegnalazione("+ricetta.id+")' style='margin-top: 5px;text-align: center'  class=\"btn btn-outline-danger\">Rimuovi segnalazione</button>\n" +
        "                    </div>\n"+
        "                    <div>\n"+
        "                    <button onclick='bannaUtente("+"\""+ricetta.emailUtente+"\""+")' style='margin-top: 5px;text-align: center'  class=\"btn btn-outline-danger\">Banna"+" "+ricetta.emailUtente+"</button>\n" +
        "                    </div>\n"+
        "                </div>\n" +
        "            </div>";
    return card;
}
function eliminaRicetta(id)
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
                    alert("Ricetta eliminata con successo!");
                    window.location.href="http://localhost:8081/segnalazioni";
                }
            })
    }
}

function eliminaSegnalazione(id)
{
    $.ajax({
        type:"POST",
        url:"/rimuoviSegnalazione",
        contentType: "application/json",
        data: JSON.stringify(id),
        success:function ()
        {
            alert("Segnalazione eliminata con successo!");
            window.location.href="http://localhost:8081/segnalazioni";
        }
    })
}

function bannaUtente(email)
{
    $.ajax(
        {
            type:"POST",
            url:"/bannaUtente",
            contentType: "application/json",
            data: JSON.stringify(email),
            success:function ()
            {
                alert("L'utente è stato bannato con successo!");
            }
        })
}