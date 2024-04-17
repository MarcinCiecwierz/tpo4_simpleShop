package com.example.tpo4.Models;

import jakarta.persistence.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    private List<Product> productList;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String postCode;
    private String street;
    private String status;

    public Order() {
    }

    public Order(List<Product> productList, String name, String lastName, String email, String phone, String city, String postCode, String street, String status) {
        this.productList = productList;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.postCode = postCode;
        this.street = street;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(productList, order.productList) && Objects.equals(name, order.name) && Objects.equals(lastName, order.lastName) && Objects.equals(email, order.email) && Objects.equals(phone, order.phone) && Objects.equals(city, order.city) && Objects.equals(postCode, order.postCode) && Objects.equals(street, order.street) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}