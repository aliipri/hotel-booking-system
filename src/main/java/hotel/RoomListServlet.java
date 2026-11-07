package hotel;

import hotel.model.Room;
import hotel.model.RoomPhoto;
import hotel.model.User;
import hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@WebServlet("/rooms")
public class RoomListServlet extends HttpServlet {

    @Autowired
    private RoomService roomService;

    @Override
    public void init() throws ServletException {
        // Позволяет Spring внедрить RoomService
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1) Смотрим, есть ли в сессии текущий пользователь
        HttpSession session = req.getSession(false);
        User currentUser = null;
        if (session != null) {
            // Предполагаем, что при логине вы клали в сессию объект User под ключом "currentUser"
            Object maybeUser = session.getAttribute("currentUser");
            if (maybeUser instanceof User) {
                currentUser = (User) maybeUser;
            }
        }
        // Передаём пользователя в request — чтобы JSP могла узнать, залогинен ли он
        req.setAttribute("currentUser", currentUser);

        // 2) Получаем список всех комнат
        List<Room> rooms = roomService.getAllRooms();

        // 3) Конвертируем все байты фотографии (byte[]) в строку Base64, чтобы можно было сразу вставлять в <img src="data:image/...">
        for (Room room : rooms) {
            if (room.getPhotos() != null && !room.getPhotos().isEmpty()) {
                for (RoomPhoto photo : room.getPhotos()) {
                    byte[] photoBytes = photo.getPhoto();
                    if (photoBytes != null) {
                        String base64Photo = Base64.getEncoder().encodeToString(photoBytes);
                        photo.setBase64Photo(base64Photo);
                    }
                }
            }
        }

        // 4) Кладём список комнат в атрибуты и форвардим на JSP
        req.setAttribute("rooms", rooms);
        req.getRequestDispatcher("/rooms.jsp").forward(req, resp);
    }
}
