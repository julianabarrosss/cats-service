package org.example.cats.dtos;

import org.example.cats.entity.CatEntity;

import java.time.LocalDate;
import java.util.List;

public record CatDTO(String nome, String breed, LocalDate birth) {
    public static List<CatDTO> from(List<CatEntity> entities) {
        return entities.stream()
                .map(entity -> new CatDTO(entity.getNome(), entity.getBreed(), entity.getBirth()))
                .toList();
    }
}
