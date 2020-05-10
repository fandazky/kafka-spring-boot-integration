package xyz.fandazky.tech.springkafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fandazky.tech.springkafkaproducer.entity.KafkaOrderCreate;
import xyz.fandazky.tech.springkafkaproducer.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public KafkaOrderCreate publishNotification(@RequestBody KafkaOrderCreate request) {
        return orderService.createOrder(request);
    }
}