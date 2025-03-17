package com.produtos.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.produtos.produto.model.Produto;
import com.produtos.produto.model.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;


    @GetMapping("/")
    public String listarProdutos(Model model){
        model.addAttribute("produtos", repository.findAll());
        return "lista";
    }

    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastro";
    }
    
    @PostMapping("/cadastro")
    public String cadastrar(Produto produto ) {
        repository.save(produto);
        return "redirect:/";
        
    }
    
}
