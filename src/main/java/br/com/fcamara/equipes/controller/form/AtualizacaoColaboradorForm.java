package br.com.fcamara.equipes.controller.form;

import br.com.fcamara.equipes.model.Cargo;
import br.com.fcamara.equipes.model.Colaborador;
import br.com.fcamara.equipes.repository.ColaboradorRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoColaboradorForm {

    @NotEmpty @NotNull
    private String nome;
    @NotEmpty @NotNull
    private Integer idade;
    @NotEmpty @NotNull
    private Cargo cargo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Colaborador atualizar(Long id, ColaboradorRepository colaboradorRepository) {
        Colaborador colaborar = colaboradorRepository.getReferenceById(id);

        colaborar.setNome(this.nome);
        colaborar.setIdade(this.idade);
        colaborar.setCargo(this.cargo);

        return colaborar;
    }
}
