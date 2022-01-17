package com.example.Kafka.KafkaDemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    Producer p1;

    @PostMapping(value="/post")
    public void sendmsg(@RequestParam("msg") String msg){
        p1.ProducersendMsg(msg);


    }
}
