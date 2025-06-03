package com.anycomp.marketplace.dto;

import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Long sellerId;
}
