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
            <li><a href="index.jsp" >Home</a></li>
            <li><a href="overview.jsp">Toon woordenlijst</a></li>
            <li><a href="add.jsp" class="active">Nieuw woord</a></li>
        </ul>
    </nav>
</header>

<main>
    <section>
        <h2>Woord toevoegen</h2>
        <form action="" method="post">
            <p><label for="woord">Woord: </label>
                <input type="text" , id="woord" , name="woord" , required></p>
        </form>
    </section>
</main>

<footer>
    <p>Project 1 - Woordenlijst - Groep 7</p>
</footer>


</body>
</html>