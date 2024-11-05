package com.mardixx.cardsSpringAngular.business.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue
    private Long id;

//    @NotEmpty(message = "Photo File cannot be empty")
    private String photoFile;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @NotEmpty(message = "Genres cannot be empty")
    private List<String> genres;

    @NotNull(message = "Release Date cannot be empty")
    private LocalDate releaseDate;

    @Size(min = 15, max = 2500, message = "Min size is 15 characters and max size is 2500 characters")
    private String description;
}
