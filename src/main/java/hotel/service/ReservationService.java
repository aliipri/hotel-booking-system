package hotel.service;

import hotel.model.Guest;
import hotel.model.Reservation;
import hotel.model.Room;
import hotel.model.User;
import hotel.repository.GuestRepository;
import hotel.repository.ReservationRepository;
import hotel.repository.RoomRepository;
import hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        if (reservationRepository.existsById(id)) {
            reservation.setId(id);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public boolean isRoomAvailable(Integer roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Reservation> reservations = reservationRepository.findByRoomId(Long.valueOf(roomId));

        for (Reservation reservation : reservations) {
            if ((checkInDate.isBefore(reservation.getCheckOutDate()) && checkOutDate.isAfter(reservation.getCheckInDate()))) {
                return false;
            }
        }
        return true;
    }
    public Long getGuestIdByUsername(String username) {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalStateException("Пользователь не найден в таблице users.");
        }

        Guest guest = guestRepository.findByUserId(user.getId());
        if (guest == null) {
            throw new IllegalStateException("Пользователь не найден в таблице guest.");
        }

        return guest.getId();
    }

    @Transactional
    public Reservation createReservation(Long guestId, Integer roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        if (checkInDate == null || checkOutDate == null || !checkInDate.isBefore(checkOutDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }
        Room room = roomRepository.findById(Long.valueOf(roomId))
                .orElseThrow(() -> new IllegalStateException("Номер не найден."));

        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new IllegalStateException("Гость не найден."));

        if (!isRoomAvailable(roomId, checkInDate, checkOutDate)) {
            throw new IllegalStateException("Номер занят.");
        }

        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setCheckInDate(checkInDate);
        reservation.setCheckOutDate(checkOutDate);
        reservation.setReservationDate(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalStateException("Пользователь не найден: " + username);
        }

        Guest guest = guestRepository.findByUserId(user.getId());
        if (guest == null) {
            throw new IllegalStateException("Гость не найден для пользователя: " + username);
        }

        List<Reservation> reservations = reservationRepository.findByGuestId(guest.getId());
        System.out.println("Найдено бронирований: " + reservations.size());
        return reservations;
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}

