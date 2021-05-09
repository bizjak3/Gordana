package si.fri.tpo.pasjehodec.backend.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="service")
@Getter
@Setter
@NoArgsConstructor
public class ServiceEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;
    private String restrictions;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity author;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private Set<LocationEntity> locations;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private Set<ServiceDiaryEntity> serviceDiaries;

}
