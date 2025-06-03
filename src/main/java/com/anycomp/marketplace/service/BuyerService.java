package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Buyer;

import java.util.List;

public interface BuyerService {
    List<Buyer> findAll();
    Buyer findById(Long id);
    Buyer save(Buyer buyer);
    Buyer update(Long id, Buyer buyer);
    void delete(Long id);
}
