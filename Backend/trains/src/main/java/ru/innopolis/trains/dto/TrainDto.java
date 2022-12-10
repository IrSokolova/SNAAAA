package ru.innopolis.trains.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.innopolis.trains.model.Train;

@Data
@AllArgsConstructor
public class TrainDto {
    private Long trainNumber;
    private String departureStationName;
    private String destinationStationName;
    private Instant departureAt;
    private Instant arrivalAt;
    private BigDecimal distance;

    public static TrainDto fromTrainModel(Train train) {
        return new TrainDto(
            train.getTrainNumber(),
            train.getDepartureStationName(),
            train.getDestinationStationName(),
            train.getDepartureAt(),
            train.getArrivalAt(),
            train.getDistance()
        );
    }
}
