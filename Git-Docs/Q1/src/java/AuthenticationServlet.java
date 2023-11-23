import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> users = new ArrayList<>();
        users.add(new User("faaiz", "1234"));
        users.add(new User("uzair", "456"));

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                Cookie authCookie = new Cookie("user", username);
                response.addCookie(authCookie);
                response.sendRedirect("securepage.jsp");
                return;
            }
        }
        response.sendRedirect("login.jsp?error=1");
    }
}
