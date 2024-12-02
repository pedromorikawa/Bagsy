package com.Bagsy.formulario;


import com.Bagsy.model.CartItem;
import com.Bagsy.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final List<CartItem> cart = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cart;
    }

    public void addProductToCart(Product product) {
        cart.add(new CartItem(product, 1)); // Adiciona o produto com quantidade 1
    }

    public void removeProductFromCart(Long productId) {
        cart.removeIf(item -> item.getProduct().getId().equals(productId)); // Remove o produto pelo ID
    }

    public double getTotal() {
        return cart.stream().mapToDouble(CartItem::getTotal).sum();
    }
}