package org.codechill.tartaruscms.services;

import org.codechill.tartaruscms.entities.Store;
import org.codechill.tartaruscms.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService implements IStoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store create(Store store) {
        return storeRepository.save(store);
    }

    public Store update(Store store, Long id) {
        Optional<Store> optionalStore = storeRepository.findById(id);
        Store dbStore = null;

        if (optionalStore.isPresent()) {
            dbStore = optionalStore.get();
            dbStore.setName(store.getName());
            storeRepository.save(dbStore);
        }

        return dbStore;
    }

    public Store findById(Long id) {
        Optional<Store> optionalStore = storeRepository.findById(id);
        Store store = null;

        if (optionalStore.isPresent()) {
            store = optionalStore.get();
        }

        return store;
    }
}
