package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupInterface;
import com.kodilla.ecommercee.domain.GroupStub;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceStub implements GroupService {
    
    private List<GroupInterface> dummyRepo = new ArrayList<>();
    
    public GroupServiceStub() {
        dummyRepo.add(new GroupStub(1L, "Ubrania"));
        dummyRepo.add(new GroupStub(2L, "Dodatki"));
        dummyRepo.add(new GroupStub(3L, "Biżuteria"));
        dummyRepo.add(new GroupStub(4L, "Obuwie"));
    }
    
    public List<GroupInterface> getAllGroups() {
        return dummyRepo;
    }


    public GroupInterface addGroup(String name) {
        long lastId = dummyRepo.get(dummyRepo.size() - 1).getId();
        GroupInterface newGroupToAdd = new GroupStub(lastId + 1, name);
        dummyRepo.add(newGroupToAdd);
        return newGroupToAdd;
    }
    
    public GroupInterface getGroupById(Long id) {
        return dummyRepo.stream()
                .filter(groupDto -> groupDto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public GroupInterface updateGroup(GroupInterface groupAfterChange) {
        GroupInterface groupBeforeChange = getGroupById(groupAfterChange.getId());
        if(groupBeforeChange != null) {
            int indexToChange = dummyRepo.indexOf(groupBeforeChange);
            dummyRepo.set(indexToChange, groupAfterChange);
            return dummyRepo.get(indexToChange);
        } else {
            return null;
        }
    }
}
