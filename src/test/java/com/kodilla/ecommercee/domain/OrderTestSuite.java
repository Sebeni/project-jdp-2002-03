package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    private User createTestUser(String userName, Long userKey) {
        User user = new User();
        user.setUserName(userName);
        user.setUserKey(userKey);

        return user;
    }

    private Order createTestOrder(String number, LocalDate date, User user) {
        Order order = new Order();
        order.setNumber(number);
        order.setOrderDate(date);
        order.setUser(user);

        return order;
    }


    @Test
    public void testOrderEntitySaveWithAttributes() {
        //Given
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        User user = createTestUser("mackowit", 1L);

        Order order = createTestOrder("20200319001", LocalDate.of(2020, 3, 19), user);
        order.getOrderedProductsList().add(product1);
        order.getOrderedProductsList().add(product2);
        order.getOrderedProductsList().add(product3);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        userRepository.save(user);
        orderRepository.save(order);

        //Then
        Assert.assertEquals(1, orderRepository.count());
        Assert.assertEquals(3, order.getOrderedProductsList().size());

        //CleanUp
        try {
            orderRepository.deleteAll();
            productRepository.deleteAll();
            userRepository.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testOrderEntityFindAll() {
        //Given
        User user = createTestUser("mackowit", 1L);

        Order order1 = createTestOrder("20200319001", LocalDate.of(2020, 3, 19), user);
        Order order2 = createTestOrder("20200319002", LocalDate.of(2020, 3, 19), user);
        Order order3 = createTestOrder("20200319003", LocalDate.of(2020, 3, 19), user);

        //When
        userRepository.save(user);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        List<Order> listOfOrders = orderRepository.findAll();

        //Then
        Assert.assertEquals(3, listOfOrders.size());

        //CleanUp
        try {
            orderRepository.deleteAll();
            userRepository.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testOrderEntityUpdate() {
        //Given
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        User user = createTestUser("mackowit", 1L);
        User user2 = createTestUser("maciej1", 1L);

        Order order = createTestOrder("20200319001", LocalDate.of(2020, 3, 19), user);
        order.getOrderedProductsList().add(product1);
        order.getOrderedProductsList().add(product2);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        userRepository.save(user);
        orderRepository.save(order);
        order.getOrderedProductsList().add(product3);
        List<Product> orderedProductsAfterUpdate = order.getOrderedProductsList();
        order.setUser(user2);

        //Then
        Assert.assertEquals(3, orderedProductsAfterUpdate.size());
        Assert.assertEquals("maciej1", order.getUser().getUserName());

        //CleanUp
        try {
            orderRepository.deleteAll();
            productRepository.deleteAll();
            userRepository.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testOrderEntityDelete() {
        //Given
        User user = createTestUser("mackowit", 1L);

        Order order = createTestOrder("20200319001", LocalDate.of(2020, 3, 19), user);

        //When
        userRepository.save(user);
        orderRepository.save(order);
        Long orderId = order.getId();
        orderRepository.deleteById(orderId);

        //Then
        Assert.assertEquals(Optional.empty(), orderRepository.findById(orderId));

        //CleanUp
        try {
            orderRepository.deleteAll();
            userRepository.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }
}
