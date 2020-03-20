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
    private Product product1 = new Product();
    private Product product2 = new Product();

    @Before
    public void init() {
        groupRepository.save(group1);
        groupRepository.save(group2);
        product1.setGroup(group1);
        product2.setGroup(group2);
        productRepository.save(product1);
        productRepository.save(product2);
    }

    @After
    public void cleanUp() {
        productRepository.deleteAll();
        groupRepository.deleteAll();
    }

    @Test
    public void testGroupEntitySaveWithProducts() {
        //Given
        //When
        //Then
        Assert.assertEquals(2, groupRepository.count());
        Assert.assertEquals(2, productRepository.count());
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
        //When
        group1.setName("grupa2");
        groupRepository.save(group1);

        //Then
        Assert.assertEquals("grupa2", groupRepository.findById(group1.getId()).get().getName());
        Assert.assertEquals("grupa2", productRepository.findById(product1.getId()).get().getGroup().getName());
    }

    @Test
    public void testDeleteGroup() {
        //Given
        Group group3 = new Group();
        groupRepository.save(group3);

        //When
        Long group1Id = group1.getId();
        Long group3Id = group3.getId();

        try {
            groupRepository.deleteById(group1Id);
        }
        catch (Exception e){
            //do nothing
        }
        groupRepository.deleteById(group3Id);

        //Then
        Assert.assertTrue(groupRepository.findById(group1Id).isPresent());
        Assert.assertFalse(groupRepository.findById(group3Id).isPresent());
    }
}
