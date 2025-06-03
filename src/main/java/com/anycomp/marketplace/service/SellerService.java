package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> findAll();
    Seller findById(Long id);
    Seller save(Seller seller);
    Seller update(Long id, Seller seller);
    void delete(Long id);
}
