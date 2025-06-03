package com.anycomp.marketplace.service;

import com.anycomp.marketplace.dto.SellerRequest;
import com.anycomp.marketplace.dto.SellerResponse;
import com.anycomp.marketplace.entity.Seller;

import java.util.List;

public interface SellerService {
    List<SellerResponse> findAll();
    SellerResponse findById(Long id);
    SellerResponse save(SellerRequest seller);
    SellerResponse update(Long id, SellerRequest seller);
    void delete(Long id);
}
