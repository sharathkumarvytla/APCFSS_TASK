package com.example.CustomerDetailsService.Repository;

import com.example.CustomerDetailsService.Pojo.CustomerDetailsInfo;

public interface CustomerDetailsDao {
	
	public CustomerDetailsInfo getCustomerDetails(String customerId);

}
