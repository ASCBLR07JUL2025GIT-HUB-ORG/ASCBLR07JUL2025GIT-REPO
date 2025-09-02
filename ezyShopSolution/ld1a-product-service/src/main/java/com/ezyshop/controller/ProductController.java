package com.ezyshop.controller;


import com.ezyshop.entity.Product;
import com.ezyshop.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // READ all (active only)
    @GetMapping
    public List<Product> getAll() {
        return repo.findByIsDeletedFalse();
    }

    // READ one (may return null if not found)
    @GetMapping("/{id}")
    public Product getOne(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }


    // CREATE — get id from DB sequence, set soft-delete flag false
    @PostMapping
    public Product create(@RequestBody Product body) {
        String newId = repo.nextProductId();
        body.setProductId(newId);
        body.setDeleted(false);
        return repo.save(body);
    }


    // UPDATE — only overwrite basic fields
    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product body) {
        return repo.findById(id).map(p -> {
            p.setName(body.getName());
            p.setDescription(body.getDescription());
            p.setCategory(body.getCategory());
            p.setPrice(body.getPrice());
            return repo.save(p);
        }).orElse(null);
    }


    // DELETE — soft delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.findById(id).ifPresent(p -> {
            p.setDeleted(true);
            repo.save(p);
        });
    }
}