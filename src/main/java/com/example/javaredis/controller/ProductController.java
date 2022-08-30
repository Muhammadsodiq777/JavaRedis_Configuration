package com.example.javaredis.controller;

import com.example.javaredis.Entity.Product;
import com.example.javaredis.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;


    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productDAO.save(product);
    }

    @GetMapping("/get/all")
    public List<Product> getAll()
    {
        return productDAO.findAll();
    }

    @GetMapping("/get/{id}")
    public Product getbyId(@PathVariable long id){
        return productDAO.findByID(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        return productDAO.deleteProduct(id);
    }
}
