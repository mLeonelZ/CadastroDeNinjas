package dev.java10x.CadastroDeNinjas.Ninjas;

// import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // diz que aqui é uma camada de serviço
public class NinjaService {

    //@Autowired // Inicializa os construtores
    private final NinjaRepository ninjaRepository; // conectar ao repositório // INJEÇAO DE DEPENDENCIA
    NinjaMapper ninjaMapper;

    // Boa pratica injetar com o construtor
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    // MÉTODOS

    // Lógica para listar todos os ninjas:
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }

    // Lógica para listar apenas os Emails
    public List<String> listarEmails(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream().map(NinjaModel::getEmail).toList();  // com base na lista de ninjas, cria uma nova lista apenas com os emails
    }

    // Lógica Buscar Ninja por ID
    public NinjaDTO ninjaPorID(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    // Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        return ninjaMapper.map(ninjaRepository.save(ninja));
    }

    // Deletar Ninja TEM QUE SER VOID
    public void deletarNinjaID(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja
    public NinjaDTO atualizarNinja(Long id,NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
