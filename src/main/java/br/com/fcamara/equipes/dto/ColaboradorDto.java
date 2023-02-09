package br.com.fcamara.equipes.dto;

import br.com.fcamara.equipes.model.Cargo;
import br.com.fcamara.equipes.model.Colaborador;

import java.util.List;
import java.util.stream.Collectors;

public class ColaboradorDto {
    private String nome;
    private String cargo;

    public ColaboradorDto(Colaborador colaborador) {
        this.nome = colaborador.getNome();
        this.cargo = colaborador.getCargo();
    }

    public static List<ColaboradorDto> converter(List<Colaborador> colaboradores) {
        return colaboradores.stream().map(ColaboradorDto::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

}
