package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    OrderRepository orderRepository;

    private ArrayList<Long> productIdList = new ArrayList<>();

    @After
    public void clear() {
        productRepository.deleteAll();
        groupRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    public void testSaveProduct(){
        //given
        Product product = new Product();
        product.setName("testProduct1");
        product.setDescription("testDescriptionProduct1");
        product.setPrice(BigDecimal.valueOf(50.5));
        //when
        productRepository.save(product);
        Long id = product.getId();
        productIdList.add(id);
        Optional<Product> readProduct = productRepository.findById(id);
        assertNotNull(readProduct);
        //then
        assertTrue(readProduct.isPresent());
    }

    @Test
    public void testFindProductByDescription(){
        //given
        Product product = new Product();
        product.setName("testProduct1");
        product.setDescription("testDescriptionProduct1");
        product.setPrice(BigDecimal.valueOf(50.5));
        //When
        productRepository.save(product);
        Long id = product.getId();
        productIdList.add(id);
        Optional<Product> readProduct = productRepository.findByDescription("testDescriptionProduct1");
        assertNotNull(readProduct);
        //Then
        assertTrue(readProduct.isPresent());
    }

    @Test
    public void testFindProductById(){
        //given
        Product product = new Product();
        product.setName("testProduct1");
        product.setDescription("testDescriptionProduct1");
        product.setPrice(BigDecimal.valueOf(50.5));
        //When
        productRepository.save(product);
        Long id = product.getId();
        productIdList.add(id);
        Optional<Product> readProduct = productRepository.findById(id);
        assertNotNull(readProduct);
        assertTrue(readProduct.isPresent());
        Product product1 = readProduct.get();
        //Then
        assertEquals(product.getId(), product1.getId());
    }

    @Test
    public void testUpdateProduct(){
        //given
        Product product = new Product();
        product.setName("testProduct1");
        product.setDescription("testDescriptionProduct1");
        product.setPrice(BigDecimal.valueOf(50.5));
        //when
        productRepository.save(product);
        Long id = product.getId();
        productIdList.add(id);
        product.setDescription("testDescriptionProduct1Updated");
        productRepository.save(product);
        Optional<Product> readProduct = productRepository.findById(id);
        String readDescription = readProduct.get().getDescription();
        //then
        assertEquals("testDescriptionProduct1Updated", readDescription);
    }

}
