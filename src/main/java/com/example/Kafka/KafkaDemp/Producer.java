package com.example.Kafka.KafkaDemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void ProducersendMsg(String str){
        kafkaTemplate.send("first-topic",str);
        System.out.println("following message is sending topic first-topic "+ str);
    }

}
