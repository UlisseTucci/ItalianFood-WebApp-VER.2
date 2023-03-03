window.addEventListener("load", function ()
{
    document.getElementById("updateProfilo").addEventListener("click", modificaProfilo);
});


function modificaProfilo(){
    var password = document.querySelector("#nuovaPassword").value;
    var nome = document.querySelector("#nome").value;
    var cognome = document.querySelector("#cognome").value;
    var confirm_password = document.querySelector("#confermaPassword").value;

    if((nome=="" || nome==" ") && (cognome==""||cognome==" ") && password=="" && confirm_password=="") {
        alert("Attenzione! Sono presenti campi vuoti");
    }
    else if(password!=""){
        if(password.length<6)
            alert("La password deve contenere almeno 6 caratteri");
    }
    else {
        $.ajax(
            {
                url: "/doUpdate",
                type: "POST",
                error:function(){
                    alert("Profilo aggiornato correttamente! Rifai il login per visualizzare i cambiamenti!");
                }
            });
    }

}


