package az.ingress.msunittesting.dao.repository;

import az.ingress.msunittesting.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author caci
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
