package dev.java10x.CadastroDeNinjas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    // controlador, fica entre o bd e o usuario

    @GetMapping("/boasVindas") // sempre colocar o /
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }


}
