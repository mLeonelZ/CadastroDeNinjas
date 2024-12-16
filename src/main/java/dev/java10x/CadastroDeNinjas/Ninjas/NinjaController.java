package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // Injetando a dependencia do service
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
    //---------------------------------

    // controlador, fica entre o bd e o usuario

    @GetMapping("/boasVindas") // sempre colocar o /
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }

    //adicionar ninja(create)
    @PostMapping("/cadastrar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){ // ResponseEntity para dar uma resposta para o usuario
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso! " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

    //mostrar todos os ninjas(read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> listaNinja = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaNinja);
    }

    // mostrar ninja por id(read)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasID(@PathVariable Long id){
        if(ninjaService.ninjaPorID(id) != null){
            return ResponseEntity.ok(ninjaService.ninjaPorID(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: " + id + " não encontrado!");

    }

    //alterar dados dos ninjas(update)
    @PutMapping("/alterarID/{id}")
    public ResponseEntity<?> alterarNinjaID(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {

        List<String> email = ninjaService.listarEmails();  // com base na lista de ninjas, cria uma nova lista apenas com os emails *VER NINJASERVICE*

        NinjaDTO ninjaAntigo = ninjaService.ninjaPorID(id); // Busca o ninja com o ID informado

        if(ninjaAntigo == null){ // Se o Id nao for encontrado encerra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: " + id + " não encontrado!");
        }
        // 1 - Vê se a lista de emails contem o email do ninjaAtualizado
        /* 2 - Vê se o email do Ninja Antigo e do Novo Ninja são iguais
            Se os emails forem iguai, é pq esta sendo mudado o próprio ninja,
            então ele nao entra nesse if e permite a atualização.
            Isso pq a resposta seria TRUE, mas com ! mudamos para False
            e isso permite sair da condição.
            Mas se o Email do Ninja Antigo e Ninja Novo forem diferentes,
            Ele Retorna False e depois Muda para True
        */
        if(email.contains(ninjaAtualizado.getEmail()) && !ninjaAtualizado.getEmail().equals(ninjaAntigo.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já está em uso por outro ninja!");
        }
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        return ResponseEntity.ok(ninja);
    }

    //deletar ninja(delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if(ninjaService.ninjaPorID(id) != null){
            NinjaDTO ninja = ninjaService.ninjaPorID(id);
            String tempNome = ninja.getNome();
            Long tempId = ninja.getId();
            ninjaService.deletarNinjaID(id);
            return ResponseEntity.ok("Ninja: " + tempNome + " ID: " + tempId + " Apagado com Sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Houve um erro! Ninja com ID:" + id + " não foi encontrado!");
    }


}
