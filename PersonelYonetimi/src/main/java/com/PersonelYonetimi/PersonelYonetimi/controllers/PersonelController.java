package com.PersonelYonetimi.PersonelYonetimi.controllers;

import com.PersonelYonetimi.PersonelYonetimi.entities.Personel;
import com.PersonelYonetimi.PersonelYonetimi.exceptions.PersonelNotFoundException;
import com.PersonelYonetimi.PersonelYonetimi.responses.PersonelResponse;
import com.PersonelYonetimi.PersonelYonetimi.services.PersonelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personel")
public class PersonelController {
    private PersonelService personelService;

    public PersonelController(PersonelService personelService) {
        this.personelService = personelService;
    }

    @GetMapping
    public List<PersonelResponse> getAllPersonel() {
        return personelService.getAllPersonel().stream().map(u -> new PersonelResponse(u)).toList();
    }

    @PostMapping
    public ResponseEntity<Void> createPersonel(@RequestBody Personel newPersonel) {
        Personel personel = personelService.saveOnePersonel(newPersonel);
        if (personel != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{personelId}")
    public PersonelResponse getOnePersonel(@PathVariable Long personelId) {
        Personel personel = personelService.getOnePersonelById(personelId);
        if (personel == null) {
            throw new PersonelNotFoundException();
        }
        return new PersonelResponse(personel);
    }

    @PutMapping("/{personelId}")
    public ResponseEntity<Void> updateOnePersonel(@PathVariable Long personelId, @RequestBody Personel newPersonel) {
        Personel personel = personelService.updateOnePersonel(personelId, newPersonel);
        if (personel != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{personelId}")
    public void deleteOnePersonel(@PathVariable Long personelId) {
        personelService.deleteById(personelId);
    }

    @ExceptionHandler(PersonelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handlePersonelNotFound() {
    }
}
