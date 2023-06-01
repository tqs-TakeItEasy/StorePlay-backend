package storeplay.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeplay.backend.exception.ResourceNotFoundException;
import storeplay.backend.model.PickupPoint;
import storeplay.backend.model.Store;
import storeplay.backend.repository.PickupPointRepository;

import java.util.Optional;

@Service
public class PickupPointService {
    @Autowired
    PickupPointRepository pickupPointRepository;
    public  PickupPoint getPUPById(Long pupId) throws ResourceNotFoundException {
        Optional<PickupPoint> pup = pickupPointRepository.findById(pupId);

        if(pup.isPresent()){
            return pup.get();
        }else{
            throw new ResourceNotFoundException("This PickUp Point does not exist!");
        }
    }
}
