package com.softuni.book.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderCreatedEvent extends ApplicationEvent {

    private List<Long> allProductIds = new ArrayList<>();

    public OrderCreatedEvent(Object source) {
        super(source);
    }

    public OrderCreatedEvent addProduct(Long productId) {
        this.getAllProductIds().add(productId);
        return this;
    }
}
