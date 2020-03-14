package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ProductGroup;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    public ProductGroup mapToGroup(final GroupDto groupDto) {
        return new ProductGroup(groupDto.getId(), groupDto.getName());
    }

    public GroupDto mapToGroupDto(final ProductGroup productGroup) {
        return new GroupDto(productGroup.getId(), productGroup.getName());
    }
    
    public List<ProductGroup> mapToGroupList(final List<GroupDto> groupDtoList){
        return groupDtoList.stream()
                .map(this::mapToGroup)
                .collect(Collectors.toList());
    }
    
    public List<GroupDto> mapToGroupDtoList(final List<ProductGroup> productGroupList) {
        return productGroupList.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }
}
