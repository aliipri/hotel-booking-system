package hotel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hotel.model.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationDTO {
    private Long id;
    private Long guestId;
    private Long roomId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime reservationDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate;

    public ReservationDTO() {}

    public ReservationDTO(Reservation entity) {
        this.id = entity.getId();
        this.guestId = entity.getGuest().getId();
        this.roomId = entity.getRoom().getId();
        this.reservationDate = entity.getReservationDate();
        this.checkInDate = entity.getCheckInDate();
        this.checkOutDate = entity.getCheckOutDate();
    }

    // Геттеры
    public Long getId() {
        return id;
    }

    public Long getGuestId() {
        return guestId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}
