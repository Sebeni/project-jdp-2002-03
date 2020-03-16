package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group addGroup(String name) {
        return groupRepository.save(new Group(name));
    }

    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    public Group updateGroup(Group groupAfterChange) {
        if (groupRepository.existsById(groupAfterChange.getId())) {
            return groupRepository.save(groupAfterChange);
        } else {
            throw new GroupNotFoundException();
        }

    }
}
