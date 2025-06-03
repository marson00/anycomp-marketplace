package com.anycomp.marketplace.service;

import com.anycomp.marketplace.dto.SellerRequest;
import com.anycomp.marketplace.dto.SellerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SellerService {
    Page<SellerResponse> findAll(Pageable pageable);
    SellerResponse findById(Long id);
    SellerResponse save(SellerRequest seller);
    SellerResponse update(Long id, SellerRequest seller);
    void delete(Long id);
}
