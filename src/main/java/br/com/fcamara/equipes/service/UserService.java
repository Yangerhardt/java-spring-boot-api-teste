package br.com.fcamara.equipes.service;

import br.com.fcamara.equipes.dto.ColaboradorDto;
import br.com.fcamara.equipes.model.Colaborador;
import br.com.fcamara.equipes.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public ColaboradorDto update(ColaboradorDto colaboradorDto) {
        Colaborador colaborador = colaboradorRepository.findById(colaboradorDto.getId())
                .orElseThrow(() -> new RuntimeException());

        colaborador.setNome(colaboradorDto.getNome());
        colaborador.setCargo(colaboradorDto.getCargo());
        return new ColaboradorDto(colaborador);
    }
}
