package com.example.CustomerDetailsService.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CustomerDetailsService.Pojo.CustomerDetailsInfo;

@Repository
public class CustomerDetailsDaoImpl implements CustomerDetailsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public CustomerDetailsInfo getCustomerDetails(String customerId) {
		CustomerDetailsInfo customerInfo = null;
		try {
			customerInfo = jdbcTemplate.queryForObject("SELECT * FROM CUSTOMER_DETAILS WHERE id=?",
					BeanPropertyRowMapper.newInstance(CustomerDetailsInfo.class), customerId);

		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
		return customerInfo;
	}
}