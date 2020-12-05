package com.customer.service.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.customer.service.dao.CustomerDao;

import lombok.extern.slf4j.Slf4j;
import model.Customer;

@RestController
@CrossOrigin
@Slf4j
public class CustomerController {
	
	
	private @Autowired CustomerDao customerDao;
	
	@PostMapping(value = "/customer", produces = {"application/json"})
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        try {
        	System.out.println(customer.toString());
            Customer response = customerDao.createCustomer(customer);
            return ResponseEntity.ok(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(),
                    e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

	
    @GetMapping(value = "/customer/{customerId}", produces = {"application/json"})
    public ResponseEntity<Customer> retrieveCustomer(@PathVariable(value="customerId") String customerId) {
        try {
            Customer response = customerDao.getCustomer(customerId);
            return ResponseEntity.ok(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(),
                    e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
	}
	
}
