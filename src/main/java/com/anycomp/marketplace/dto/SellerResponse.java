package com.anycomp.marketplace.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellerResponse {
    private Long id;
    private String name;
    private String email;
    private List<ItemDto> items;
}
