package br.com.fcamara.equipes.controller;

import br.com.fcamara.equipes.controller.form.AtualizacaoColaboradorForm;
import br.com.fcamara.equipes.dto.ColaboradorDto;
import br.com.fcamara.equipes.model.Colaborador;
import br.com.fcamara.equipes.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<ColaboradorDto> filtrar(@PathVariable Long id) throws Exception {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isPresent()) {
            return ResponseEntity.ok(new ColaboradorDto(colaborador.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Colaborador> cadastrar(@RequestBody Colaborador colaborador) throws Exception {
        System.out.println("Cadastrando o colaborador: " + colaborador.getNome());
        colaboradorRepository.save(colaborador);

        return ResponseEntity.ok().body(colaborador);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoColaboradorForm attColaboradorForm) {
        Optional<Colaborador> optional = colaboradorRepository.findById(id);
        if (optional.isPresent()) {
            Colaborador colaborador = attColaboradorForm.atualizar(id, colaboradorRepository);
            colaboradorRepository.save(colaborador);
            return ResponseEntity.ok().body(colaborador);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isPresent()) {
            colaboradorRepository.deleteById(id);
            return ResponseEntity.ok().body(colaborador);
        }
        return ResponseEntity.notFound().build();
    }
}



















