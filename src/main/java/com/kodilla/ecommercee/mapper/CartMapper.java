package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {

    public Cart mapToCart(CartDto cartDto) {

        Cart cartToBeReturned = new Cart();

        cartToBeReturned.setId(cartDto.getId());

        cartDto.getProducts().stream().forEach(cartToBeReturned::addProduct);

        return cartToBeReturned;
    }

    public CartDto mapToCartDto(Cart cart) {

        CartDto cartDtoToBeReturned = new CartDto();

        cartDtoToBeReturned.setId(cart.getId());

        cart.getProducts().keySet().stream().forEach(p -> cartDtoToBeReturned.getProducts().add(p));

        return cartDtoToBeReturned;
    }
}
