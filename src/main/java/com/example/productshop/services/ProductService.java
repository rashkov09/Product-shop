package com.example.productshop.services;

import com.example.productshop.models.dtos.ProductSeedDto;

import java.util.List;

public interface ProductService {
    void seedProducts(List<ProductSeedDto> products);
}
