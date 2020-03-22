package com.kodilla.ecommercee.service;	

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;	

import java.util.ArrayList;	
import java.util.Arrays;	
import java.util.List;	

@Service	
public class OrderService {
    @Autowired
    private OrderRepository orderRepository; 
    
    public List<Order> getAllOrders() {	
        return orderRepository.findAll();	
    }	

    public Order addOrder(Order order) {
        return orderRepository.save(order);	
    }	

    public Order getOrderById(Long id) {	
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }	

    public Order updateOrder(Order orderAfterChange) {	
        if(orderRepository.existsById(orderAfterChange.getId())){
            return orderRepository.save(orderAfterChange);
        } else {
            throw new OrderNotFoundException();
        }
    }	

    public void deleteOrderById(Long id) {	
        orderRepository.deleteById(id);
    }	
}
