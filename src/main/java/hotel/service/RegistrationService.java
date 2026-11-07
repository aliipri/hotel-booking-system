package hotel.service;

import hotel.model.Guest;
import hotel.model.User;
import hotel.repository.GuestRepository;
import hotel.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final GuestRepository guestRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository,
                               GuestRepository guestRepository,
                               PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.guestRepository = guestRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerUserAndGuest(String username, String password, String name, String email, String phone) {
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username is already in use");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");
        userRepository.save(user);

        Guest guest = new Guest();
        guest.setName(name);
        guest.setEmail(email);
        guest.setPhone(phone);
        guest.setUser(user);
        guestRepository.save(guest);
    }
}
