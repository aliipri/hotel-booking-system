package hotel.repository;

import hotel.model.Room;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNumber(Integer roomNumber);  // Дополнительный метод для поиска по номеру комнаты
    @EntityGraph(attributePaths = {"photos"})
    List<Room> findAll();
}
