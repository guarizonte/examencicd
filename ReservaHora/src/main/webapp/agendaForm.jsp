<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agenda Form</title>
</head>
<body>
    <h2>Agenda Form</h2>
    <form action="SaveAgenda" method="post">
        <label for="idMascota">ID Mascota:</label>
        <input type="number" id="idMascota" name="idMascota" required><br>

        <label for="rutDueno">RUT Dueño:</label>
        <input type="text" id="rutDueno" name="rutDueno" required><br>

        <label for="nombreMascota">Nombre Mascota:</label>
        <input type="text" id="nombreMascota" name="nombreMascota" required><br>

        <label for="hora">Hora:</label>
        <input type="text" id="hora" name="hora" required><br>

        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" required><br>

        <input type="submit" value="Save">
    </form>
</body>
</html>