package hotel;

import hotel.model.Reservation;
import hotel.model.User;
import hotel.service.ReservationService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {

    private ReservationService reservationService;

    @Override
    public void init() throws ServletException {
        // Получаем бин из Spring-контекста
        WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.reservationService = ctx.getBean(ReservationService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // В LoginServlet при входе мы сохраняли весь объект User в сессию:
        // session.setAttribute("currentUser", user);
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String username = currentUser.getUsername();

        // ————————————
        // 1) Всегда кладём ВСЕ бронирования в атрибут allReservations
        // ————————————
        List<Reservation> allReservations = reservationService.getAllReservations();
        request.setAttribute("allReservations", allReservations);

        // ————————————
        // 2) Делаем личные «активные» бронирования пользователя (как раньше)
        // ————————————
        List<Reservation> userAll = reservationService.getReservationsByUsername(username);
        LocalDate today = LocalDate.now();
        List<Reservation> activeReservations = userAll.stream()
                .filter(res -> {
                    LocalDate checkOut = res.getCheckOutDate();
                    return checkOut != null && !checkOut.isBefore(today);
                })
                .collect(Collectors.toList());
        request.setAttribute("userReservations", activeReservations);

        // ————————————
        // 3) Форвард на JSP
        // ————————————
        request.getRequestDispatcher("/userProfile.jsp").forward(request, response);
    }
}
