package ru.innopolis.trains.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TrainsSearchRequest {
    private String fromStationName;
    private String toStationName;
    private LocalDate departureAt;
}
