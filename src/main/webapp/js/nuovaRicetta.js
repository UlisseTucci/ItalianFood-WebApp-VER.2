window.addEventListener("load", function ()
{
    document.getElementById("inviaRicetta").addEventListener("click", inviaRicetta);
});

function Ricetta(id,emailUtente,nomeRicetta,descrizioneRicetta,preparazioneRicetta,ingredientiRicetta,dataPubblicazione,categoria,segnalata,thumbnail,difficolta,calorie)
{
    this.id=id;
    this.emailUtente=emailUtente;
    this.nomeRicetta=nomeRicetta;
    this.descrizioneRicetta=descrizioneRicetta;
    this.preparazioneRicetta=preparazioneRicetta;
    this.ingredientiRicetta=ingredientiRicetta;
    this.dataPubblicazione=dataPubblicazione;
    this.categoria=categoria;
    this.segnalata=segnalata;
    this.thumbnail=thumbnail;
    this.difficolta=difficolta;
    this.calorie=calorie;
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


function inviaRicetta()
{
    var currentdate = new Date();
    var emailUtente=document.querySelector("#emailRicetta").placeholder;
    var nomeRicetta=document.querySelector("#nomeRicetta").value;
    var descrizione=$("#descrizioneRicetta").val();
    var preparazione=$("#preparazioneRicetta").val();
    var data=currentdate.getDate() + "/"
    + (currentdate.getMonth()+1)  + "/"
    + currentdate.getFullYear();


    var tipoPortataCombo=document.querySelector("#tipoPortata");
    var difficoltaCombo=document.querySelector("#difficolta");
    var ingredienti=$("#ingredientiRicetta").val();
    var tipoPortata = tipoPortataCombo.options[tipoPortataCombo.selectedIndex].text;
    var difficolta = difficoltaCombo.options[difficoltaCombo.selectedIndex].text;
    var calorie=document.getElementById("calorie").value;
    if(document.getElementById("showImage").src==="http://localhost:8081/image/upload.png")
        var ricetta=new Ricetta(null,emailUtente,nomeRicetta,descrizione,preparazione,ingredienti,data,tipoPortata,false,null,difficolta,calorie);

    else
        var ricetta=new Ricetta(null,emailUtente,nomeRicetta,descrizione,preparazione,ingredienti,data,tipoPortata,false,im,difficolta,calorie);

    if((nomeRicetta=="" || nomeRicetta==" ")||(descrizione==""||descrizione==" ")||(preparazione==""||preparazione==" ")||(ingredienti=="" || ingredienti==" "))
        alert("sono presenti campi vuoti");
    else if((calorie==0||calorie==null)||(difficolta=="Seleziona la difficoltà in base alle capacità tecniche richieste per la preparazione"||difficolta=="")||(tipoPortata=="Seleziona il tipo di portata" || tipoPortata==""))
        alert("sono presenti campi vuoti");
    else {
        $.ajax(
            {
                type: "POST",
                url: "/inviaRicetta",
                contentType: "application/json",
                data: JSON.stringify(ricetta),
                success: function () {
                    alert("La ricetta è stata creata con successo!");
                    document.querySelector("#nomeRicetta").value = " ";
                    document.querySelector("#calorie").value =null;
                    document.querySelector("#preparazioneRicetta").value = " ";
                    document.querySelector("#ingredientiRicetta").value = " ";
                    document.querySelector("#tipoPortata").value = " ";
                    document.querySelector("#difficolta").value = " ";
                    document.querySelector("#descrizioneRicetta").value = " ";
                    document.querySelector("#showImage").src = "image/upload.png";
                }
            })
    }
}