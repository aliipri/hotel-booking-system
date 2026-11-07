package hotel;

import hotel.model.Room;
import hotel.service.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/reserveRoom")
public class ReserveRoomServlet extends HttpServlet {

    private RoomService roomService;

    @Override
    public void init() {
        ApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.roomService = context.getBean(RoomService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Room> rooms = roomService.getAllRooms();
        request.setAttribute("rooms", rooms);  // Передаем список комнат в JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("reserveRoom.jsp");
        dispatcher.forward(request, response);
    }
}

