package com.example.productshop.services;

import com.example.productshop.models.dtos.CategorySeedDto;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories) throws JAXBException;
}
