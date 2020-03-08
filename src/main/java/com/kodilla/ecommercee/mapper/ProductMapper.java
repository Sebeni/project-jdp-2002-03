package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getDescription(),
                productDto.getGroup(),
                productDto.getOrderList(),
                productDto.getCartList());
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getDescription(),
                product.getGroup(),
                product.getOrderList(),
                product.getCartList());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(p -> new ProductDto(p.getId(), p.getDescription(), p.getGroup(), p.getOrderList(), p.getCartList()))
                .collect(Collectors.toList());
    }

}
