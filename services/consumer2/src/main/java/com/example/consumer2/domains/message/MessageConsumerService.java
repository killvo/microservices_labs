package com.example.consumer2.domains.message;

import com.example.consumer2.domains.message.model.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    private static final String TOPIC = "message.2part.topic";

    @KafkaListener(topics = TOPIC)
    public void messageListener(ConsumerRecord<String, Message> consumerRecord, Acknowledgment ack) {

        String key = consumerRecord.key();
        Message value = consumerRecord.value();
        int partition = consumerRecord.partition();

        System.out.println("Consumed message : " + value
                + " with key : " + key
                + " from partition : "+ partition);

        ack.acknowledge();
    }
}