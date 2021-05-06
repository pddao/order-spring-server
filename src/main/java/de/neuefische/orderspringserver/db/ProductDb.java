package de.neuefische.orderspringserver.db;

import de.neuefische.orderspringserver.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDb {



    private final List<Product> productDb = new ArrayList<>(List.of(
            new Product ("1", "ball"),
            new Product ("22", "pen")
    ));

    public List<Product> list() {
        return productDb;
    }

    public Optional<Product> findProductById(String id) {
        for (Product product : productDb) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }

        return Optional.empty();

    }
}
