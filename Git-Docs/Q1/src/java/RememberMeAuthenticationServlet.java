import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rememberMeLogin")
public class RememberMeAuthenticationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Example Servlet - GET</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Example Servlet - GET</h1>");
            out.println("<p>This is a simple response for GET requests.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Example Servlet - POST</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Example Servlet - POST</h1>");
            out.println("<p>Received POST request with username: " + username + " and password: " + password + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
