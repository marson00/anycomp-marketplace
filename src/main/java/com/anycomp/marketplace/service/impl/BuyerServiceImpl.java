package com.anycomp.marketplace.service.impl;

import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.repository.BuyerRepository;
import com.anycomp.marketplace.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer findById(Long id) {
        return buyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer ID " + id + " Not Found"));
    }

    @Override
    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer update(Long id, Buyer buyer) {
        Buyer existingBuyer = buyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer ID " + id + " Not Found"));

        existingBuyer.setName(buyer.getName());
        existingBuyer.setEmail(buyer.getEmail());

        return buyerRepository.save(existingBuyer);
    }

    @Override
    public void delete(Long id) {
        Buyer existingBuyer = buyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer ID " + id + " Not Found"));

        buyerRepository.delete(existingBuyer);
    }
}
