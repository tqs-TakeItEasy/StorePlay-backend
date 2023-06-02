package storeplay.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storeplay.backend.exception.ResourceNotFoundException;
import storeplay.backend.model.Store;
import storeplay.backend.repository.StoreRepository;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    public Store getStoreById(Long storeId) throws ResourceNotFoundException {
        Optional<Store> store = storeRepository.findById(storeId);

        if(store.isPresent()){
            return store.get();
        }else{
            throw new ResourceNotFoundException("This Store does not exist!");
        }
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}
