package hotel;

import hotel.model.Reservation;
import hotel.model.User;
import hotel.service.ReservationService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/confirmReservation")
public class ConfirmReservationServlet extends HttpServlet {

    private ReservationService reservationService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        reservationService = context.getBean(ReservationService.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Извлекаем параметры запроса
            String roomIdParam = request.getParameter("room");
            String checkInDateParam = request.getParameter("checkInDate");
            String checkOutDateParam = request.getParameter("checkOutDate");

            // Проверка на отсутствие необходимых данных
            if (roomIdParam == null || checkInDateParam == null || checkOutDateParam == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Не все данные были переданы!");
                return;
            }

            // Преобразуем параметры в соответствующие типы
            int roomId = Integer.parseInt(roomIdParam);
            LocalDate checkInDate = LocalDate.parse(checkInDateParam);
            LocalDate checkOutDate = LocalDate.parse(checkOutDateParam);

            // Получение текущего пользователя (гостя) из сессии
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("currentUser") == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            User currentUser = (User) session.getAttribute("currentUser");

            // Проверяем наличие текущего пользователя
            if (currentUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            Long guestId = reservationService.getGuestIdByUsername(currentUser.getUsername());

            // Проверяем доступность номера
            if (!reservationService.isRoomAvailable(roomId, checkInDate, checkOutDate)) {
                response.sendError(HttpServletResponse.SC_CONFLICT, "Этот номер занят в выбранные даты!");
                return;
            }

            // Создаем новое бронирование
            Reservation reservation = reservationService.createReservation(guestId, roomId, checkInDate, checkOutDate);

            // Если бронирование не удалось
            if (reservation == null) {
                response.sendError(HttpServletResponse.SC_CONFLICT, "Не удалось создать бронирование!");
                return;
            }

            // Добавляем данные о бронировании в атрибут для отображения на странице подтверждения
            request.setAttribute("reservation", reservation);

            // Перенаправляем на страницу подтверждения
            request.getRequestDispatcher("/confirmation.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ошибка в данных запроса: " + e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка сохранения бронирования: " + e.getMessage());
        }
    }
}
