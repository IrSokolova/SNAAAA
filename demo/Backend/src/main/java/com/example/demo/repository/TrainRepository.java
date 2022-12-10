package com.example.demo.repository;

import com.example.demo.model.TrainModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends CrudRepository<TrainModel, Long> {
    @Query("FROM TrainModel WHERE sourceStationName = :sourceStationName")
    public List<TrainModel> findBySourceStationName(@Param("sourceStationName") String sourceStationName);

    @Query("FROM TrainModel WHERE destinationStationName = :destinationStationName")
    public List<TrainModel> findByDestinationStationName(@Param("destinationStationName") String destinationStationName);

    @Query("FROM TrainModel")
    public List<TrainModel> findAll();

}
