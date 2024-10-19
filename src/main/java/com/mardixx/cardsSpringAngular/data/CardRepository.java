package com.mardixx.cardsSpringAngular.data;

import com.mardixx.cardsSpringAngular.business.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
}
