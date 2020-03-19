package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
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

    @Test
    public void testGroupEntitySaveWithProducts() {
        //Given
        Group group1 = new Group("grupa1");
        Group group2 = new Group("grupa2");

        Product product1 = new Product();
        Product product2 = new Product();

        product1.setGroup(group1);
        product2.setGroup(group2);

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        productRepository.save(product1);
        productRepository.save(product2);

        //Then
        Assert.assertEquals(2, groupRepository.count());
        Assert.assertEquals(2, productRepository.count());
        Assert.assertEquals("grupa1", product1.getGroup().getName());
        Assert.assertEquals("grupa2", product2.getGroup().getName());

        //CleanUp
        try {
            productRepository.deleteAll();
            groupRepository.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testGroupEntityFindAll() {
        //Given
        Group group1 = new Group("grupa1");
        Group group2 = new Group("grupa2");

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        List<Group> allGroupsList = groupRepository.findAll();

        //Then
        Assert.assertEquals(2, allGroupsList.size());

        //CleanUp
        try {
            groupRepository.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testGroupEntityFindById() {
        //Given
        Group group1 = new Group("grupa1");
        Group group2 = new Group("grupa2");

        //When
        groupRepository.save(group1);
        Long group1Id = group1.getId();
        groupRepository.save(group2);
        Long group2Id = group2.getId();
        Group foundGroup1 = groupRepository.findById(group1Id).orElse(null);
        Group foundGroup2 = groupRepository.findById(group2Id).orElse(null);

        //Then
        Assert.assertEquals("grupa1", foundGroup1.getName());
        Assert.assertNotEquals("grupa1", foundGroup2.getName());

        //CleanUp
        try {
            groupRepository.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testUpdateGroupName() {
        //Given
        Group group1 = new Group("grupa1");
        Product product1 = new Product();
        product1.setGroup(group1);

        //When
        groupRepository.save(group1);
        productRepository.save(product1);

        group1.setName("grupa2");

        //Then
        Assert.assertEquals("grupa2", group1.getName());
        Assert.assertEquals("grupa2", product1.getGroup().getName());

        //CleanUp
        try {
            productRepository.deleteAll();
            groupRepository.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testDeleteGroup() {
        //Given
        Group group1 = new Group("grupa1");

        //When
        groupRepository.save(group1);
        Long group1Id = group1.getId();

        groupRepository.deleteById(group1Id);

        //Then
        Assert.assertEquals(Optional.empty(), groupRepository.findById(group1Id));

        //CleanUp
    }
}
