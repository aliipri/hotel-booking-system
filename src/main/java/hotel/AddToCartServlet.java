package hotel;

import hotel.model.CartItem;
import hotel.model.Room;
import hotel.service.CartService;
import hotel.service.RoomService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private CartService cartService;
    private RoomService roomService;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.cartService = context.getBean(CartService.class);
        this.roomService = context.getBean(RoomService.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Long roomId = Long.parseLong(request.getParameter("roomId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Room room = roomService.getRoomById(roomId);
            if (room == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Room not found");
                return;
            }

            CartItem cartItem = new CartItem();
            cartItem.setRoom(room);
            cartItem.setQuantity(quantity);
            cartService.addToCart(cartItem);
            response.sendRedirect("cart");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid room or quantity");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to add room to cart");
        }
    }
}
