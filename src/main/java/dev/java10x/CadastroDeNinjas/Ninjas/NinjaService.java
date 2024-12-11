package dev.java10x.CadastroDeNinjas.Ninjas;

// import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service // diz que aqui é uma camada de serviço
public class NinjaService {

    //@Autowired // Inicializa os construtores
    private NinjaRepository ninjaRepository; // conectar ao repositório // INJEÇAO DE DEPENDENCIA

    // Boa pratica injetar com o construtor
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Lógica para listar todos os ninjas:
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }




}
