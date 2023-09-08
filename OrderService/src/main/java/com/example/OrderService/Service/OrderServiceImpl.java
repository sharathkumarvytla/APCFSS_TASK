package com.example.OrderService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.OrderService.Pojo.OrderInfo;
import com.example.OrderService.Repository.OrderDaoImpl;
import com.example.OrderService.Utility.GenerateOrderId;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDaoImpl dao;

	@Autowired
	GenerateOrderId utility;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String assignOrder(OrderInfo info) {
		String status = "";
		try {
			Object custInfo = restTemplate.getForObject(
					"http://localhost:8082/customers/getCustomerDetails/" + info.getCustomerId(), Object[].class);
			if (custInfo == null)
				status = "2";
			else {
				OrderInfo cusDetails = (OrderInfo) custInfo;
				info.setOrderId(utility.createOrderId());
				info.setCustomerName(cusDetails.getCustomerName());
				info.setContactNumber(cusDetails.getContactNumber());
				info.setEmailAddress(cusDetails.getEmailAddress());
				info.setAddress(cusDetails.getAddress());
				int count = dao.createCustomerOrder(info);
				if (1 < count)
					status = "2";
				else
					status = "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "2";
		}
		return status;
	}
}