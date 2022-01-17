package com.example.Kafka.KafkaDemp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerGetMsg {


    @KafkaListener(topics="first-topic", groupId = "mygroupId")
    public void consumeFromTopic(String msg) {
        System.out.println("Following message reading from topics "+msg);
    }
}

