package hotel.service;

import hotel.model.Guest;
import hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    // Получить гостя по ID
    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    // Получить гостя по email
    public Guest getGuestByEmail(String email) {
        return guestRepository.findByEmail(email);
    }

    // Получить всех гостей
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    // Сохранить нового гостя
    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    // Обновить гостя
    public Guest updateGuest(Long id, Guest guest) {
        if (guestRepository.existsById(id)) {
            guest.setId(id);
            return guestRepository.save(guest);
        }
        return null;  // или выбрасываем исключение
    }

    // Удалить гостя по ID
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
