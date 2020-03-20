package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {

        Cart cartToBeReturned = new Cart();

        cartToBeReturned.setId(cartDto.getId());

        cartDto.getProducts().keySet().stream().forEach(cartToBeReturned::addProduct);

        return cartToBeReturned;
    }

    public CartDto mapToCartDto(final Cart cart) {

        CartDto cartDtoToBeReturned = new CartDto();

        cartDtoToBeReturned.setId(cart.getId());

        cartDtoToBeReturned.setProducts(cart.getProducts());

        return cartDtoToBeReturned;
    }
}
