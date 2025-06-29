package repository;

import model.Expanse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpanseRepository extends JpaRepository<Expanse, String> {
}
