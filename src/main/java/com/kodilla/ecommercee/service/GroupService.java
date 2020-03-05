package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//TODO
//implement real service
//change return type to Group class when created

@Service
public class GroupService {
    private List<GroupDto> dummyRepo = new ArrayList<>();
    
    public GroupService() {
        dummyRepo.add(new GroupDto(1L, "Ubrania"));
        dummyRepo.add(new GroupDto(2L, "Dodatki"));
        dummyRepo.add(new GroupDto(3L, "Biżuteria"));
        dummyRepo.add(new GroupDto(4L, "Obuwie"));
    }
    
    public List<GroupDto> getAllGroups() {
        return dummyRepo;
    }


    public GroupDto addGroup(String name) {
        long lastId = dummyRepo.get(dummyRepo.size() - 1).getId();
        GroupDto newGroupToAdd = new GroupDto(lastId + 1, name);
        dummyRepo.add(newGroupToAdd);
        return newGroupToAdd;
    }
    
    public GroupDto getGroupById(Long id) {
        return dummyRepo.stream()
                .filter(groupDto -> groupDto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public GroupDto updateGroup(GroupDto groupAfterChange) {
        GroupDto groupBeforeChange = getGroupById(groupAfterChange.getId());
        if(groupBeforeChange != null) {
            int indexToChange = dummyRepo.indexOf(groupBeforeChange);
            dummyRepo.set(indexToChange, groupAfterChange);
            return dummyRepo.get(indexToChange);
        } else {
            return null;
        }
    }
}
