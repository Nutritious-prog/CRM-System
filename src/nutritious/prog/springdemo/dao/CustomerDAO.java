package nutritious.prog.springdemo.dao;

import java.util.List;

import nutritious.prog.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
