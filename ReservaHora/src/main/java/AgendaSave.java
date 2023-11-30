import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveAgenda")
public class AgendaSave extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idMascota = request.getParameter("idMascota");
        String rutDueno = request.getParameter("rutDueno");
        String nombreMascota = request.getParameter("nombreMascota");
        String hora = request.getParameter("hora");
        String fecha = request.getParameter("fecha");

        saveToDatabase(idMascota, rutDueno, nombreMascota, hora, fecha);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Creacion de Registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Creacion exitosa</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void saveToDatabase(String idMascota, String rutDueno, String nombreMascota, String hora, String fecha) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/dbexamencicd";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO agenda (idMascota, rutDueno, nombreMascota, hora, fecha) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idMascota);
                preparedStatement.setString(2, rutDueno);
                preparedStatement.setString(3, nombreMascota);
                preparedStatement.setString(4, hora);
                preparedStatement.setString(5, fecha);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}