package br.com.fcamara.equipes.service;

import br.com.fcamara.equipes.dto.ColaboradorDto;
import br.com.fcamara.equipes.model.Colaborador;
import br.com.fcamara.equipes.repository.ColaboradorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.Optional;

@Service
public class colaboradorService {

    public static ColaboradorRepository colaboradorRepository = null;

    public colaboradorService(ColaboradorRepository colaboradorRepository) {
        colaboradorService.colaboradorRepository = colaboradorRepository;
    }

    public static ColaboradorDto update(Long id, ColaboradorDto colaboradorDto) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        colaborador.setNome(colaboradorDto.getNome());
        colaborador.setIdade(colaboradorDto.getIdade());
        colaborador.setCidade(colaboradorDto.getCidade());
        return new ColaboradorDto(colaborador);
    }

    public static ResponseEntity<Colaborador> delete(Long id) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        colaboradorRepository.deleteById(id);
        return ResponseEntity.ok().body(colaborador);
    }
}
