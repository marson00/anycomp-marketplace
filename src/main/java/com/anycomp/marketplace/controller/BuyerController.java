package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.findAll();
    }

    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable Long id) {
        return buyerService.findById(id);
    }

    @PostMapping
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerService.save(buyer);
    }

    @PutMapping("/{id}")
    public Buyer updateBuyer(@PathVariable Long id, @RequestBody Buyer buyer) {
        return buyerService.update(id, buyer);
    }

    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable Long id) {
        buyerService.delete(id);
    }
}
