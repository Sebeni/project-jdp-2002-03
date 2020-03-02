package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupInterface;

import java.util.List;

public interface GroupService {
    List<GroupInterface> getAllGroups();
    GroupInterface addGroup(String name);
    GroupInterface getGroupById(Long id);
    GroupInterface updateGroup(GroupInterface groupAfterChange);
    
}
