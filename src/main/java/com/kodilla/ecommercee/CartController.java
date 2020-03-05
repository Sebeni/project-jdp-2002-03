package com.kodilla.ecommercee;


import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carts")
<<<<<<< HEAD
=======
@CrossOrigin(origins = "*")
>>>>>>> 76a7ed054e797390aa379a1a9acdfd49038a2759
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST, value ="/createCart")
    public CartDto createCart(@RequestParam String name) {
        return new CartDto();
    }

    @RequestMapping(method = RequestMethod.GET, value ="/getProductsFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProductsFromCart(@RequestBody CartDto cart) {
        return cartService.getProductsfromCart(cart);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/addProductsToCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProductsToCart(@RequestBody List<ProductDto> productsToBeAdded, @RequestBody CartDto cart) {
        cartService.addProductsToCart(productsToBeAdded,cart);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/removeProductsFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeProductsFromCart(@RequestBody ProductDto productToBeRemoved, @RequestBody CartDto cart) {
        cartService.removeProductFromCart(productToBeRemoved,cart);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createOrderFromCart")
    public OrderDto createOrderFromCart(@RequestBody CartDto cart){
        return cartService.createOrderFromCart(cart);
    }

}