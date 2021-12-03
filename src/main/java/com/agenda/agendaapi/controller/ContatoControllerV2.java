package com.agenda.agendaapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Part;

import com.agenda.agendaapi.model.entity.Contato;
import com.agenda.agendaapi.model.repository.ContatoRepository;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contatosV2")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContatoControllerV2 {

    private final ContatoRepository repository;

    @GetMapping
    public List<Contato> list(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato save(@RequestBody Contato contato) {
        contato.setData(new Date());
        return repository.save(contato);
    } 

    @PutMapping
    public Contato update(@RequestBody Contato contato) throws Exception{
        Contato c = repository.findById(contato.getId()).orElseThrow( () -> new Exception("Not Found!BoxService"));
        c.setNome(contato.getNome());
        c.setEmail(contato.getEmail());
        c.setFavorito(contato.getFavorito());
        return repository.save(c);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
    

    @PatchMapping("{id}/favorito")
    public void favorite(@PathVariable Integer id) {
        Optional<Contato> contato = repository.findById(id);
        contato.ifPresent(c -> {
            boolean favorito = c.getFavorito() == Boolean.TRUE;
            c.setFavorito(!favorito);
            repository.save(c);
        });
    }
}
