<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
    <h2>Login Form</h2>
    <form action="LoginServlet" method="post">
        <label for="username">Nombre de Usuario</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Contraseña</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>