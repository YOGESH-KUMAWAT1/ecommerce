package com.ecommerceproject.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ecommerceproject.Model.ProductModel;


public interface ProductRepository extends ElasticsearchRepository<ProductModel, Integer> {

}
