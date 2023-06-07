package com.suza.KidotiShop.controller;

import com.suza.KidotiShop.model.Product;
import com.suza.KidotiShop.model.User;
import com.suza.KidotiShop.repository.ProductRepo;
import com.suza.KidotiShop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;
    @GetMapping("/all")
    public ResponseEntity<?> getProduct(){
        try {
            List<Product> productList= productRepo.findAll();
            if(productList.isEmpty()){
                return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(productList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Something wrong, try again later",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("{ProID}")
    private ResponseEntity<?>getProductById(@PathVariable int ProID){
        Optional<Product> optionalProduct = productRepo.findById(ProID);
        try {
            if (optionalProduct.isEmpty()){
                return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(optionalProduct,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Something wrong try again later",HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/addproduct")
    private ResponseEntity<?>addUser(@RequestBody Product product){
        try {
            Product product1 = productRepo.save(product);
            return new ResponseEntity<>("Data Saved",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Data Not Saved",HttpStatus.CONFLICT);
        }
    }
}
