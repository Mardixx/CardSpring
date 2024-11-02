package com.mardixx.cardsSpringAngular.business.service;

import com.mardixx.cardsSpringAngular.business.model.Card;
import com.mardixx.cardsSpringAngular.data.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public Optional<Card> findById(Long id) {
        return cardRepository.findById(id);
    }

    public Iterable<Card> findAll() {
        return cardRepository.findAll();
    }

    public void deleteById(Long id) {
        if (cardRepository.existsById(id)) {
            cardRepository.deleteById(id);
        } else {
            throw new RuntimeException("Card not found with id: " + id);
        }
    }

    public void delete(Card card) {
        cardRepository.delete(card);
    }

    public void deleteAll() {
        cardRepository.deleteAll();
    }
}
