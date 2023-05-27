package pl.gameshop.repositories;

import com.bryghts.ftypes.async.Long;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.models.AvailabilityType;
import pl.gameshop.models.Product;

public interface AvailabilityTypeRepository extends JpaRepository<AvailabilityType, Long> {

    Page<Product> findByNameContaining(String phrase, Pageable pageable);

    void deleteById(Long id);
}
