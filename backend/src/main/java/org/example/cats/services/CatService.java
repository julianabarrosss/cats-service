package org.example.cats.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cats.dtos.CatDTO;
import org.example.cats.dtos.SimpleCatDTO;
import org.example.cats.entity.CatEntity;
import org.example.cats.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CatService {

    private CatRepository repository;

    public void save(SimpleCatDTO cat) {
        log.info("CatService.save - START - Save new cat [{}]", cat.toString());
        CatEntity entity = new CatEntity();

        entity.setName(cat.name());
        entity.setBirth(cat.birth());
        entity.setBreed(cat.breed());

        log.info("CatService.save - END");
        repository.save(entity);
    }

    public List<CatDTO> findAll() {
        log.info("CatService.findAll - START - Get all cats");

        List<CatEntity> entities = repository.findAll();

        return CatDTO.from(entities);
    }

    public void update(Long id, SimpleCatDTO cat) {
        log.info("CatService.update - START - Update cat [{}]", cat.toString());

        CatEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cat not found"));

        if (cat.name() != null && !cat.name().isEmpty())
            entity.setName(cat.name());

        if (cat.birth() != null && !cat.birth().toString().isEmpty())
            entity.setBirth(cat.birth());

        if (cat.breed() != null && !cat.breed().isEmpty())
            entity.setBreed(cat.breed());

        repository.save(entity);

        log.info("CatService.update - END");
    }
}
