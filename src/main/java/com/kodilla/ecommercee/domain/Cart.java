package com.kodilla.ecommercee.domain;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
=======
<<<<<<< HEAD
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> 2c51280f34191a5052db937b24e05e87dd276579
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
<<<<<<< HEAD
=======
>>>>>>> cb330760f240c4a83c360f9fe4a4897ad66c41df
>>>>>>> 2c51280f34191a5052db937b24e05e87dd276579

@Entity
public class Cart {

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
=======
<<<<<<< HEAD
    @GeneratedValue
=======
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
>>>>>>> cb330760f240c4a83c360f9fe4a4897ad66c41df
>>>>>>> 2c51280f34191a5052db937b24e05e87dd276579
    private Long id;

    @ElementCollection
    @CollectionTable
    @MapKeyJoinColumn
    @Column
    private Map<Product, Integer> products;

    @OneToOne
    private User user;

    public Cart() {
        this.products = new HashMap<>();
    }

    public Cart(User user) {
        this.user = user;
        this.products = new HashMap<>();
    }


    public void addProduct(Product productToBeAdded) {

        if (products.containsKey(productToBeAdded)) {
            Integer adjustedQty = products.get(productToBeAdded)+1;
            products.replace(productToBeAdded,adjustedQty);
        }
        else {
            products.put(productToBeAdded,1);
        }
    }

    public void removeProduct(Product productToBeRemoved) {

        if (products.containsKey(productToBeRemoved)) {
            Integer currentQty = products.get(productToBeRemoved);
            if (currentQty > 1) {
                currentQty--;
                products.replace(productToBeRemoved, currentQty);
            }
            else
            {
                products.remove(productToBeRemoved);
            }
        }

    }


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
