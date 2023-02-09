package br.com.fcamara.equipes.controller;

import br.com.fcamara.equipes.dto.ColaboradorDto;
import br.com.fcamara.equipes.model.Colaborador;
import br.com.fcamara.equipes.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @GetMapping
    public List<ColaboradorDto> listar() throws Exception {
        System.out.println("Procurando todos os colaboradores:");
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        return ColaboradorDto.converter(colaboradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> filtrar(@PathVariable Long id) throws Exception {
        return colaboradorRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ColaboradorDto cadastrar(@RequestBody Colaborador colaborador) throws Exception {
        System.out.println("Cadastrando o colaborador: " + colaborador.getNome());
        colaboradorRepository.save(colaborador);
        return new ColaboradorDto(colaborador);
    }


}



















