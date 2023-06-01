package storeplay.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeplay.backend.model.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
}
