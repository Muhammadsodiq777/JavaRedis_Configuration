package com.example.javaredis.repository;

import com.example.javaredis.Entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {

    private static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate template;

    public Product save(Product product){
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return  product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findByID(long id){
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public  String deleteProduct(long id){
        template.opsForHash().delete(HASH_KEY, id);
        return "Product is removed !!!";
    }
}
