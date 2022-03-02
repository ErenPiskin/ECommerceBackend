package ECommerceBackend.dataAccess.abstracts;



import java.util.List;

import ECommerceBackend.entities.concretes.Customer;

public interface CustomerDao {
	
	void add(Customer customer);
	void delete(Customer customer);
	void update(Customer customer);
	boolean getEmail(String email);
	boolean getPassword(String password);
	List<Customer> getAll();
	

}
