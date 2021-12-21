package wrthompsonjr.Greenlawn20.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wrthompsonjr.Greenlawn20.models.GraveSite;

@Repository
public interface GraveSiteRepository extends JpaRepository<GraveSite, Long> {

}
