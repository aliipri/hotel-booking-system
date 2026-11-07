package hotel.service;

import hotel.model.CartItem;
import hotel.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartItem addToCart(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }

    @Transactional(readOnly = true)
    public List<CartItem> getAllCartItems() {
        return cartRepository.findAll();
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }
}
