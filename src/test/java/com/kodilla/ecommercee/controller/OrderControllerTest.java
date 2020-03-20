package com.kodilla.ecommercee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.*;
import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.service.OrderService;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MockMvc mvc;
    @Autowired
    OrderMapper orderMapper;
    
    private Group shoes;
    private Group trousers;
    private Product nike;
    private Product adidas;
    private Product jeans;
    private User john;
    private User mike;
    private Cart johnCart;
    private Cart mikeCart;
    private Order johnOrder;
    private Order mikeOrder;
    private static final String controllerPath = "/v1/orders";


    @Before
    public void setUp() {
        shoes = groupRepository.save(new Group("Buty"));
        trousers = groupRepository.save(new Group("Spodnie"));

        nike = productRepository.save(new Product(null, "Nike", "Do koszykówki", BigDecimal.valueOf(125.20), shoes));
        adidas = productRepository.save(new Product(null, "Adidas", "Do biegania", BigDecimal.valueOf(195.50), shoes));
        jeans = productRepository.save(new Product(null, "Jeansy", "Standardowe", BigDecimal.valueOf(50.00), trousers));

        john = userRepository.save(new User(null, "John", 1L, false));
        mike = userRepository.save(new User(null, "Mike", 2L, false));

        johnCart = cartRepository.save(new Cart(john));
        mikeCart = cartRepository.save(new Cart(mike));

        johnCart.addProduct(nike);
        johnCart.addProduct(nike);
        johnCart.addProduct(adidas);
        johnCart.addProduct(jeans);
        johnCart.addProduct(jeans);
        johnCart.addProduct(jeans);
        johnCart = cartRepository.save(johnCart);

        mikeCart.addProduct(nike);
        mikeCart.addProduct(jeans);
        mikeCart = cartRepository.save(mikeCart);

        johnOrder = orderRepository.save(new Order(johnCart));
        mikeOrder = orderRepository.save(new Order(mikeCart));
    }
    
    @After
    public void tearDown() {
        orderRepository.deleteAll();
        cartRepository.deleteAll();
        productRepository.deleteAll();
        userRepository.deleteAll();
        groupRepository.deleteAll();
    }
    
    @Test
    public void shouldReturnAllOrders() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(controllerPath + "/getAllOrders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(johnOrder.getId().toString())))
                .andExpect(content().string(containsString(mikeOrder.getId().toString())));
    }
    
    @Test
    public void shouldIncreaseOrderNumInRepository() throws Exception {
        long ordersInRepositoryNumBeforeAdd = orderRepository.count();
        List<Product> productList = Arrays.asList(adidas, adidas);
        
        OrderDto newOrder = new OrderDto(null, productList, null, mike);

        mvc.perform(MockMvcRequestBuilders
                .post(controllerPath + "/addOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newOrder)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user.id").value(mike.getId().toString()))
                .andReturn();
        
        long ordersInRepositoryNum = orderRepository.count();

        Assert.assertEquals(ordersInRepositoryNumBeforeAdd + 1, ordersInRepositoryNum);
    }
    
    @Test
    public void shouldReturnJohnOrder() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(controllerPath + "/getOrderById")
                .param("id", mikeOrder.getId().toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(mikeOrder.getId()));
    }
    
    @Test
    public void shouldRemoveAdidasFromJohnOrder() throws Exception {
        OrderDto changedOrder = orderMapper.mapToOrderDto(johnOrder);
        int sizeBefore = changedOrder.getProducts().size();
        changedOrder.getProducts().remove(adidas);
        changedOrder.setOrderDate(null);
        
        mvc.perform(MockMvcRequestBuilders
                .put(controllerPath + "/updateOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(changedOrder)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.products.length()").value(sizeBefore - 1));
    }
    
    @Test
    public void shouldDeleteJohnOrder() throws Exception {
        long numOfOrdersBefore = orderRepository.count();
        
        mvc.perform(MockMvcRequestBuilders
                .delete(controllerPath + "/deleteOrder")
                .param("id", mikeOrder.getId().toString()))
                .andDo(print())
                .andExpect(status().isOk());
        
        long numOfOrdersAfter = orderRepository.count();
        
        assertEquals(numOfOrdersBefore - 1, numOfOrdersAfter);
    }
    
    
    

}