package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public void createProduct(GenericEntity product) {
        productList.add(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public void updateProduct() {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {

    }

}
