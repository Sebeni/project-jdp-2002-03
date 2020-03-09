package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/groups")
@CrossOrigin("*")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupMapper groupMapper;
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAllGroups")
    public List<GroupDto> getAllGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getAllGroups());
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/addGroup")
    public GroupDto addGroup(@RequestParam String name) {
        return groupMapper.mapToGroupDto(groupService.addGroup(name));
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getGroupById")
    public GroupDto getGroupById(@RequestParam Long id) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupService.getGroupById(id));
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/updateGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupAfterChange) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupService.updateGroup(groupMapper.mapToGroup(groupAfterChange)));
    }
}
