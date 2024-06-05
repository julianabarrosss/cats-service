package org.example.cats.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cats.dtos.CatDTO;
import org.example.cats.dtos.SimpleCatDTO;
import org.example.cats.services.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "http://18.118.99.172:3000")
public class CatController {

    private final CatService catService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SimpleCatDTO cat) {
        log.info("CatController.save - START - Save new cat [{}]", cat.toString());

        catService.save(cat);

        log.info("CatController.save - END");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CatDTO>> findAll() {
        log.info("CatController.get - START - Find all cats");

        List<CatDTO> cat = catService.findAll();

        log.info("CatController.get - END");
        return ResponseEntity.status(HttpStatus.OK).body(cat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody SimpleCatDTO cat) {
        log.info("CatController.update - START - Update cat [{}]", cat.toString());

        catService.update(id, cat);

        log.info("CatController.update - END");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
