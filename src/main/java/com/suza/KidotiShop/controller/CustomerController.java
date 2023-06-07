package com.suza.KidotiShop.controller;

import com.suza.KidotiShop.model.Customer;
import com.suza.KidotiShop.model.Product;
import com.suza.KidotiShop.repository.CustomerRepo;
import com.suza.KidotiShop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @GetMapping("/all")
    public ResponseEntity<?> getCustomer(){
        try {
            List<Customer> customerList= customerRepo.findAll();
            if(customerList.isEmpty()){
                return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(customerList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Something wrong, try again later",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("{CustID}")
    private ResponseEntity<?>getCustomerById(@PathVariable int CustID){
        Optional<Customer> optionalCustomer = customerRepo.findById(CustID);
        try {
            if (optionalCustomer.isEmpty()){
                return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(optionalCustomer,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Something wrong try again later",HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/addCustomer")
    private ResponseEntity<?>addCustomer(@RequestBody Customer customer){
        try {
            Customer customer1 = customerRepo.save(customer);
            return new ResponseEntity<>("Data Saved",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Data Not Saved",HttpStatus.CONFLICT);
        }
    }
}
