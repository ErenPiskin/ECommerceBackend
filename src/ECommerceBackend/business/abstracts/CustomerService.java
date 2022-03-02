package ECommerceBackend.business.abstracts;

import ECommerceBackend.entities.concretes.Customer;

public interface CustomerService {
	
	void signUp(Customer customer);
	void logIn(Customer customer);

}
