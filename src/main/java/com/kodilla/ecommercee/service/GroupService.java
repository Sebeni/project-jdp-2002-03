package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    Group addGroup(String name);
    Group getGroupById(Long id);
    Group updateGroup(Group groupAfterChange);
    
}
