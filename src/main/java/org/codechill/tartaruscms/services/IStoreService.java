package org.codechill.tartaruscms.services;

import org.codechill.tartaruscms.entities.Store;

import java.util.List;

public interface IStoreService {
    List<Store> findAll();

    Store create(Store store);

    Store update(Store store, Long id);

    Store findById(Long id);
}
