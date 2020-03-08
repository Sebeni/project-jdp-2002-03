package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.NoProductException;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getProductList")
    public List<ProductDto> getProductList() {
        return productMapper.mapToProductDtoList(productService.getAllProducts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductById")
    public ProductDto getProductById(@RequestParam Long productId) throws NoProductException {
        return productMapper.mapToProductDto(productService.getProduct(productId).orElseThrow(NoProductException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productMapper.mapToProduct(productDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productMapper.mapToProductDto(productService.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        productService.deleteProduct(productId);
    }

}
