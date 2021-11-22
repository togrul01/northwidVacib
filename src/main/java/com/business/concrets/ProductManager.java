package com.business.concrets;

import com.business.abstracts.ProductService;
import com.core.DataResults;
import com.core.Result;
import com.core.SuccessDataResult;
import com.core.SuccessResult;
import com.dataAccess.abstracts.ProductDao;
import com.entities.concrets.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResults<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (productDao.findAll(), "Data view");
    }

    @Override
    public DataResults<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent(),"Success");
    }

    @Override
    public DataResults<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC,"productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort),"Success");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product added");
    }

    @Override
    public DataResults<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (productDao.getByProductName(productName), "Data view");
    }

    @Override
    public DataResults<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                (productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data view");
    }

    @Override
    public DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data view");
    }

    @Override
    public DataResults<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByCategoryIn(categories), "Data view");
    }

    @Override
    public DataResults<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByProductNameContains(productName), "Data view");
    }

    @Override
    public DataResults<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByProductNameStartsWith(productName), "Data view");
    }

    @Override
    public DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByNameAndCategory(productName, categoryId), "Data view");
    }
}
