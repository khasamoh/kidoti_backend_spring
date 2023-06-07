package com.suza.KidotiShop.repository;

import com.suza.KidotiShop.model.Sale;
import com.suza.KidotiShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends JpaRepository<Sale,Integer> {
}
