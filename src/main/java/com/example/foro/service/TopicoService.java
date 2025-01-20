package com.example.foro.service;

import com.example.foro.model.Topico;
import com.example.foro.repository.TopicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepositorio topicoRepository;  // Mantén el nombre consistente

    public Topico guardar(Topico topico) {
        return topicoRepository.save(topico);  // Cambié 'topicoRepositorio' a 'topicoRepository'
    }

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();  // Cambié 'topicoRepositorio' a 'topicoRepository'
    }

    public Optional<Topico> obtenerPorId(Long id) {
        return topicoRepository.findById(id);  // Cambié 'topicoRepositorio' a 'topicoRepository'
    }

    public void eliminar(Long id) {
        topicoRepository.deleteById(id);  // Cambié 'topicoRepositorio' a 'topicoRepository'
    }
}
