package wrthompsonjr.Greenlawn20.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wrthompsonjr.Greenlawn20.models.CemeteryTag;

@Repository
public interface CemeteryTagRepository extends JpaRepository<CemeteryTag, Long> {

}
