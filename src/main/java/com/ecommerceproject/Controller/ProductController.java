package com.ecommerceproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceproject.Model.ProductModel;
import com.ecommerceproject.Service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping("/postProductData")
	public String productDatas(@RequestBody ProductModel productModel)
	{
		productService.saveProductData(productModel);
		return "Data Add successfully";
	}
	
	
	@GetMapping("/product-data")
	public Iterable<ProductModel> getalldata()
	{
		return productService.getAllRepository();
	}
}
