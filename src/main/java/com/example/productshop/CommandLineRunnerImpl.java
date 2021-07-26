package com.example.productshop;

import com.example.productshop.models.dtos.CategorySeedDto;
import com.example.productshop.models.dtos.CategorySeedRootDto;
import com.example.productshop.models.dtos.ProductSeedRootDto;
import com.example.productshop.models.entities.Category;
import com.example.productshop.services.CategoryService;
import com.example.productshop.services.ProductService;
import com.example.productshop.services.UserService;
import com.example.productshop.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

import java.io.FileNotFoundException;

import static com.example.productshop.config.constants.GlobalConstant.PRODUCTS_FILE_PATH;
import static com.example.productshop.config.constants.GlobalConstant.RESOURCES_FILE_PATH;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final XmlParser xmlParser;

    @Autowired
    public CommandLineRunnerImpl(UserService userService, ProductService productService, CategoryService categoryService, XmlParser xmlParser, XmlParser xmlParser1) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.xmlParser = xmlParser1;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws JAXBException, FileNotFoundException {
      CategorySeedRootDto categorySeedRootDto =  xmlParser.fromFile("src/main/resources/data/categories.xml", CategorySeedRootDto.class);
      ProductSeedRootDto productSeedRootDto = xmlParser.fromFile("src/main/resources/data/products.xml", ProductSeedRootDto.class);

        categoryService.seedCategories(categorySeedRootDto.getCategories());
//        userService.seedUsers();
        productService.seedProducts(productSeedRootDto.getProducts());
    }
}
