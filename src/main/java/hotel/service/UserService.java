package hotel.service;

import hotel.model.User;
import hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Получить всех пользователей
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Получить пользователя по ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Получить пользователя по имени
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Сохранить нового пользователя
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Обновить пользователя
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;  // или выбрасываем исключение
    }

    // Удалить пользователя по ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
