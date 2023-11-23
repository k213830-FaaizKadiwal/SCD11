import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String item = request.getParameter("item");
        String cartItems = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cartItems")) {
                    cartItems = cookie.getValue();
                    break;
                }
            }
        }
        if (cartItems == null) {
            cartItems = "";
        }
        if (!cartItems.contains(item)) {
            cartItems += item + ",";
        }
        Cookie cartCookie = new Cookie("cartItems", cartItems);
        response.addCookie(cartCookie);
        response.sendRedirect("/k213830scdlab06/shoppingCart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String item = request.getParameter("item");
        String additionalInfo = request.getParameter("additionalInfo");
        String cartItems = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cartItems")) {
                    cartItems = cookie.getValue();
                    break;
                }
            }
        }
        if (cartItems == null) {
            cartItems = "";
        }
        if (!cartItems.contains(item)) {
            cartItems += item;
            if (additionalInfo != null && !additionalInfo.isEmpty()) {
                cartItems += ":" + additionalInfo;
            }
            cartItems += ",";
        }
        Cookie cartCookie = new Cookie("cartItems", cartItems);
        response.addCookie(cartCookie);
        response.sendRedirect("/k213830scdlab06/shoppingCart");
    }
}
