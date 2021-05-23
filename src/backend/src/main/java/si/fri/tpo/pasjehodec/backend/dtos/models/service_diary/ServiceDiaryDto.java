package si.fri.tpo.pasjehodec.backend.dtos.models.service_diary;

import lombok.Data;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.LocationEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.TransactionEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.dogo.DogoDto;
import si.fri.tpo.pasjehodec.backend.dtos.models.service.ServiceDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class ServiceDiaryDto {
    private Integer id;

    @Min(1)
    @Max(5)
    private int assess;

    private String status;

    private DogoEntity dogo;
    private ServiceEntity service;

//    private Set<LocationEntity> locations;
//
//    private Set<TransactionEntity> transactions;
}
