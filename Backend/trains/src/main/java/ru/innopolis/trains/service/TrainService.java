package ru.innopolis.trains.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.trains.dto.TrainDto;
import ru.innopolis.trains.dto.TrainsSearchRequest;
import ru.innopolis.trains.model.Train;
import ru.innopolis.trains.repository.TrainRepository;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainRepository repository;
    private static final ZoneOffset MOSCOW_ZONE = ZoneOffset.ofHours(3);

    public List<TrainDto> getAllTrains() {
        return repository.findAll().stream().map(TrainDto::fromTrainModel).collect(Collectors.toList());
    }

    public Train getById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Train %d not found", id)));
    }

    public List<TrainDto> searchTrainByFilter(TrainsSearchRequest searchRequest) {
        Instant departureTimeFrom = localDateToInstant(searchRequest.getDepartureAt());
        Instant departureTimeTo = localDateToInstant(searchRequest.getDepartureAt().plusDays(1));
        return getTrainsBySearchRequest(searchRequest, departureTimeFrom, departureTimeTo)
            .stream()
            .map(TrainDto::fromTrainModel)
            .collect(Collectors.toList());
    }

    private List<Train> getTrainsBySearchRequest(
        TrainsSearchRequest searchRequest,
        Instant departureTimeFrom,
        Instant departureTimeTo
    ) {
        return repository.findAllByDepartureStationNameAndDestinationStationNameAndDepartureAtAfterAndDepartureAtBefore(
            searchRequest.getFromStationName(), searchRequest.getToStationName(), departureTimeFrom, departureTimeTo
        );
    }

    private Instant localDateToInstant(LocalDate localDate) {
        return Instant.ofEpochSecond(localDate.toEpochSecond(LocalTime.MIN, MOSCOW_ZONE));
    }
}
