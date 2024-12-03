package com.Bagsy.formulario.Controller;


import com.Bagsy.formulario.Model.Usuario;
import com.Bagsy.formulario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Página de login
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if (usuarioService.authenticate(username, password)) {
            return "redirect:/"; // Redireciona para a homepage se login for bem-sucedido
        } else {
            model.addAttribute("error", "Credenciais inválidas!");
            return "login"; // Retorna para a página de login com erro
        }
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Página de cadastro
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String name, @RequestParam String email,
                                  @RequestParam String password, @RequestParam String confirmPassword,
                                  Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "As senhas não coincidem!");
            return "register"; // Retorna para a página de cadastro com erro de senha
        }

        Usuario usuario = new Usuario(name, email, password);
        usuarioService.register(usuario);
        return "redirect:/auth/login"; // Redireciona para a página de login após o cadastro
    }
}