package hotel.repository;

import hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByEmail(String email);  // Дополнительный метод поиска по email
    @Query("SELECT g.id FROM Guest g WHERE g.user.id = (SELECT u.id FROM User u WHERE u.username = :username)")
    Long findGuestIdByUsername(@Param("username") String username);
    Guest findByUserId(Long userId);
}
