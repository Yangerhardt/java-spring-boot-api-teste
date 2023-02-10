package br.com.fcamara.equipes.controller;

import br.com.fcamara.equipes.dto.ColaboradorDto;
import br.com.fcamara.equipes.model.Colaborador;
import br.com.fcamara.equipes.repository.ColaboradorRepository;
import br.com.fcamara.equipes.service.colaboradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static br.com.fcamara.equipes.service.colaboradorService.colaboradorRepository;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @GetMapping
    public List<ColaboradorDto> listar() throws Exception {
        System.out.println("Procurando todos os colaboradores:");
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        return ColaboradorDto.converter(colaboradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDto> filtrar(@PathVariable Long id) throws Exception {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        return colaborador.map(value -> ResponseEntity.ok(new ColaboradorDto(value))).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    @Transactional
    public ResponseEntity<Colaborador> cadastrar(@RequestBody @Valid Colaborador colaborador) throws Exception {
        System.out.println("Cadastrando o colaborador: " + colaborador.getNome());
        colaboradorRepository.save(colaborador);

        return ResponseEntity.ok().body(colaborador);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ColaboradorDto> update(@PathVariable Long id, @RequestBody ColaboradorDto colaboradorDto) {
        System.out.println("Atualizando o usuário de id: " + id);
        return ResponseEntity.ok(colaboradorService.update(id, colaboradorDto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseEntity<Colaborador>> delete(@PathVariable Long id) {
        System.out.println("Removendo o usuário de id: " + id);
        return ResponseEntity.ok(colaboradorService.delete(id));
    }
}



















