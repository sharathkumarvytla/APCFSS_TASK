package com.example.CustomerDetailsService.Service;

import com.example.CustomerDetailsService.Pojo.CustomerDetailsInfo;

public interface CustomerDetailsService {

	public CustomerDetailsInfo fetchCustomerDetails(String customerId);
	
}
