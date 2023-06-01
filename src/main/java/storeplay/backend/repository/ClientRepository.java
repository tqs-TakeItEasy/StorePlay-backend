package storeplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeplay.backend.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
