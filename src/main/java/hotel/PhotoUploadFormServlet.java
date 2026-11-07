package hotel;

import hotel.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/uploadPhotoForm")
public class PhotoUploadFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Проверяем, что пользователь авторизован и является администратором
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null || !"admin".equals(currentUser.getRole())) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Доступ запрещен. Только администратор может загрузить фото.");
            return;
        }

        // Перенаправляем на JSP с формой загрузки фото
        req.getRequestDispatcher("/uploadPhoto.jsp").forward(req, resp);
    }
}
