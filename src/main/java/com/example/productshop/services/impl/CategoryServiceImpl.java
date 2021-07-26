package com.example.productshop.services.impl;

import com.example.productshop.models.dtos.CategorySeedDto;
import com.example.productshop.models.entities.Category;
import com.example.productshop.repositories.CategoriesRepository;
import com.example.productshop.services.CategoryService;
import com.example.productshop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {
    private final CategoriesRepository categoriesRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;



    public CategoryServiceImpl(CategoriesRepository categoriesRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoriesRepository = categoriesRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;

    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) throws JAXBException {
        if (categoriesRepository.count() > 0){
            return;
        }
        categories
                .stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoriesRepository::save);

    }
}
