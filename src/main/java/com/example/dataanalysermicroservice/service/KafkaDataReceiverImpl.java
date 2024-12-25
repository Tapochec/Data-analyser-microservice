package com.example.dataanalysermicroservice.service;

import com.example.dataanalysermicroservice.config.LocalDateTimeDeserializer;
import com.example.dataanalysermicroservice.model.Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

@Service
public class KafkaDataReceiverImpl implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> receiver;
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final KafkaDataService kafkaDataService;

    public KafkaDataReceiverImpl(KafkaReceiver<String, Object> receiver, LocalDateTimeDeserializer localDateTimeDeserializer, KafkaDataService kafkaDataService) {
        this.receiver = receiver;
        this.localDateTimeDeserializer = localDateTimeDeserializer;
        this.kafkaDataService = kafkaDataService;
    }

    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder().registerTypeAdapter(
                LocalDateTime.class, localDateTimeDeserializer).create();
        receiver.receive().subscribe(r -> {
            Data data = gson.fromJson(r.value().toString(), Data.class);
            kafkaDataService.handl(data);
            r.receiverOffset().acknowledge();
        });
    }
}
