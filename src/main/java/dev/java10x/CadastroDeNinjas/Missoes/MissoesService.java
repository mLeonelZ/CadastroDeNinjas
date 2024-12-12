package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }


    // Listar todas as missoes:
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Listar por ID
    public MissoesModel missaoID(long id){
        Optional<MissoesModel> missaoID = missoesRepository.findById(id);
        return missaoID.orElse(null);
    }

    // Criar nova Missão
    public MissoesModel criarMissao(MissoesModel novaMissao){
        return missoesRepository.save(novaMissao);
    }

    // Deletar Missão
    public void deletarMissao(long id){
        missoesRepository.deleteById(id);
    }




}
