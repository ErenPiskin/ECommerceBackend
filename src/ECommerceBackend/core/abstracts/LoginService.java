package ECommerceBackend.core.abstracts;

import ECommerceBackend.entities.concretes.Customer;

public interface LoginService {
	
	void login(Customer customer);

}
