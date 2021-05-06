package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.db.ProductDb;
import de.neuefische.orderspringserver.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private final ProductDb productDb = mock(ProductDb.class);
    private final ProductService productService = new ProductService(productDb);

    @Test
    void listShouldReturnAllProducts() {
        //Given
        when(productDb.list()).thenReturn(List.of(
                new Product ("1", "ball"),
                new Product("22", "pen")
        ));

        //When
        List<Product> listOfProducts = productService.list();

        //Then
        assertThat(listOfProducts, containsInAnyOrder(new Product ("1", "ball"), new Product("22", "pen")));
        verify(productDb).list();
    }

    @Test
    void findProductById() {
        //Given
        when(productDb.findProductById("1")).thenReturn(Optional.of(new Product("1", "ball")));

        //When
        Optional<Product> productToFind = productService.findProductById("1");

        //Then
        assertThat(productToFind.get(), is(new Product("1", "ball")));
        verify(productDb).findProductById("1");
    }
}