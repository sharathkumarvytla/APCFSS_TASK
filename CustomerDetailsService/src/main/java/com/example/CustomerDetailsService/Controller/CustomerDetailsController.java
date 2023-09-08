package com.example.CustomerDetailsService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerDetailsService.Pojo.CustomerDetailsInfo;
import com.example.CustomerDetailsService.Service.CustomerDetailsService;

import jakarta.websocket.server.PathParam;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/customers")
public class CustomerDetailsController {

	@Autowired
	CustomerDetailsService service;

	@GetMapping("/getCustomerDetails/{cid}")
	public ResponseEntity<CustomerDetailsInfo> fetchCustomerDetails(@PathParam("cid") String customerId) {
		CustomerDetailsInfo customerInfo = null;
		try {
			customerInfo = service.fetchCustomerDetails(customerId);
			if (customerInfo == null)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<>(customerInfo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}