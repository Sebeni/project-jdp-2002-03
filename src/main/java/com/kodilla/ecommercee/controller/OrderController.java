package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAllOrders")
    public List<OrderDto> getAllOrders() {
        return orderMapper.mapToOrderDtoList(orderService.getAllOrders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto addOrder(@RequestBody OrderDto orderToAdd) {
        return orderMapper.mapToOrderDto(orderService.addOrder(orderMapper.mapToOrder(orderToAdd)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getOrderById")
    public OrderDto getOrderById(@RequestParam Long id) {
        return orderMapper.mapToOrderDto(orderService.getOrderById(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderAfterChange) {
        return orderMapper.mapToOrderDto(orderService.updateOrder(orderMapper.mapToOrder(orderAfterChange)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteOrder")
    public void deleteOrder(@RequestParam Long id) {
        orderService.deleteOrderById(id);
    }
}
