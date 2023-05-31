package storeplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeplay.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
