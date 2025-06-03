package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.dto.BuyerRequest;
import com.anycomp.marketplace.dto.BuyerResponse;
import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @GetMapping
    public Page<BuyerResponse> getAllBuyers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return buyerService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public BuyerResponse getBuyerById(@PathVariable Long id) {
        return buyerService.findById(id);
    }

    @PostMapping
    public BuyerResponse createBuyer(@RequestBody BuyerRequest buyer) {
        return buyerService.save(buyer);
    }

    @PutMapping("/{id}")
    public BuyerResponse updateBuyer(@PathVariable Long id, @RequestBody BuyerRequest buyer) {
        return buyerService.update(id, buyer);
    }

    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable Long id) {
        buyerService.delete(id);
    }
}
