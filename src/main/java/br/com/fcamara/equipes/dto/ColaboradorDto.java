package br.com.fcamara.equipes.dto;

import br.com.fcamara.equipes.model.Cargo;
import br.com.fcamara.equipes.model.Colaborador;

import java.util.List;
import java.util.stream.Collectors;

public class ColaboradorDto {
    private Long id;
    private String nome;
    private Integer idade;
    private String cidade;

    public ColaboradorDto() {
    }

    public ColaboradorDto(Colaborador colaborador) {
        this.id = colaborador.getId();
        this.nome = colaborador.getNome();
        this.idade = colaborador.getIdade();
        this.cidade = colaborador.getCidade();
    }

    public static List<ColaboradorDto> converter(List<Colaborador> colaboradores) {
        return colaboradores.stream().map(ColaboradorDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public Integer getIdade() {
        return idade;
    }
}
