window.addEventListener("load", function ()
{
    document.getElementById("login").addEventListener("click", accedi);
});
function Utente(nome,cognome,email,password,admin,bannato,google_id)
{
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.password =password;
    this.admin=admin;
    this.bannato=bannato;
    this.google_id=google_id;
}
function accedi() {
    var email = document.querySelector("#email").value;
    var password = document.querySelector("#pass").value;
    if ((email === "") || (password === "") || (email === " ") || (password === " "))
    {
        error("Attenzione! Compila tutti i campi");
    }
    else
    {
        var utente=new Utente(null,null,email,password,false,false,null);
        $.ajax(
            {
                url: "/doLogin",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(utente),
                success: function () {
                    var messageContainer = document.createElement("div");
                    messageContainer.id = "message_container";
                    messageContainer.className = "alert alert-primary d-flex align-items-center mb-3";
                    $(messageContainer).attr("role", "alert");

                    var icon = document.createElement("i");
                    icon.className = "bi bi-info-circle-fill me-2";
                    $(icon).attr("role", "img");

                    var message = document.createElement("div");
                    message.id = "message";
                    $(message).text("Login effettuato")
                    messageContainer.append(icon, message);

                    $("#login_form").before(messageContainer);

                    setTimeout(function () {
                        $("#message_container").fadeOut();
                    }, 2000);
                    setTimeout(function () {
                        $("#message_container").remove();
                    }, 2300);
                    setTimeout(function ()
                    {
                        window.location.href="http://localhost:8081";
                    }, 1000);
                },
                error: function ()
                {
                    error("Controlla che i dati siano corretti!")
                    setTimeout(function ()
                    {
                        window.location.href="http://localhost:8081/login";
                    }, 1000);
                },
            });
    }
}

function error(s){
    var messageContainer = document.createElement("div");
    messageContainer.id = "message_container";
    messageContainer.className = "alert alert-danger d-flex align-items-center mb-3";
    $(messageContainer).attr("role", "alert");

    var icon = document.createElement("i");
    icon.className = "bi bi-info-circle-fill me-2";
    $(icon).attr("role", "img");

    var message = document.createElement("div");
    message.id = "message";
    $(message).text(s);
    messageContainer.append(icon, message);
    $("#login_form").before(messageContainer);

    setTimeout(function () {
        $("#message_container").fadeOut();
    }, 2000);
    setTimeout(function () {
        $("#message_container").remove();
    }, 2300);


}

