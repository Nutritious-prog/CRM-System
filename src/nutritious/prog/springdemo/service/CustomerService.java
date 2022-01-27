package nutritious.prog.springdemo.service;

import java.util.List;

import nutritious.prog.springdemo.entity.Customer;

public interface CustomerService {

		public List<Customer> getCustomers();
		public void saveCustomer(Customer theCustomer);
}
