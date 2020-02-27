package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private List<OrderDto> dummyRepoOfOrders = new ArrayList<>();

    public OrderService() {
        OrderDto firstOrder = new OrderDto(1L, new ArrayList<>(Arrays.asList("jewelry", "pants", "socks", "watch")));
        OrderDto secondOrder = new OrderDto(2L, new ArrayList<>(Arrays.asList("bananas", "apples", "strawberries")));
        OrderDto thirdOrder = new OrderDto(3L, new ArrayList<>(Arrays.asList("gloves", "sandals")));
        
        dummyRepoOfOrders.add(firstOrder);
        dummyRepoOfOrders.add(secondOrder);
        dummyRepoOfOrders.add(thirdOrder);
    }

    public List<OrderDto> getAllOrders() {
        return dummyRepoOfOrders;
    }
    
    public OrderDto addOrder(OrderDto orderToAdd) {
        dummyRepoOfOrders.add(orderToAdd);
        return orderToAdd;
    }

    public OrderDto getOrderById(Long id) {
        return dummyRepoOfOrders.stream()
                .filter(orderDto -> orderDto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public OrderDto updateOrder(OrderDto orderAfterChange) {
        OrderDto orderBeforeChange = getOrderById(orderAfterChange.getId());
        if(orderBeforeChange != null) {
            int indexWithChange = dummyRepoOfOrders.indexOf(orderBeforeChange);
            dummyRepoOfOrders.set(indexWithChange, orderAfterChange);
            return dummyRepoOfOrders.get(indexWithChange);
        } else {
            return null;
        }
    }
    
    public void deleteOrderById(Long id) {
        if(getOrderById(id) != null) {
            dummyRepoOfOrders.remove((int) (long) id - 1);
        }
    }
}
