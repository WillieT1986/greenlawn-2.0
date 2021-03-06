package wrthompsonjr.Greenlawn20.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wrthompsonjr.Greenlawn20.models.CemeterySection;

@Repository
public interface CemeterySectionRepository extends JpaRepository<CemeterySection, Long> {
    CemeterySection findOneByCemeterySection(String cemeterySection);
}
