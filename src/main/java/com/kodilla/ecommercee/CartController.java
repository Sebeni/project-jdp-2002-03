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
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST, value ="/createCart")
    public CartDto createCart() {
        return new CartDto();
    }

    @RequestMapping(method = RequestMethod.GET, value ="/getProductsFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartId) {
        return cartService.getProductsfromCart(cartId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/addProductsToCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProductsToCart(@RequestBody List<ProductDto> productsToBeAdded, @RequestParam Long cartId) {
        cartService.addProductsToCart(productsToBeAdded,cartId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/removeProductsFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeProductsFromCart(@RequestBody List<ProductDto> productsToBeRemoved, @RequestParam Long cartId) {
        cartService.removeProductsFromCart(productsToBeRemoved,cartId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createOrderFromCart")
    public OrderDto createOrderFromCart(@RequestBody CartDto cart){
        return cartService.createOrderFromCart(cart);
    }

}