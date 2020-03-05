package com.kodilla.ecommercee.domain;

<<<<<<< HEAD
import java.util.List;

=======

import java.util.List;

>>>>>>> 85cf5127bf62d8e46ac093f0442f63cfe01b6493
public final class OrderDto {
    private final Long id;
    private final List<String> orderedProductList;

    public OrderDto(final Long id, final List<String> orderedProductList) {
        this.id = id;
        this.orderedProductList = orderedProductList;
    }

    public Long getId() {
        return id;
    }

    public List<String> getOrderedProductList() {
        return orderedProductList;
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> 85cf5127bf62d8e46ac093f0442f63cfe01b6493
