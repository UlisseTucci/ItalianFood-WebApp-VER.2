<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="theme-color" content="#712cf9">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="generator" content="Hugo 0.108.0">
    <title>Italian Food</title>
    <link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <link rel="stylesheet" href="css/visualizza.css" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/fontawesome.min.css">
    <jsp:include page="menuBar.jsp"/>

</head>
<body id="bodyy">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
<script type="text/javascript" src="js/visualizzaRicetta.js" > </script>

<main>
    <div class="container py-4">
        <div class="p-5 mb-4 bg-light rounded-3">
            <div id="preferiti">

            </div>
            <div class="container-fluid py-5">
                <img  id="imgRicetta" style="float: right;border-radius: 20px;height: auto;width:100%;max-width: 400px" src="">
                <h1 id="nomeRicetta" style="color: black" class="display-5 fw-bold"></h1>
                <p id="info" style="color:#808080" class="col-md-8 fw-bold"></p>
                <p id="categoria" class="col-md-8 fw-bold"></p>
                <p id="difficolta" class="col-md-8 fw-bold"></p>
                <p id="calorie" class="col-md-8 fw-bold"></p>
                <p id="descrizioneRicetta" class="col-md-8 fs-4"></p>
            </div>
        </div>

        <div class="row align-items-md-stretch">
            <div>
                <div style="background-color: #315611" class="h-100 p-5 rounded-3">
                    <h2 style="color: white">Ingredienti</h2>
                    <p style="color: white" id="ingredientiRicetta"></p>
                </div>
            </div>
            <div>
                <div class="h-100 p-5 bg-light border rounded-3">
                    <h2>Preparazione</h2>
                    <p id="preparazioneRicetta"></p>
                </div>
            </div>
            <c:if test="${utente!=null}">
                <div id="segnala">

                </div>
            </c:if>
        </div>
    </div>
</main>
<!-- Main Body -->
<section>
    <div class="container">
        <div class="row">

                        <div class="col-md-10 col-lg-8 col-xl-6">
                            <div class="card" style="background-color: #f9f9fa;border-color: #f9f9fa">
                                <div class="card-body p-4">
                                    <div class="d-flex flex-start w-100">
                                        <div class="w-100">
                                            <h5>Aggiungi un commento</h5>
                                            <div class="form-outline">
                                                <textarea class="form-control" id="msg" rows="4"></textarea>
                                            </div>
                                            <div class="d-flex justify-content-between mt-3">
                                                <button onclick="inviaCommento()" type="button" class="btn btn-warning">
                                                    Invia <i  class="fas fa-long-arrow-alt-right ms-1"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


            <div class="col-sm-5 col-md-6 col-12 pb-4">
                <div class="container">
                    <div class="card shadow-0" style="background-color: #f9f9fa;border-color: #f9f9fa">
                        <div id="commentoQua"  class="card-body p-4">
                            <h4 id="commenti" style="color: black;text-align: center">Commenti</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<jsp:include page="footer.jsp"/>
</html>

