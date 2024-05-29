package org.example.cats.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cats.dtos.CatDTO;
import org.example.cats.entity.CatEntity;
import org.example.cats.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CatService {

    private CatRepository repository;

    public void save(CatDTO cat) {
        log.info("CatService.save - START - Save new cat [{}]", cat.toString());
        CatEntity entity = new CatEntity();

        entity.setNome(cat.nome());
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
}
