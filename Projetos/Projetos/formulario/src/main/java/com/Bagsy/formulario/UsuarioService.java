package com.Bagsy.formulario;

import com.Bagsy.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public void register(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean authenticate(String username, String password) {
        return usuarios.stream()
                .anyMatch(user -> user.getEmail().equals(username) && user.getPassword().equals(password));
    }

    public List<Usuario> getAllUsers() {
        return usuarios; // Retorna a lista de todos os usuários
    }
}

