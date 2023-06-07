package com.suza.KidotiShop.repository;
import com.suza.KidotiShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}
