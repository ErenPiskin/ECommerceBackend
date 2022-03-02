package ECommerceBackend;

import ECommerceBackend.business.concretes.CustomerCheckManager;
import ECommerceBackend.business.concretes.CustomerManager;
import ECommerceBackend.business.concretes.VerificationManager;
import ECommerceBackend.core.concretes.GoogleManagerAdapter;
import ECommerceBackend.dataAccess.concretes.HibernateCustomerDao;
import ECommerceBackend.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		
		
		Customer customer1 = new Customer();
		customer1.setCustomerId(1);
		customer1.setFirstName("Eren");
		customer1.setLastName("Piþkin");
		customer1.setemail("PoyrazKarayel@hotmail.com");
		customer1.setPassword("123456");
		
		
		//Geçersiz giriþlerin kontrolü için oluþturuþmuþ kullanýcý
		Customer customer2 = new Customer();
		customer2.setCustomerId(2);
		customer2.setFirstName("Leyla");
		customer2.setLastName("Mecnun");
		customer2.setemail("LeylaileMecnun@hotmail.com"); 
		customer2.setPassword("123456");
		

		CustomerManager customerManager = new CustomerManager(new CustomerCheckManager(),new VerificationManager(),new HibernateCustomerDao(), new GoogleManagerAdapter());
		
		customerManager.signUp(customer1);
		System.out.println(" ");
		System.out.println(" ");
		customerManager.signUp(customer2);

	}

}
