package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GenericEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    private List<GenericEntity> productList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, value = "getProductList")
    public List<GenericEntity> getProductList() {
        return productList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductById")
    public GenericEntity getProductById(@RequestParam Long productId) {
        return productList.stream()
                .filter(i -> i.getId().equals(productId))
                .findAny()
                .get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(@RequestBody GenericEntity product) {
        productList.add(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public GenericEntity updateProduct(@RequestBody GenericEntity product) {
        return new GenericEntity("Updated Product");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        productList.remove(productId);
    }

}
