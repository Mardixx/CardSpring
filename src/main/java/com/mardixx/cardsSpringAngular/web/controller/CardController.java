package com.mardixx.cardsSpringAngular.web.controller;

import com.mardixx.cardsSpringAngular.business.model.Card;
import com.mardixx.cardsSpringAngular.business.service.CardService;
import com.mardixx.cardsSpringAngular.data.CardRepository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
@Log4j2
public class CardController {
    @Autowired
    private CardService cardService;

    /*@ModelAttribute("newCards")
    public Iterable<Card> getNewCards() {
        return cardRepository.findAll();
    }

    @ModelAttribute
    public Card getCard() {
        return new Card();
    }*/

    /*@GetMapping
    public String showCardPage() {
        return "card";
    }*/
    @GetMapping
    public Iterable<Card> getAllCards() {
        return cardService.findAll();
    }

    @PostMapping
    public Card save(@RequestBody Card card) {
        return cardService.save(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        log.info(id);
        cardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<Card> getCardById(@PathVariable Long id) {
        return cardService.findById(id);
    }

    /*@PostMapping
    public String saveCard(@Valid Card card, Errors errors) {
        if (!errors.hasErrors()) {
            cardService.save(card);
            return "redirect:card";
        }
        return "card";
    }*/

    /*@PostMapping(params = "action=deleteAll")
    public String deleteAll() {
        cardService.deleteAll();
        return "redirect:card";
    }*/

    /*@PostMapping(params = "id")
    public String deleteCard(@RequestParam Long id) {
        log.info(cardService);
        cardService.deleteById(id);
        return "redirect:card";
    }*/
}
