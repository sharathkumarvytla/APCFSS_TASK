package com.example.CustomerDetailsService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerDetailsService.Pojo.CustomerDetailsInfo;
import com.example.CustomerDetailsService.Repository.CustomerDetailsDaoImpl;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetailsDaoImpl dao;

	@Override
	public CustomerDetailsInfo fetchCustomerDetails(String customerId) {
		return dao.getCustomerDetails(customerId);
	}
}