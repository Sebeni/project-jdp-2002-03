package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.*;
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
import java.time.Month;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    private User user = new User();
    private Order order1 = new Order();
    private Order order2 = new Order();
    private Order order3 = new Order();
    private Product product1 = new Product();
    private Product product2 = new Product();
    private Product product3 = new Product();

    @Before
    public void init() {
        user.setUserName("mackowit");
        user.getUserToken().add(new Token(
                "qwerty",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1)));

        user.setBlocked(false);
        userRepository.save(user);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        order1.setUser(user);
        order1.setOrderDate(LocalDate.of(2020, 3, 19));
        order1.setProducts(new HashMap<>());
        order1.getProducts().put(product1, 1);
        order1.getProducts().put(product2, 1);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
    }

    @After
    public void cleanUp() {
        orderRepository.deleteAll();
        userRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void testOrderEntitySaveWithAttributes() {
        //Given
        //When
        //Then
        Assert.assertEquals(3, orderRepository.count());
        Assert.assertEquals(2, orderRepository.findById(order1.getId()).get().getProducts().size());
    }

    @Test
    public void testOrderEntityFindAll() {
        //Given
        //When
        List<Order> listOfOrders = orderRepository.findAll();

        //Then
        Assert.assertEquals(3, listOfOrders.size());
    }

    @Test
    public void testOrderEntityUpdate() {
        //Given
        Set<Token> user2Set = new HashSet<>();
        user2Set.add(new Token("ABC", LocalDateTime.now(), LocalDateTime.now().plusHours(1)));

        User user2 = new User("maciej1", user2Set, false);

        //When
        userRepository.save(user2);

        order1.getProducts().put(product3, 1);
        order1.setUser(user2);
        orderRepository.save(order1);

        //Then
        Assert.assertEquals(3, orderRepository.findById(order1.getId()).get().getProducts().size());
        Assert.assertEquals("maciej1", orderRepository.findById(order1.getId()).get().getUser().getUserName());
    }

    @Test
    public void testOrderEntityDelete() {
        //Given
        //When
        Long order1Id = order1.getId();
        orderRepository.deleteById(order1Id);

        //Then
        Assert.assertEquals(Optional.empty(), orderRepository.findById(order1Id));
    }
}
