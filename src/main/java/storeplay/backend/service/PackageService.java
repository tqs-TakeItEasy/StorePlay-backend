package storeplay.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeplay.backend.exception.ResourceNotFoundException;
import storeplay.backend.model.Package;
import storeplay.backend.repository.PackageRepository;

import java.util.Optional;

@Service
public class PackageService {

    @Autowired
    PackageRepository packageRepository;

    public Package addPackage(Package package_item) {
        return packageRepository.save(package_item);
    }


    public Package updateDeliveryId(Long id, Long deliveryID) throws ResourceNotFoundException {
        Optional<Package> package_item = packageRepository.findById(id);

        if (package_item.isPresent()){
            Package package_i = package_item.get();
            package_i.setDelivery_id(deliveryID);
            packageRepository.save(package_i);
            return package_i;
        } else {
            throw new ResourceNotFoundException("This Package does not exist!");
        }
    }
}
