package hotel.controller;

import hotel.dto.ReservationDTO;
import hotel.repository.ReservationRepository;
import hotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminReservationRestController {

    private final ReservationRepository reservationRepository;

    @Autowired
    public AdminReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> listAll(HttpSession session) {
        Object current = session.getAttribute("currentUser");
        if (!(current instanceof User) || !"ADMIN".equalsIgnoreCase(((User) current).getRole())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Admin role required");
        }
        return reservationRepository.findAll()
                .stream()
                .map(ReservationDTO::new)
                .collect(Collectors.toList());
    }
}
