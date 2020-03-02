package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/groups")
@CrossOrigin("*")
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;
    
//    TODO
//    when group entity is implemented change qualifier to GroupServiceReal
    @Autowired
    public GroupController(@Qualifier("groupServiceStub") GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllGroups")
    public List<GroupDto> getAllGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getAllGroups());
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/addGroup")
    public GroupDto addGroup(@RequestParam String name) {
        return groupMapper.mapToGroupDto(groupService.addGroup(name));
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getGroupById")
    public GroupDto getGroupById(@RequestParam Long id) {
        return groupMapper.mapToGroupDto(groupService.getGroupById(id));
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/updateGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupAfterChange) {
        return groupMapper.mapToGroupDto(groupService.updateGroup(groupMapper.mapToGroup(groupAfterChange)));
    }
}
