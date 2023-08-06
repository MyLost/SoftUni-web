package com.softuni.book.service;

import com.softuni.book.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BonusPointService {

    @EventListener(OrderCreatedEvent.class)
    public void onOrderCreated(@NotNull OrderCreatedEvent event) {
        log.info("Bonus points added for products {}", event.getAllProductIds());
    }
}
