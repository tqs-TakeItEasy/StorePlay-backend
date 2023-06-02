package storeplay.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storeplay.backend.exception.ResourceNotFoundException;
import storeplay.backend.model.Client;
import storeplay.backend.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    
    public Client getStoreById(Long clientId) throws ResourceNotFoundException {
        Optional<Client> client =  clientRepository.findById(clientId);

        if(client.isPresent()){
            return client.get();
        }else{
            throw new ResourceNotFoundException("This Client does not exist!");
        }

    }
}
