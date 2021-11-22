package com.api.controllers;

import com.business.abstracts.ProductService;
import com.core.DataResults;
import com.core.Result;
import com.entities.concrets.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResults<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResults<Product> getByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResults<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResults<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameOrCategoryId(productName, categoryId);
    }


    @GetMapping("/getByCategoryIdIn")
    public DataResults<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
        System.out.println(categories);
        return productService.getByCategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResults<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResults<List<Product>> getAll(int pageNo, int pageSize) {
        return productService.getAll(pageNo, pageSize);
    }


    @GetMapping("/getByProductNameStartsWith")
    public DataResults<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getAllSort")
    public DataResults<List<Product>> getAllSorted() {
        return productService.getAllSorted();
    }
}
