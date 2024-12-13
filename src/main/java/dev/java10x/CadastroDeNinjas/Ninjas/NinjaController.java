package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // Injetando a dependencia do service
    private NinjaService ninjaService;

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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //mostrar todos os ninjas(read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // mostrar ninja por id(read)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasID(@PathVariable long id){
        return ninjaService.ninjaPorID(id);
    }

    //alterar dados dos ninjas(update)
    @PutMapping("/alterarID/{id}")
    public NinjaModel alterarNinjaID(@PathVariable long id,@RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //deletar ninja(delete)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable long id){
        ninjaService.deletarNinjaID(id);
    }


}
