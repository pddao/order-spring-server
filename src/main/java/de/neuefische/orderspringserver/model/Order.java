package de.neuefische.orderspringserver.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

public class Order {

    @NotBlank(message = "Please enter an ID")
    @Size(min=1, max=3, message = "Please enter an ID between 1 and 3 letters")
    private String id;
    @NotBlank(message = "Please enter at least one product")
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
