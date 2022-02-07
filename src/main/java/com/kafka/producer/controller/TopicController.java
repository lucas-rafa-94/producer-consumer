package com.kafka.producer.controller;

import com.kafka.producer.service.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kafka")
public class TopicController {
    @Autowired
    TopicProducer topicProducer;

    @PostMapping
    public void init(){
       for (int i = 0; i < 1000; i++){
           topicProducer.send("Teste " + i);
       }
    }
}
