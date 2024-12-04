package com.Bagsy.formulario.Controller;

import com.Bagsy.formulario.Model.Atualizar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/produtos")
public class AtualizarController {

    @GetMapping("/atualizar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        // Aqui, você deve obter o produto do banco de dados, mas vamos simular
        Atualizar atualizar = new Atualizar();
        atualizar.setId(id);
        atualizar.setNome("Produto Exemplo");
        atualizar.setPreco(99.99);
        atualizar.setDescricao("Descrição do produto");
        atualizar.setEstoque(50);
        atualizar.setMarca("Marca Exemplo");
        atualizar.setCor("Vermelho");
        atualizar.setTamanho("M");
        atualizar.setPeso(1.5);
        atualizar.setMaterial("Algodão");
        atualizar.setCategoria("Eletrônicos");
