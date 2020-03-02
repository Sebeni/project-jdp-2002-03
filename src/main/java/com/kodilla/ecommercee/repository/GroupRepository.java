package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.GroupInterface;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GroupRepository extends CrudRepository<GroupInterface, Long> {
    
    List<GroupInterface> findAll();
    
    Optional<GroupInterface> findByName(String name);
    
    
    
}
