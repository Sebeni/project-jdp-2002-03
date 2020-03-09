package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    public Group mapToGroup(GroupDto groupDto) {
        return new Group(groupDto.getId(), groupDto.getName());
    }

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(group.getId(), group.getName());
    }
    
    public List<Group> mapToGroupList(List<GroupDto> groupDtoList){
        return groupDtoList.stream()
                .map(this::mapToGroup)
                .collect(Collectors.toList());
    }
    
    public List<GroupDto> mapToGroupDtoList(List<Group> groupList) {
        return groupList.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }
}
