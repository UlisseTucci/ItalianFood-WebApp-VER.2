<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Italian Food</title>
    <link rel="icon" href="image/LogoTrasparente.png" type="image/gif" sizes="16x16">
    <link rel="icon" type="image/x-icon" href="/image/LogoTrasparente.png">
    <link rel="stylesheet"  type="text/css"  href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="registrazione_back">


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://accounts.google.com/gsi/client" async defer></script>
<script type="text/javascript" src="js/registrazione.js"> </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js" > </script>

<section class="registrazione_back" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <form>
                                <a class="left_arrow" type="button"  href="/" > </a>
                            </form>
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

<!--<div class="contenitore" style="margin-right: 0; margin-left: 0;">-->
    <div class="logo-descrizione">
        <div class="logo" style="display: block; text-align: center;">
            <img src="image/iconaProgetto.jpg" alt="logo" style="width:200px;height:200px;">
        </div>
        <div class="descrizione" style="font-family: SFProDisplay-Regular, Helvetica, Arial, sans-serif;">
            <h3 style="text-align: center">Ti piace cucinare? Sei nel posto giusto.... <br> Scopri con noi tantissime nuove ricette, e carica quelle da te create!</h3>
        </div>
    </div>
    <div class="d-flex flex-row align-items-center mb-4">
        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
        <div class="form-outline flex-fill mb-0">
    <div class="credenziali" style="display: block; text-align: center;">
        <form id="login_form">
        <div class="user" >
            <input type="text" class="input" name="email" id="email" placeholder="E-mail" aria-label="E-mail o numero di telefono">
        </div>
        <div class="password">
            <input type="password" class="input" name="pass" id="pass" placeholder="Password">
        </div>

        <div>
            <button class="btn btn-primary" value="1" id="login" name="login" type="button" style="width: 400px; border-radius: 15px; margin-top: 10px">Accedi</button>
        </div>

        <div class="design-google">
            <div id="g_id_onload"
                 data-client_id="92835883330-etr7s0kmm0be555e3aj1vij29fd76a0o.apps.googleusercontent.com"
                 data-context="signin"
                 data-ux_mode="popup"
                 data-callback="googleReg"
                 data-size="large"
                 data-auto_prompt="false">
            </div>

            <div class="g_id_signin"
                 data-type="standard"
                 data-shape="rectangular"
                 data-theme="filled_blue"
                 data-text="continue_with"
                 data-size="large"
                 data-locale="it">
            </div>
        </div>
        </form>
        <p class="text-center text-muted mt-5 mb-0">Non hai un account?</p>
        <div >
           <a href="/registrazione">
                <button class="btn btn-secondary" value="2" id="nuovo-account" type="submit" style="width: 400px">Crea nuovo account</button>
            </a>
        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</html>