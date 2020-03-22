package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartEntityTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void shouldAddCart() {

        Cart testCart = new Cart();
        cartRepository.save(testCart);

        Optional<Cart> cartFromRepo = cartRepository.findById(testCart.getId());

        assertNotNull(cartFromRepo);
        assertTrue(cartFromRepo.isPresent());

        cartRepository.delete(testCart);
    }

    @Test
    public void shouldRemoveCart() {
        Cart testCart = new Cart();

        cartRepository.save(testCart);

        cartRepository.deleteById(testCart.getId());

        Optional<Cart> cartFromRepo = cartRepository.findById(testCart.getId());

        assertNotNull(cartFromRepo);
        assertFalse(cartFromRepo.isPresent());

        cartRepository.delete(testCart);

    }

    @Test
    public void testFindAll() {

        List<Cart> listOfCarts = new ArrayList<>();

        listOfCarts.add(new Cart());
        listOfCarts.add(new Cart());
        listOfCarts.add(new Cart());

        cartRepository.saveAll(listOfCarts);

        List<Cart> cartsRecoveredFromRepo = cartRepository.findAll();

        assertEquals(3, cartsRecoveredFromRepo.size());

        cartRepository.deleteAll();

    }

    @Test
    public void  shouldAddCartWithProducts() {

        Product product1 = new Product();
        product1.setName("T-Shirt");
        product1.setDescription("Męski, Niebieski, rozmiar XXXL");

        Product product2 = new Product();
        product2.setName("Długopis");
        product2.setDescription("Kulkowy, kolor tuszu zielony");

        productRepository.save(product1);
        productRepository.save(product2);

        Cart testCart = new Cart();

        testCart.addProduct(product1);
        testCart.addProduct(product2);

        cartRepository.save(testCart);

        Optional<Cart> cartFromRepo = cartRepository.findById(testCart.getId());

        assertNotNull(cartFromRepo);
        assertTrue(cartFromRepo.isPresent());

        assertEquals(2, cartFromRepo.get().getProducts().size());

        cartRepository.delete(testCart);
        productRepository.delete(product1);
        productRepository.delete(product2);

    }

    @Test
    public void shouldAddCartWithUser() {

        Set<Token> tokenSet = new HashSet<>();

        Token token = new Token("666",
                LocalDateTime.of(2020,1,1,0,0,0),
                LocalDateTime.of(2020,12,31,23,30,0));

        tokenSet.add(token);

        User testUser = new User("Torayasu",tokenSet,false);

        userRepository.save(testUser);

        Cart testCart = new Cart(testUser);

        cartRepository.save(testCart);

        Optional<Cart> cartFromRepo = cartRepository.findById(testCart.getId());

        assertNotNull(cartFromRepo);
        assertTrue(cartFromRepo.isPresent());

        assertEquals("Torayasu", cartFromRepo.get().getUser().getUserName());

        cartRepository.delete(testCart);
        userRepository.delete(testUser);
    }

}
