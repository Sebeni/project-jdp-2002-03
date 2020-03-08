package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private GroupService groupService;
    
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllGroups")
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroups();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/addGroup")
    public GroupDto addGroup(@RequestParam String name) {
        return groupService.addGroup(name);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getGroupById")
    public GroupDto getGroupById(@RequestParam Long id) {
        return groupService.getGroupById(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/updateGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupAfterChange) {
        return groupService.updateGroup(groupAfterChange);
    }
}
