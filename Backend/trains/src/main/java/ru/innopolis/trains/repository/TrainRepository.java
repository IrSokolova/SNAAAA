package ru.innopolis.trains.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.trains.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

    List<Train> findAllByDepartureStationNameAndDestinationStationNameAndDepartureAtAfterAndDepartureAtBefore(
        String departureStationName,
        String destinationStationName,
        Instant departureAtAfter,
        Instant departureAtBefore
    );
}
