package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceReal implements GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceReal(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

//    TODO
//    replace group to real entity 
    @Override
    public Group addGroup(String name) {
        if(!groupRepository.findByName(name).isPresent()){
            return groupRepository.save(new Group(null, name));
        }
        return null;
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Group updateGroup(Group groupAfterChange) {
        if(getGroupById(groupAfterChange.getId()) != null) {
            return groupRepository.save(groupAfterChange);
        }
        return null;
    }
}
