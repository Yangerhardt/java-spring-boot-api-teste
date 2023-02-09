package br.com.fcamara.equipes.dto;

import br.com.fcamara.equipes.model.Cargo;
import br.com.fcamara.equipes.model.Colaborador;

import java.util.List;
import java.util.stream.Collectors;

public class ColaboradorDto {
    private Long id;
    private String nome;
    private Cargo cargo;

    public ColaboradorDto(Colaborador colaborador) {
        this.id = colaborador.getId();
        this.nome = colaborador.getNome();
        this.cargo = colaborador.getCargo();
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

    public Cargo getCargo() {
        return cargo;
    }

}
