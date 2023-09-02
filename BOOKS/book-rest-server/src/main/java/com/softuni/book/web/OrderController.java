package com.softuni.book.web;

import com.softuni.book.model.dtos.OrderDto;
import com.softuni.book.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/dummy/create")
    void createDummyOrder() {
        OrderDto dummyOrderDto = new OrderDto();
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            dummyOrderDto.addProduct(rand.nextLong(100));
        }

        orderService.createOrder(dummyOrderDto);
    }
}
