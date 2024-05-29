package org.example.cats.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cats.dtos.CatDTO;
import org.example.cats.services.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
@Slf4j
@AllArgsConstructor
public class CatController {

    private CatService catService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CatDTO cat) {
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
}
