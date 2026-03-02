package com.foro.foro.controller;

import com.foro.foro.domain.dto.TopicoCreateRequest;
import com.foro.foro.domain.dto.TopicoUpdateRequest;
import com.foro.foro.domain.model.Topico;
import com.foro.foro.exception.ResourceNotFoundException;
import com.foro.foro.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Topico crear(@RequestBody @Valid TopicoCreateRequest request) {
        Topico topico = new Topico(request.getTitulo(), request.getMensaje());
        return topicoRepository.save(topico);
    }

    @GetMapping("/{id}")
    public Topico obtenerPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado"));
    }

    @PutMapping("/{id}")
    public Topico actualizar(@PathVariable Long id,
                             @RequestBody @Valid TopicoUpdateRequest request) {

        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado"));

        topico.setTitulo(request.getTitulo());
        topico.setMensaje(request.getMensaje());
        topico.setStatus(request.getStatus());

        return topicoRepository.save(topico);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado"));

        topicoRepository.delete(topico);
    }
}