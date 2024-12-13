package dev.java10x.CadastroDeNinjas.Ninjas;

// import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // diz que aqui é uma camada de serviço
public class NinjaService {

    //@Autowired // Inicializa os construtores
    private final NinjaRepository ninjaRepository; // conectar ao repositório // INJEÇAO DE DEPENDENCIA
    NinjaMapper ninjaMapper = new NinjaMapper();

    // Boa pratica injetar com o construtor
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Lógica para listar todos os ninjas:
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // Lógica Buscar Ninja por ID
    public NinjaModel ninjaPorID(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        return ninjaMapper.map(ninjaRepository.save(ninja));
    }

    // Deletar Ninja TEM QUE SER VOID
    public void deletarNinjaID(long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja
    public NinjaModel atualizarNinja(long id,NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
