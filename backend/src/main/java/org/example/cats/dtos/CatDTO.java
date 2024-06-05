package org.example.cats.dtos;

import org.example.cats.entity.CatEntity;

import java.time.LocalDate;
import java.util.List;

public record CatDTO(Long id, String name, String breed, LocalDate birth) {
    public static List<CatDTO> from(List<CatEntity> entities) {
        return entities.stream()
                .map(entity -> new CatDTO(entity.getId(), entity.getName(), entity.getBreed(), entity.getBirth()))
                .toList();
    }
}
