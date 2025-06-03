package com.anycomp.marketplace.service;

import com.anycomp.marketplace.dto.BuyerRequest;
import com.anycomp.marketplace.dto.BuyerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuyerService {
    Page<BuyerResponse> findAll(Pageable pageable);
    BuyerResponse findById(Long id);
    BuyerResponse save(BuyerRequest buyer);
    BuyerResponse update(Long id, BuyerRequest buyer);
    void delete(Long id);
}
