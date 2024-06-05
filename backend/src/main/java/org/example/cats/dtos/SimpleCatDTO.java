package org.example.cats.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SimpleCatDTO(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Breed is required")
        String breed,
        @NotNull(message = "Birth is required and must be a valid date YYYY-MM-DD")
        LocalDate birth) {
}
