package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.ProductGroup;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<ProductGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    public ProductGroup addGroup(String name) {
        return groupRepository.save(new ProductGroup(name));
    }

    public ProductGroup getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    public ProductGroup updateGroup(ProductGroup productGroupAfterChange) {
        if (groupRepository.existsById(productGroupAfterChange.getId())) {
            return groupRepository.save(productGroupAfterChange);
        } else {
            throw new GroupNotFoundException();
        }

    }
}
