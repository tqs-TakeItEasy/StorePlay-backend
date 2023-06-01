package storeplay.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeplay.backend.model.Package;
import storeplay.backend.model.Store;
import storeplay.backend.repository.StoreRepository;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}
