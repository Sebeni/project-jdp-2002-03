package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(orderDto.getId(), convertListToMap(orderDto.getProducts()), orderDto.getUser());
    }

    public Map<Product, Integer> convertListToMap(List<Product> productsFromOrderDto) {
        Map<Product, Integer> mapFromList = new HashMap<>();

        for (Product p : productsFromOrderDto) {
            if (mapFromList.containsKey(p)) {
                Integer lastQuantity = mapFromList.get(p);
                mapFromList.put(p, 1 + lastQuantity);
            } else {
                mapFromList.put(p, 1);
            }
        }
        return mapFromList;
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(order.getId(),
                order.getNumber(),
                convertMapToList(order.getProducts()),
                order.getOrderDate(),
                order.getUser());
    }

    private List<Product> convertMapToList(Map<Product, Integer> productsMapFromOrder) {
        List<Product> listFromMap = new ArrayList<>();

        productsMapFromOrder.forEach((product, quantity) -> {
            for (int i = 0; i < quantity; i++) {
                listFromMap.add(product);
            }
        });
        return listFromMap;
    }

    public List<Order> mapToOrderList(final List<OrderDto> orderDtoList) {
        return orderDtoList.stream()
                .map(this::mapToOrder)
                .collect(Collectors.toList());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
