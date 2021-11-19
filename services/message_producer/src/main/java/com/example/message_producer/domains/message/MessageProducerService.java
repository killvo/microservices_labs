package com.example.message_producer.domains.message;

import com.example.message_producer.domains.message.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    private static final String TOPIC = "message.2part.topic";

    public void publishToQueue(String key, Message value) {
        kafkaTemplate.send(TOPIC, key, value);
    }
}