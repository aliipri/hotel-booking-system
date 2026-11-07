package hotel.service;

import hotel.model.RoomPhoto;
import hotel.repository.RoomPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomPhotoService {

    private final RoomPhotoRepository roomPhotoRepository;

    @Autowired
    public RoomPhotoService(RoomPhotoRepository roomPhotoRepository) {
        this.roomPhotoRepository = roomPhotoRepository;
    }

    // Сохранить новую фотографию
    public RoomPhoto saveRoomPhoto(RoomPhoto roomPhoto) {
        System.out.println("Передача в RoomPhotoRepository: " + roomPhoto);
        return roomPhotoRepository.save(roomPhoto);
    }

    // Получить все фотографии для номера
    public List<RoomPhoto> getAllRoomPhotos() {
        return roomPhotoRepository.findAll();
    }

    // Получить фотографию по ID
    public Optional<RoomPhoto> getRoomPhotoById(Long id) {
        return roomPhotoRepository.findById(id);
    }

    // Получить фотографии по ID номера
    public List<RoomPhoto> getRoomPhotosByRoomId(Long roomId) {
        return roomPhotoRepository.findByRoomId(roomId);
    }

    // Обновить фотографию
    public RoomPhoto updateRoomPhoto(Long id, RoomPhoto roomPhoto) {
        if (!roomPhotoRepository.existsById(id)) {
            throw new IllegalArgumentException("Фотография с ID " + id + " не найдена");
        }
        roomPhoto.setId(id);
        return roomPhotoRepository.save(roomPhoto);
    }

    // Удалить фотографию по ID
    public void deleteRoomPhoto(Long id) {
        roomPhotoRepository.deleteById(id);
    }
}
