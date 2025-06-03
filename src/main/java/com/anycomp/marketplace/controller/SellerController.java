package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.dto.SellerRequest;
import com.anycomp.marketplace.dto.SellerResponse;
import com.anycomp.marketplace.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping
    public Page<SellerResponse> getAllSellers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return sellerService.findAll(pageable);
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
