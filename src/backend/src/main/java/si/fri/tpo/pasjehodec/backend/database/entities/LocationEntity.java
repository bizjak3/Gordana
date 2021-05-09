package si.fri.tpo.pasjehodec.backend.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
public class LocationEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime date;
    private double geoLat;
    private double geoLon;

    @ManyToOne
    @JoinColumn
    private ServiceEntity service;

    @ManyToOne
    @JoinColumn
    private ServiceDiaryEntity serviceDiary;

}
