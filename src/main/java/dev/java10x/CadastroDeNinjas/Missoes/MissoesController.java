package dev.java10x.CadastroDeNinjas.Missoes;

// Criar rotas para o servidor para poder realizar o CRUD
// LOCALHOST:8080/criar ... etc ...
// LOCALHOST:8080/criar ... etc ...
// LOCALHOST:8080/criar ... etc ...
// LOCALHOST:8080/deletar ... etc ...

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Diz que tudo que esta aqui é um controller
@RequestMapping("missoes") // tudo que for colocado pode ser mapeado nas apis // Cria um caminho "missoes" para depois poder (criar)

public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/cadastrar") //O usuario envia os dados
    public MissoesModel criarMissao(@RequestBody MissoesModel novaMissao){
        return missoesService.criarMissao(novaMissao);
    }

    @GetMapping("/listar") // O usuario pode ver todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("listar/{id}")
    public MissoesModel listarMissoesID(long id){
        return missoesService.missaoID(id);
    }

    @PutMapping("/alterar") // O usuario pode alterar dados
    public String alterarMissao(long id){
        return "Alterar missao";
    }

    @DeleteMapping("/deletar/{id}") // O usuario pode deletar uma missao
    public void deletarMissao(@PathVariable long id){
        missoesService.deletarMissao(id);
    }


}
