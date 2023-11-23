
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shopping Cart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Shopping Cart</h1>");
            Cookie[] cookies = request.getCookies();
            String cartItems = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cartItems")) {
                        cartItems = cookie.getValue();
                        break;
                    }
                }
            }

            out.println("<p>Items in your cart: " + cartItems + "</p>");
            out.println("<form action='/YourProjectName/shoppingCart' method='post'>");
            out.println("Item to remove: <input type='text' name='itemToRemove'>");
            out.println("<input type='submit' value='Remove from Cart'>");
            out.println("</form>");
            out.println("<p><a href='/YourProjectName/addToCart?item=Product1'>Add Product 1 to Cart</a></p>");
            out.println("<p><a href='/YourProjectName/addToCart?item=Product2'>Add Product 2 to Cart</a></p>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemToRemove = request.getParameter("itemToRemove");
        if (itemToRemove != null && !itemToRemove.isEmpty()) {
            Cookie[] cookies = request.getCookies();
            String cartItems = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cartItems")) {
                        cartItems = cookie.getValue();
                        break;
                    }
                }
            }
            cartItems = cartItems.replace(itemToRemove + ",", "");  // Remove the item and the trailing comma
            Cookie cartCookie = new Cookie("cartItems", cartItems);
            response.addCookie(cartCookie);
        }
        response.sendRedirect("/YourProjectName/shoppingCart");
    }
}
