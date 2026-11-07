package hotel;

import hotel.model.Reservation;
import hotel.model.User;
import hotel.service.ReservationService;
import hotel.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserRepository userRepository;
    private ReservationService reservationService;
    private PasswordEncoder passwordEncoder;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.userRepository = context.getBean(UserRepository.class);
        this.reservationService = context.getBean(ReservationService.class);
        this.passwordEncoder = context.getBean(PasswordEncoder.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userRepository.findByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {

            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);

            List<Reservation> allReservations = reservationService.getReservationsByUsername(username);

            System.out.println(">>> allReservations.size(): " + allReservations.size());
            for (Reservation r : allReservations) {
                System.out.println("    ID=" + r.getId() +
                        ", room=" + r.getRoom().getRoomNumber() +
                        ", checkIn=" + r.getCheckInDate() +
                        ", checkOut=" + r.getCheckOutDate());
            }

            LocalDate today = LocalDate.now();
            List<Reservation> activeReservations = allReservations.stream()
                    .filter(res -> {
                        LocalDate co = res.getCheckOutDate();
                        return co != null && !co.isBefore(today);
                    })
                    .collect(Collectors.toList());

            request.setAttribute("userReservations", activeReservations);

            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp?error=Invalid username or password");
        }
    }
}
