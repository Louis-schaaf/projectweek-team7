<%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 1/04/2021
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bevestig verwijderen</title>
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
    <h2>Bevestiging</h2>
    <p>Ben je zeker dat het woord ${param.woord} wil verwijderen?</p>

    <form action="Controller?command=delete&woord=${param.woord}" method="post">
        <input id="confirmDelete" type="submit" value="Ja"/>
    </form>
    <p><a href="Controller?command=overview">Cancel</a> indien je het woord ${param.woord} niet wilt verwijderen.</p>
</main>

<footer>
    <p>Project 1 - Woordenlijst - Groep 7</p>
</footer>


</body>
</html>
