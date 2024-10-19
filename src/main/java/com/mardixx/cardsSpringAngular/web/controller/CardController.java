package com.mardixx.cardsSpringAngular.web.controller;

import com.mardixx.cardsSpringAngular.business.model.Card;
import com.mardixx.cardsSpringAngular.data.CardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/card")
@Log4j2
public class CardController {
    private  final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @ModelAttribute("newCards")
    public Iterable<Card> getNewCards() {
        return cardRepository.findAll();
    }

    @ModelAttribute
    public Card getCard() {
        return new Card();
    }

    @GetMapping
    public String showCardPage() {
        return "card";
    }

    @PostMapping
    public String saveCard(Card card) {
        cardRepository.save(card);
        return "redirect:card";
    }

    @PostMapping(params = "action=deleteAll")
    public String deleteAll() {
        cardRepository.deleteAll();
        return "redirect:card";
    }

    @PostMapping(params = "id")
    public String deleteCard(@RequestParam Long id) {
        log.info(cardRepository);
        cardRepository.deleteById(id);
        return "redirect:card";
    }
}
