package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(product.getId(), product.getDescription());
    }

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getDescription());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(p -> new ProductDto(p.getId(), p.getDescription()))
                .collect(Collectors.toList());
    }


}
