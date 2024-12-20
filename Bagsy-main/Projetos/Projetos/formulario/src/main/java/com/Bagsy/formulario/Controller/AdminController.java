package com.Bagsy.formulario.Controller;

import com.Bagsy.formulario.Service.ProductService;
import com.Bagsy.formulario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("users", usuarioService.getAllUsers());
        return "admin"; // Página de administração com lista de produtos e usuários
    }
}