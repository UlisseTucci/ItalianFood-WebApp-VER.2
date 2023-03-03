
const urlParams = new URLSearchParams(window.location.search);
const greetingValue = urlParams.get('id');
window.addEventListener("load",function ()
{
   visualizzaRicetta();
   caricaCommenti(greetingValue);
});
function visualizzaRicetta()
{
    $.ajax(
        {
            type:"POST",
            url:"/caricaRicetta",
            contentType: "application/json",
            data: JSON.stringify(greetingValue),
            success:function(ricetta)
            {
                document.getElementById("nomeRicetta").innerText=ricetta.nomeRicetta;
                document.getElementById("descrizioneRicetta").innerText=ricetta.descrizioneRicetta;
                document.getElementById("imgRicetta").src=ricetta.thumbnail;
                document.getElementById("ingredientiRicetta").innerText=ricetta.ingredientiRicetta;
                document.getElementById("preparazioneRicetta").innerText=ricetta.preparazioneRicetta;
                document.getElementById("info").innerText="Autore: ["+ricetta.emailUtente+"] Data pubblicazione: "+ricetta.dataPubblicazione;
                document.getElementById("categoria").innerText="Categoria: "+ricetta.categoria;
                document.getElementById("difficolta").innerText="Difficoltà: "+ricetta.difficolta;
                document.getElementById("calorie").innerText="Calorie: "+ricetta.calorie;
                document.getElementById("segnala").innerHTML="<div>\n" +
                    "                <a onclick='segnala("+ricetta.id+")' href=javascript:void(0) style=\"font-size: 20px;font-family: 'Arial Rounded MT Bold';float: right\">Segnala la ricetta</a>\n" +
                    "            </div>";
                document.getElementById("preferiti").innerHTML="<button onclick='aggiungiPreferiti("+ricetta.id+")' style=\"float: right;margin-right: 16px\" class=\"btn btn-warning\">Aggiungi ai preferiti</button>";
            }
        })
}

function segnala(id)
{
    if(confirm("Sei sicuro di voler segnalare la ricetta?"))
    {
        $.ajax(
            {
                type:"POST",
                url:"/segnalaRicetta",
                contentType: "application/json",
                data: JSON.stringify(id),
                success: function ()
                {
                    alert("La ricetta è stata segnalata con successo!");
                }
            })
    }
}

function aggiungiPreferiti(id)
{
    $.ajax(
        {
            type:"POST",
            url:"/aggiungiPreferiti",
            contentType: "application/json",
            data: JSON.stringify(id),
            success:function ()
            {
                alert("Ricetta aggiunta correttamente nei preferiti!");
            }
        })
}

function Commento(idRicetta,emailUtente,contenuto,dataPubblicazione,segnalato)
{
    this.idRicetta=idRicetta;
    this.emailUtente=emailUtente;
    this.contenuto=contenuto;
    this.dataPubblicazione=dataPubblicazione;
    this.segnalato=segnalato;
}

function inviaCommento()
{
    var cnt=document.getElementById("msg").value;
    var currentdate = new Date();
    var data=currentdate.getDate() + "/"
        + (currentdate.getMonth()+1)  + "/"
        + currentdate.getFullYear();
    var commento=new Commento(greetingValue,null,cnt,data,false);
    $.ajax(
        {
            type:"POST",
            url:"inviaCommento",
            contentType: "application/json",
            data: JSON.stringify(commento),
            success:function ()
            {
                alert("Commento caricato con successo!");
                window.location.href="http://localhost:8081/visualizza?id="+greetingValue;
            }
        })
}

function caricaCommenti(id)
{
    $.ajax(
        {
            type:"POST",
            url:"/caricaCommenti",
            contentType: "application/json",
            data: JSON.stringify(id),
            success:function(commenti)
            {
                var index=0;
                while(index!==commenti.length)
                {
                    document.getElementById("commentoQua").append(creaCommento(commenti[index++]));
                }
            },
            error:function ()
            {
                var t=document.createElement("h4");
                t.innerText="Non ci sono ancora commenti...";
                t.style="color:black;text-align:center;margin-top:40px";
                document.getElementById("commenti").after(t);
            }
        })
}

function creaCommento(commento)
{
    var div=document.createElement("div");
    div.className="card mb-4";
    div.style="background-color:#3B601B";
    div.innerHTML= "<div class=\"card-body\">\n" +
        "                                    <p style='color: white'>"+commento.contenuto+"</p>\n" +
        "                                    <div class=\"d-flex justify-content-between\">\n" +
        "                                        <div class=\"d-flex flex-row align-items-center\">\n" +
        "                                            <p class=\"small mb-0 ms-2\" style='color: white'>"+commento.emailUtente+"</p>\n" +
        "                                        </div>\n" +
        "                                        <div class=\"d-flex flex-row align-items-center\">\n" +
        "                                            <p class=\"small mb-0\" style='color: white'>"+commento.dataPubblicazione+"</p>\n" +
        "                                            <i class=\"far fa-thumbs-up mx-2 fa-xs text-black\" style=\"margin-top: -0.16rem;\"></i>\n" +
        "                                        </div>\n" +
        "                                    </div>\n" +
        "                                </div>";
    return div;
}


