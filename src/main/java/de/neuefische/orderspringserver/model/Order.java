package de.neuefische.orderspringserver.model;

import java.util.List;
import java.util.Objects;

public class Order {

    private String id;
    private List<Product> productList;

    public Order(String id, List<Product> productList) {
        this.id = id;
        this.productList = productList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(productList, order.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", productList=" + productList +
                '}';
    }
}
