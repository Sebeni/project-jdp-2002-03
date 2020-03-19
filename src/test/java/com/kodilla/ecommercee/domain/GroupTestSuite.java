package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTestSuite {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    ProductRepository productRepository;
    private Group group1 = new Group("grupa1");
    private Group group2 = new Group("grupa2");

    @Before
    public void init() {
        groupRepository.save(group1);
        groupRepository.save(group2);
    }

    @After
    public void cleanUp() {
        productRepository.deleteAll();
        groupRepository.deleteAll();
    }

    @Test
    public void testGroupEntitySaveWithProducts() {
        //Given
        Product product1 = new Product();
        Product product2 = new Product();

        product1.setGroup(group1);
        product2.setGroup(group2);

        //When
        productRepository.save(product1);
        productRepository.save(product2);

        //Then
        Assert.assertEquals(2, groupRepository.count());
        Assert.assertEquals(2, productRepository.count());
        Assert.assertEquals("grupa1", product1.getGroup().getName());
        Assert.assertEquals("grupa2", product2.getGroup().getName());
    }

    @Test
    public void testGroupEntityFindAll() {
        //Given
        //When
        List<Group> allGroupsList = groupRepository.findAll();

        //Then
        Assert.assertEquals(2, allGroupsList.size());
    }

    @Test
    public void testGroupEntityFindById() {
        //Given
        //When
        Long group1Id = group1.getId();

        Optional<Group> foundGroup1 = groupRepository.findById(group1Id);

        //Then
        Assert.assertNotNull(foundGroup1);
    }

    @Test
    public void testUpdateGroupName() {
        //Given
        Product product1 = new Product();
        product1.setGroup(group1);

        //When
        productRepository.save(product1);

        group1.setName("grupa2");
        groupRepository.save(group1);

        //Then
        Assert.assertEquals("grupa2", group1.getName());
        Assert.assertEquals("grupa2", product1.getGroup().getName());
    }

    @Test
    public void testDeleteGroup() {
        //Given
        //When
        Long group1Id = group1.getId();

        groupRepository.deleteById(group1Id);

        //Then
        Assert.assertEquals(Optional.empty(), groupRepository.findById(group1Id));
    }
}
