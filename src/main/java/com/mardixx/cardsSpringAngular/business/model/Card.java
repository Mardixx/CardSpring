package com.mardixx.cardsSpringAngular.business.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String photoFile;
    private String title;


    private List<String> genres;
    private LocalDate releaseDate;
    private String description;
}
