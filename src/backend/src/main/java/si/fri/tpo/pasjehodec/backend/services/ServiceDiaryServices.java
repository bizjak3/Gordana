package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.DogoRepository;
import si.fri.tpo.pasjehodec.backend.database.repositories.ServiceDiaryRepository;
import si.fri.tpo.pasjehodec.backend.database.repositories.ServiceRepository;

@Service
@RequiredArgsConstructor
public class ServiceDiaryServices {

    private final ServiceDiaryRepository serviceDiaryRepository;
    private final DogoRepository dogoRepository;
    private final ServiceRepository serviceRepository;

    public ServiceDiaryEntity createNewServiceDiary(ServiceDiaryEntity entity, Integer dogoId, Integer serviceId) {
        entity.setDogo(dogoRepository.getOne(dogoId));
        entity.setService(serviceRepository.getOne(serviceId));
        entity.setStatus("Narocena storitev");
        return serviceDiaryRepository.save(entity);
    }

    public ServiceDiaryEntity addRating(Integer id, int rating) {
        if (serviceDiaryRepository.getSDbyService(id).isPresent()) {
            ServiceDiaryEntity serviceDiaryEntity = serviceDiaryRepository.getSDbyService(id).get();
            serviceDiaryEntity.setAssess(rating);
            serviceDiaryEntity.setStatus("zakljuceno");
            serviceDiaryRepository.save(serviceDiaryEntity);
            return serviceDiaryEntity;
        }
        else return null;
    }

}
