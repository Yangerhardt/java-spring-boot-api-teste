package br.com.fcamara.equipes.controller;

import br.com.fcamara.equipes.model.Colaborador;
import br.com.fcamara.equipes.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> listar() {
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
    }
}
