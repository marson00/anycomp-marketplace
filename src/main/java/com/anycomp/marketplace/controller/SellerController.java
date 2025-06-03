package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.dto.SellerRequest;
import com.anycomp.marketplace.dto.SellerResponse;
import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping
    public List<SellerResponse> getAllSellers() {
        return sellerService.findAll();
    }

    @GetMapping("/{id}")
    public SellerResponse getSellerById(@PathVariable Long id) {
        return sellerService.findById(id);
    }

    @PostMapping
    public SellerResponse createSeller(@RequestBody SellerRequest seller) {
        return sellerService.save(seller);
    }

    @PutMapping("/{id}")
    public SellerResponse updateSeller(@PathVariable Long id, @RequestBody SellerRequest seller) {
        return sellerService.update(id, seller);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerService.delete(id);
    }
}
