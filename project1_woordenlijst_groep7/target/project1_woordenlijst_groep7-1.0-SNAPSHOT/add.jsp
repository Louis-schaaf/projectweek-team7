<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Woord toevoegen</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<header>
    <nav>
        <ul>
            <li><h1>Beheerapplicatie woordenlijst</h1></li>
            <li><a href="Controller">Home</a></li>
            <li><a href="Controller?command=overview">Toon woordenlijst</a></li>
            <li><a href="Controller?command=pageAdd" class="active">Nieuw woord</a></li>
        </ul>
    </nav>
</header>

<main>
    <section>
        <h2>Woord toevoegen</h2>

        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li id="errorItem">${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <form action="Controller?command=add" method="post" novalidate>
            <p>
                <label for="woord">Woord: </label>
                <input type="text" id="woord" name="woord" required value="${woordPreviousValue}">
            </p>
            <p>
                <label for="niveau">Niveau: </label>
                <select name="niveau" id="niveau" value="${niveauPreviousValue}">
                    <option value=""></option>
                    <option value="Beginner">Beginner</option>
                    <option value="Expert">Expert</option>
                </select>
            </p>
            <p>
                <label for="bevestig"></label>
                <input id="bevestig" type="submit" value="Voeg toe">
            </p>
        </form>

        <button><a href="Controller?command=overview">Terug naar woordenlijst</a></button>
    </section>
</main>

<footer>
    <p>Project 1 - Woordenlijst - Groep 7</p>
</footer>


</body>
</html>