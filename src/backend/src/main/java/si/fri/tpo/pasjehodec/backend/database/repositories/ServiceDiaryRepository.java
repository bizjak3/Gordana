package si.fri.tpo.pasjehodec.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;

@Repository
public interface ServiceDiaryRepository extends JpaRepository<ServiceDiaryEntity, Integer> {
}
