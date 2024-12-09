package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // usado para criar uma entidade no BD, criar uma tabela com nome, email e idade
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne // Muitos ninjas podem ter uma missao
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;



}





