package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceStub implements GroupService {
    
    private List<Group> dummyRepo = new ArrayList<>();
    
    public GroupServiceStub() {
        dummyRepo.add(new Group(1L, "Ubrania"));
        dummyRepo.add(new Group(2L, "Dodatki"));
        dummyRepo.add(new Group(3L, "Biżuteria"));
        dummyRepo.add(new Group(4L, "Obuwie"));
    }
    
    public List<Group> getAllGroups() {
        return dummyRepo;
    }


    public Group addGroup(String name) {
        long lastId = dummyRepo.get(dummyRepo.size() - 1).getId();
        Group newGroupToAdd = new Group(lastId + 1, name);
        dummyRepo.add(newGroupToAdd);
        return newGroupToAdd;
    }
    
    public Group getGroupById(Long id) {
        return dummyRepo.stream()
                .filter(groupDto -> groupDto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public Group updateGroup(Group groupAfterChange) {
        Group groupBeforeChange = getGroupById(groupAfterChange.getId());
        if(groupBeforeChange != null) {
            int indexToChange = dummyRepo.indexOf(groupBeforeChange);
            dummyRepo.set(indexToChange, groupAfterChange);
            return dummyRepo.get(indexToChange);
        } else {
            return null;
        }
    }
}
