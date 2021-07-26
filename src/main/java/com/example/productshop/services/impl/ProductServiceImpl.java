package com.example.productshop.services.impl;

import com.example.productshop.models.dtos.ProductSeedDto;
import com.example.productshop.models.entities.Product;
import com.example.productshop.repositories.ProductRepository;
import com.example.productshop.services.ProductService;
import com.example.productshop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProductServiceImpl implements ProductService {
    private final    ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        if (productRepository.count() > 0){
            return;
        }
        products
                .stream()
                .filter(validationUtil::isValid)
                .map(productSeedDto -> modelMapper.map(productSeedDto, Product.class))
                .forEach(product-> {

                });
    }
}
