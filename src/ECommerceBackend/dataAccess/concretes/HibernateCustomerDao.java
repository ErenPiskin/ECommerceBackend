package ECommerceBackend.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ECommerceBackend.dataAccess.abstracts.CustomerDao;
import ECommerceBackend.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao{
	
	List<Customer> customers = new ArrayList<Customer>();

	@Override
	public void add(Customer customer) {
		customers.add(customer);
			System.out.println("Hibernate ile kullanýcý eklendi");		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println("Hibernate ile kullanýcý silindi");			
	}

	@Override
	public void update(Customer customer) {
		System.out.println("Hibernate ile kullanýcý güncellendi");			
	}

	@Override
	public boolean getEmail(String email) {
		for (Customer customer : customers) {
			if(customer.getemail() == email) {
				return true;
			}
		}
		return false;	
		}

	@Override
	public boolean getPassword(String password) {
		for(Customer customer : customers) {
			if(customer.getPassword() == password)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Customer> getAll() {
		return null;
	}

}
