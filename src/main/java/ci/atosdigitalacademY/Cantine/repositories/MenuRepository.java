package ci.atosdigitalacademY.Cantine.repositories;

import ci.atosdigitalacademY.Cantine.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
