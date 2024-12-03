package com.Bagsy.formulario.Service;


import com.Bagsy.formulario.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product(1L, "Bolsa de ombro Bagsy", 100, "/images/bolsa.jpg"),
            new Product(2L, "Mala de viagem Bagsy", 150, "/images/mala.jpg"),
            new Product(3L, "Mochila Bagsy", 45, "/images/mochila.jpg"),
            new Product(4L, "Shoulder bag Bagsy", 5, "/images/shoulder.jpg"),
            new Product(5L, "Ecobag Bagsy", 28, "/images/ecobag.jpg")
    );

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}

