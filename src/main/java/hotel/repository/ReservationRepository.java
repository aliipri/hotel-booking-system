package hotel.repository;

import hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoomId(Long roomId);

    @Query("SELECT r FROM Reservation r JOIN FETCH r.room JOIN FETCH r.guest WHERE r.guest.id = :guestId")
    List<Reservation> findByGuestId(@Param("guestId") Long guestId);

    List<Reservation> findAll();
}
