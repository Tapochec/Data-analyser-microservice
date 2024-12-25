package com.example.dataanalysermicroservice.service;

import com.example.dataanalysermicroservice.model.Data;
import com.example.dataanalysermicroservice.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaDataServiceImpl implements KafkaDataService {

    private final DataRepository dataRepository;

    public KafkaDataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void handl(Data data) {
        log.info("Data object {} was saved ", data);
        dataRepository.save(data);
    }
}
