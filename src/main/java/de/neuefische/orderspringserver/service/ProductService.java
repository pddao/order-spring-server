package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.db.ProductDb;
import de.neuefische.orderspringserver.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductDb productDb;

    @Autowired
    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }

    public List<Product> list() {
        return productDb.list();
    }

    public Optional<Product> findProductById(String id) {
        return productDb.findProductById(id);
    }
}
