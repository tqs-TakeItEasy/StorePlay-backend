package storeplay.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storeplay.backend.exception.ResourceNotFoundException;
import storeplay.backend.model.Package;
import storeplay.backend.repository.PackageRepository;

@Service
public class PackageService {

    @Autowired
    PackageRepository packageRepository;

    public Package addPackage(Package package_item) {
        return packageRepository.save(package_item);
    }

    public Package updatePackage(Package packageToUpdate) throws ResourceNotFoundException {
        Optional<Package> existingPackage = packageRepository.findById(packageToUpdate.getId());

        if (existingPackage.isPresent()){
            packageToUpdate.setId(existingPackage.get().getId());
            Package updatedPackage = packageRepository.save(packageToUpdate);
            return updatedPackage;
        } else {
            throw new ResourceNotFoundException("This Package does not exist!");
        }
    }
}
