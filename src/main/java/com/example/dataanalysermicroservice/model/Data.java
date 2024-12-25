package com.example.dataanalysermicroservice.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "data")
public class Data {

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", sensorId=" + sensorId +
                ", timestamp=" + timestamp +
                ", measurement=" + measurement +
                ", measurementType=" + measurementType +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum MeasurementType {
        TEMPERATURE,
        VOLTAGE,
        POWER
    }

    private Long sensorId;
    private LocalDateTime timestamp; //время отправления
    private double measurement; //значение, которое прислал датчик

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private MeasurementType measurementType;

    public Data() {
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }


    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }



}
