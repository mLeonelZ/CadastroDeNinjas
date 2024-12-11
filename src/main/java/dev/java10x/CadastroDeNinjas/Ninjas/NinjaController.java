package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // controlador, fica entre o bd e o usuario

    @GetMapping("/boasVindas") // sempre colocar o /
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }

    //adicionar ninja(create)
    @PostMapping("/cadastrar")
    public String criarNinja(){
        return "ninja criado";
    }

    //mostrar todos os ninjas(read)
    @GetMapping("/listar")
    public String mostrarTodosNinjas(){
        return "todos ninjas";
    }

    // mostrar ninja por id(read)
    @GetMapping("/listarID")
    public String mostrarTodosNinjasID(){
        return "todos ninjas por ID";
    }

    //alterar dados dos ninjas(update)
    @PutMapping("/alterarID")
    public String alterarNinjaID(){
        return "Alterar ninja por ID";
    }

    //deletar ninja(delete)
    @DeleteMapping("/deletarID")
    public String deletarNinjaID(){
        return "Deletar por ID";
    }


}
