package pl.gameshop.services;

import com.bryghts.ftypes.async.Long;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.gameshop.models.AvailabilityType;

public interface AvailabilityService {

    Page<AvailabilityType> getAllTypes(Pageable pageable);

    AvailabilityType getType(Long id);

    void deleteType(Long id);

    @Transactional
    AvailabilityType getType(java.lang.Long id);

    void deleteType(java.lang.Long id);

    void saveType(AvailabilityType type);


}
