package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllOrders")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getOrderById")
    public OrderDto getOrderById(@RequestParam Long id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderAfterChange) {
        return orderService.updateOrder(orderAfterChange);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteOrder")
    public void deleteOrder(@RequestParam Long id) {
        orderService.deleteOrderById(id);
    }
}

