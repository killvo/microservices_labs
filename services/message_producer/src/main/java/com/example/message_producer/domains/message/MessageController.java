package com.example.message_producer.domains.message;

import com.example.message_producer.domains.message.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageProducerService messageProducer;

    @GetMapping("/publish")
    public void publishMessages() {
        messageProducer.publishToQueue("key1", new Message(1, "This is a test message"));
        messageProducer.publishToQueue("key2", new Message(2, "This is a test message"));
        messageProducer.publishToQueue("key1", new Message(3, "This is a test message"));
        messageProducer.publishToQueue("key2", new Message(4, "This is a test message"));
        messageProducer.publishToQueue("key1", new Message(5, "This is a test message"));
        messageProducer.publishToQueue("key2", new Message(6, "This is a test message"));
        messageProducer.publishToQueue("key1", new Message(7, "This is a test message"));
        messageProducer.publishToQueue("key2", new Message(8, "This is a test message"));
        messageProducer.publishToQueue("key1", new Message(9, "This is a test message"));
        messageProducer.publishToQueue("key2", new Message(10, "This is a test message"));
    }
}