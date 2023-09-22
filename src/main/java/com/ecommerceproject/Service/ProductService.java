package com.ecommerceproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerceproject.Model.ProductModel;
import com.ecommerceproject.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<ProductModel> getAllRepository()
	{
		return (List<ProductModel>) productRepository.findAll(PageRequest.of(0, 100)).toList();
	}
	
	public ProductModel saveProductData(ProductModel productModel)
	{
		return productRepository.save(productModel);
	}

}
