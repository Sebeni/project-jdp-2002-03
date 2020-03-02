package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupInterface;
import com.kodilla.ecommercee.domain.GroupStub;
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
    public List<GroupInterface> getAllGroups() {
        return groupRepository.findAll();
    }

//    TODO
//    replace stub to real entity 
    @Override
    public GroupInterface addGroup(String name) {
        if(!groupRepository.findByName(name).isPresent()){
            return groupRepository.save(new GroupStub(null, name));
        }
        return null;
    }

    @Override
    public GroupInterface getGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public GroupInterface updateGroup(GroupInterface groupAfterChange) {
        if(getGroupById(groupAfterChange.getId()) != null) {
            return groupRepository.save(groupAfterChange);
        }
        return null;
    }
}
