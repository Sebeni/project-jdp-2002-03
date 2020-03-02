package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupInterface;
import com.kodilla.ecommercee.domain.GroupStub;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {
//    TODO
//    implement real entity instead of groupStub

    public GroupInterface mapToGroup(GroupDto groupDto) {
        return new GroupStub(groupDto.getId(), groupDto.getName());
    }

    public GroupDto mapToGroupDto(GroupInterface groupInterface) {
        return new GroupDto(groupInterface.getId(), groupInterface.getName());
    }
    
    public List<GroupInterface> mapToGroupList(List<GroupDto> groupDtoList){
        return groupDtoList.stream()
                .map(this::mapToGroup)
                .collect(Collectors.toList());
    }
    
    public List<GroupDto> mapToGroupDtoList(List<GroupInterface> groupInterfaceList) {
        return groupInterfaceList.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }

}
