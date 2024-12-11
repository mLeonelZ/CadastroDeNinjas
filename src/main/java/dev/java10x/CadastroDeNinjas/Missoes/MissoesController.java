package dev.java10x.CadastroDeNinjas.Missoes;

// Criar rotas para o servidor para poder realizar o CRUD
// LOCALHOST:8080/criar ... etc ...
// LOCALHOST:8080/criar ... etc ...
// LOCALHOST:8080/criar ... etc ...
// LOCALHOST:8080/deletar ... etc ...

import org.springframework.web.bind.annotation.*;

@RestController // Diz que tudo que esta aqui é um controller
@RequestMapping("missoes") // tudo que for colocado pode ser mapeado nas apis // Cria um caminho "missoes" para depois poder (criar)
public class MissoesController {

    @PostMapping("/cadastrar") //O usuario envia os dados
    public String criarMissao(){
        return "Criar missao";
    }
    @GetMapping("/listar") // O usuario pode ver todas as missoes
    public String listarMissao(){
        return "Listar missoes";
    }
    @PutMapping("/alterar") // O usuario pode alterar dados
    public String alterarMissao(){
        return "Alterar missao";
    }
    @DeleteMapping("/deletar") // O usuario pode deletar uma missao
    public String deletarMissao(){
        return "Deletar missao";
    }


}
