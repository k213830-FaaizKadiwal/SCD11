import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class CookieReaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cookie Reader</title>");
        out.println("</head>");
        out.println("<body>");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            out.println("<h2>Cookies:</h2>");
            for (Cookie cookie : cookies) {
                out.println("<p><strong>Name:</strong> " + cookie.getName() + ", <strong>Value:</strong> " + cookie.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
