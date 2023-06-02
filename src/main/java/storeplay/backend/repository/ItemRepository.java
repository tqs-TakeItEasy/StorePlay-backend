package storeplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeplay.backend.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
