package storeplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeplay.backend.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
}
