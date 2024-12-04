package com.Bagsy.formulario.Controller;


import com.Bagsy.formulario.Service.CartService;
import com.Bagsy.formulario.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cart", cartService.getCartItems());
        model.addAttribute("cartTotal", cartService.getTotal());
        return "homepage"; // Página de homepage
    }

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id) {
        productService.getProductById(id).ifPresent(cartService::addProductToCart);
        return "redirect:/"; // Redireciona para a homepage
    }

    @PostMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeProductFromCart(id);
        return "redirect:/"; // Redireciona para a homepage
    }
}
