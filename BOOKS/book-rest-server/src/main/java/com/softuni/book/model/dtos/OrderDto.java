package com.softuni.book.model.dtos;

import com.softuni.book.events.OrderCreatedEvent;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class OrderDto {

    private List<Long> productIds;


    public OrderDto addProduct(Long productId) {
        this.productIds.add(productId);
        return this;
    }
}
