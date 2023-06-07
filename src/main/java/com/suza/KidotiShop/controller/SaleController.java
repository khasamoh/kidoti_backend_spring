package com.suza.KidotiShop.controller;

import com.suza.KidotiShop.model.Sale;
import com.suza.KidotiShop.model.User;
import com.suza.KidotiShop.repository.SaleRepo;
import com.suza.KidotiShop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleRepo saleRepo;
    @GetMapping("/all")
    public ResponseEntity<?>getSale(){
        try {
            List<Sale> saleList = saleRepo.findAll();
            if(saleList.isEmpty()){
                return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(saleList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Something wrong, try again later",HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/addSale")
    private ResponseEntity<?>addSae(@RequestBody Sale sale){
        try {
            Sale sale1 = saleRepo.save(sale);
            return new ResponseEntity<>("Data Saved",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Data Not Saved",HttpStatus.CONFLICT);
        }
    }
}
