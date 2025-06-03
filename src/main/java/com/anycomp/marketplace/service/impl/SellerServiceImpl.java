package com.anycomp.marketplace.service.impl;

import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.repository.SellerRepository;
import com.anycomp.marketplace.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ResourceUrlProvider resourceUrlProvider;

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller ID " + id + " Not Found"));
    }

    @Override
    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller update(Long id, Seller seller) {
        Seller existingSeller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller ID " + id + " Not Found"));

        existingSeller.setName(seller.getName());
        existingSeller.setEmail(seller.getEmail());

        return sellerRepository.save(existingSeller);
    }

    @Override
    public void delete(Long id) {
        Seller existingSeller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller ID " + id + " Not Found"));

        sellerRepository.delete(existingSeller);
    }
}
