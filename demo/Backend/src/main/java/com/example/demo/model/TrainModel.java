package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TrainModel")
@Getter
@Setter
public class TrainModel implements Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int trainNumber;
    private int stationCode;
    private String stationName;
    private Date arrivalTime;
    private Date departureTime;
    private int distance;
    private String sourceStation;
    private String sourceStationName;
    private String destinationStation;
    private String destinationStationName;

    public TrainModel() {
    }

    // standard constructors / setters / getters / toString
}


