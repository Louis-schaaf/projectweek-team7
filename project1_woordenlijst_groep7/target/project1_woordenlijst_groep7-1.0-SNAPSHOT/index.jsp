<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Beheerapplicatie woordenlijst</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<header>
    <nav>
        <ul>
            <li><h1>Beheerapplicatie woordenlijst</h1></li>
            <li><a href="Controller" class="active">Home</a></li>
            <li><a href="Controller?command=overview">Toon woordenlijst</a></li>
            <li><a href="Controller?command=pageAdd">Nieuw woord</a></li>
        </ul>
    </nav>
</header>

<main>
    <section>
        <h2>Home</h2>
        <p>Met deze applicatie kan je de woordenlijst beheren om in het spelletje Hangman te gebruiken.</p>
    </section>

    <section>
        <h2>Statistieken</h2>
        <c:choose>
            <c:when test="${aantalWoorden != 0}">
                <p>Deze woordenlijst heeft ${aantalWoorden} woord(en)</p>
                <p>Het langste woord is ${langsteWoord.getWoord()}</p>
                <p>Het korste woord is ${kortsteWoord.getWoord()}</p>
                <p>Het gemiddeld aantal verschillende letters van alle woorden ${gemiddelde}</p>
            </c:when>
            <c:otherwise>
            <p>Er zijn nog geen woorden toegevoegd</p>
            </c:otherwise>
        </c:choose>
    </section>
</main>

<footer>
    <p>Project 1 - Woordenlijst - Groep 7</p>
</footer>


</body>
</html>