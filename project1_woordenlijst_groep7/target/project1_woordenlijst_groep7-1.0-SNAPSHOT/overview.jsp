<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Woordenlijst</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<header>
    <nav>
        <ul>
            <li><h1>Beheerapplicatie woordenlijst</h1></li>
            <li><a href="Controller">Home</a></li>
            <li><a href="Controller?command=overview" class="active">Toon woordenlijst</a></li>
            <li><a href="Controller?command=pageAdd">Nieuw woord</a></li>
        </ul>
    </nav>
</header>

<main>
    <section>
        <h2>Woordenlijst</h2>


        <article>
            <ul id="filter">
                <li>
                    <button><a href="Controller?command=overview">Alle</a></button>
                </li>
                <li>
                    <button><a href="Controller?command=overview&filter=beginner">Beginner</a></button>
                </li>
                <li>
                    <button><a href="Controller?command=overview&filter=expert">Expert</a></button>
                </li>
            </ul>
        </article>

        <article>
            <c:choose>
                <c:when test="${woorden.size()==0}">
                    <p>Er zijn nog geen woorden toegevoegd</p>
                </c:when>
                <c:otherwise>
                    <ol>
                        <c:forEach var="woord" items="${woorden}">
                            <li>${woord.getWoord()} <c:if
                                    test="${woord.getNiveau() != null}">- ${woord.getNiveau()}</c:if> - <a
                                    href="Controller?command=deleteConfirmation&woord=${woord.getWoord()}"> Verwijder </a> - <a
                                    href="Controller?command=pasAan&woord=${woord.getWoord()}"> Pas Aan</a></li>
                        </c:forEach>
                    </ol>
                </c:otherwise>
            </c:choose>
        </article>


        <button><a href="Controller?command=download">Download woordenlijst</a></button>
    </section>
</main>

<footer>
    <p>Project 1 - Woordenlijst - Groep 7</p>
</footer>


</body>
</html>