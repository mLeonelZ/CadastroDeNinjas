package dev.java10x.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    @OneToMany (mappedBy = "missoes")// Uma missao pode ter muitos ninjas
    @JsonIgnore // para ignorar a serializaçao e nao ter um loop infinito
    private List<NinjaModel> ninja;

}
