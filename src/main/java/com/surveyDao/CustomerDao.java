package com.surveyDao;

import java.util.List;

import com.Entity.Customer;

public interface CustomerDao {
	public Customer saveCustomer(Customer customer);
	public Integer getMaxId();
	public Customer getCustomer(String name, String password);
	public List<Customer> getAllCustomer();
	public void promoteCustomer(int id);
	public void deleteCustomer(int id);
	public Customer getEmail(String email);

}
