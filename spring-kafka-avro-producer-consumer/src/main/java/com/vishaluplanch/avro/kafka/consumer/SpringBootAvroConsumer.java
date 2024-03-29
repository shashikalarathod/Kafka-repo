package com.vishaluplanch.avro.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.vishaluplanch.avro.schema.StockHistory;

@Service
public class SpringBootAvroConsumer {

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<String, StockHistory> record){
        String key=record.key();
        StockHistory history=record.value();
        System.out.println("Avro message received for key : "+key+ " value : "+history.toString());
    }

}
