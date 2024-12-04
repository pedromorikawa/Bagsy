package com.Bagsy.formulario.Controller;

import com.Bagsy.formulario.Model.CadastroProduto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CadastroProdutoController {

    @GetMapping("/cadastroProduto")
    public String exibirFormulario(Model model) {
        model.addAttribute("produto", new CadastroProduto()); // Passando o objeto produto para o Thymeleaf
        return "cadastroProduto"; // Nome do arquivo HTML (cadastroProduto.html)
    }

    @PostMapping("/cadastrarProduto")
    public String cadastrarProduto(@ModelAttribute CadastroProduto produto) {
        // Aqui você pode processar os dados, como salvar no banco ou mover a imagem
        // Produto produto.getImagem() pode ser usado para lidar com o upload da imagem

        // Exemplo de como acessar a imagem:
        MultipartFile imagem = produto.getImagem();
        if (imagem != null && !imagem.isEmpty()) {
            // Processar a imagem, por exemplo, salvar no diretório
        }

        return "redirect:/sucesso"; // Página de sucesso
    }
}

