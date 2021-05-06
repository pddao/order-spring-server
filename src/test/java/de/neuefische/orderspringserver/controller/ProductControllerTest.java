package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.db.ProductDb;
import de.neuefische.orderspringserver.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    ProductDb productDb;


    @Test
    public void listOfProductsShouldReturnAllProducts() {

        //GIVEN
        RestTemplate restTemplate = new RestTemplate();

        //WHEN/
        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:" + port + "/product", Product[].class);

        //THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), arrayContainingInAnyOrder(
                new Product("1", "ball"),
                new Product("22", "pen")));

    }

    @Test
    public void findProductByIdShouldReturnProductWithMatchingId() {

        //GIVEN
        String id = "22";
        RestTemplate restTemplate = new RestTemplate();

        //WHEN
        ResponseEntity<Product> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + id, Product.class);

        //THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(new Product("22", "pen")));

    }
}