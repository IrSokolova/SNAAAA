package ru.innopolis.trains.model;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long trainNumber;
    private String departureStationName;
    private String destinationStationName;
    private Instant departureAt;
    private Instant arrivalAt;
    @Column(precision = 14, scale = 2)
    private BigDecimal distance;
}
