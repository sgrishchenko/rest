package com.example.simple.controller;

import com.example.model.entity.Client;
import com.example.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(ClientRestController.PATH)
public class ClientRestController {
    final static String PATH = "/client";
    private final ClientRepository clientRepository;

    @Autowired
    public ClientRestController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client, HttpServletResponse response) {
        client.setId(null);
        clientRepository.save(client);

        response.setHeader("Location", ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(PATH + "/" + client.getId())
                .toUriString());
        return client;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> read(@PathVariable Long id) {
        if (!clientRepository.exists(id)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(clientRepository.getOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Client client) {
        if (!clientRepository.exists(id)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        client.setId(id);
        clientRepository.save(client);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientRepository.delete(id);
    }
}
