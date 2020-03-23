package xyz.fandazky.tech.springkafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.fandazky.tech.springkafkaproducer.entity.NotificationRequest;
import xyz.fandazky.tech.springkafkaproducer.entity.NotificationResponse;
import xyz.fandazky.tech.springkafkaproducer.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public NotificationResponse publishNotification(@RequestBody NotificationRequest request) {
        return notificationService.publishNotification(request);
    }
}