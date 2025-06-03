package com.anycomp.marketplace.service.impl;

import com.anycomp.marketplace.dto.SellerRequest;
import com.anycomp.marketplace.dto.SellerResponse;
import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.mapper.SellerMapper;
import com.anycomp.marketplace.repository.SellerRepository;
import com.anycomp.marketplace.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;

    @Override
    public Page<SellerResponse> findAll(Pageable pageable) {
//        return sellerRepository.findAll()
//                .stream()
//                .map(sellerMapper::toResponse)
//                .collect(Collectors.toList());

        return sellerRepository.findAll(pageable)
                .map(sellerMapper::toResponse);
    }

    @Override
    public SellerResponse findById(Long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller ID " + id + " Not Found"));

        return sellerMapper.toResponse(seller);
    }

    @Override
    public SellerResponse save(SellerRequest sellerRequest) {
        Seller seller = sellerMapper.toEntity(sellerRequest);
        Seller savedSeller = sellerRepository.save(seller);

        return sellerMapper.toResponse(savedSeller);
    }

    @Override
    public SellerResponse update(Long id, SellerRequest sellerRequest) {
        Seller existingSeller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller ID " + id + " Not Found"));

        existingSeller.setName(sellerRequest.getName());
        existingSeller.setEmail(sellerRequest.getEmail());

        Seller updatedSeller = sellerRepository.save(existingSeller);

        return sellerMapper.toResponse(updatedSeller);
    }

    @Override
    public void delete(Long id) {
        Seller existingSeller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller ID " + id + " Not Found"));

        sellerRepository.delete(existingSeller);
    }
}
