package com.anycomp.marketplace.service;

import com.anycomp.marketplace.dto.BuyerRequest;
import com.anycomp.marketplace.dto.BuyerResponse;

import java.util.List;

public interface BuyerService {
    List<BuyerResponse> findAll();
    BuyerResponse findById(Long id);
    BuyerResponse save(BuyerRequest buyer);
    BuyerResponse update(Long id, BuyerRequest buyer);
    void delete(Long id);
}
