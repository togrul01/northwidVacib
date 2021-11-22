package com.business.abstracts;

import com.core.DataResults;
import com.core.Result;
import com.entities.concrets.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResults<List<Product>> getAll();

    DataResults<List<Product>> getAll(int pageNo,int pageSize);

    DataResults<List<Product>> getAllSorted();


    Result add(Product product);

    DataResults<Product> getByProductName(String productName);

   DataResults<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResults<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResults<List<Product>> getByProductNameContains(String productName);

    DataResults<List<Product>> getByProductNameStartsWith(String productName);

    DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId);

}
