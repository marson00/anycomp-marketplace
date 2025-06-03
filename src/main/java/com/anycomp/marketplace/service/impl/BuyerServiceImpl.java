package com.anycomp.marketplace.service.impl;

import com.anycomp.marketplace.dto.BuyerRequest;
import com.anycomp.marketplace.dto.BuyerResponse;
import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.mapper.BuyerMapper;
import com.anycomp.marketplace.repository.BuyerRepository;
import com.anycomp.marketplace.repository.PurchaseRepository;
import com.anycomp.marketplace.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final BuyerMapper buyerMapper;

    @Override
    public List<BuyerResponse> findAll() {
        return buyerRepository.findAll()
                .stream()
                .map(buyerMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BuyerResponse findById(Long id) {
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer ID " + id + " Not Found"));

        return buyerMapper.toResponse(buyer);
    }

    @Override
    public BuyerResponse save(BuyerRequest buyerRequest) {
        Buyer buyer = buyerMapper.toEntity(buyerRequest);
        Buyer savedBuyer = buyerRepository.save(buyer);

        return buyerMapper.toResponse(savedBuyer);
    }

    @Override
    public BuyerResponse update(Long id, BuyerRequest buyerRequest) {
        Buyer existingBuyer = buyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer ID " + id + " Not Found"));

        existingBuyer.setName(buyerRequest.getName());
        existingBuyer.setEmail(buyerRequest.getEmail());

        Buyer updatedBuyer = buyerRepository.save(existingBuyer);

        return buyerMapper.toResponse(updatedBuyer);
    }

    @Override
    public void delete(Long id) {
        Buyer existingBuyer = buyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer ID " + id + " Not Found"));

        buyerRepository.delete(existingBuyer);
    }
}
