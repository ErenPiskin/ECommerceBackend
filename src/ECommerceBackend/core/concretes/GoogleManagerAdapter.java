package ECommerceBackend.core.concretes;

import ECommerceBackend.Google.GoogleManager;
import ECommerceBackend.core.abstracts.LoginService;
import ECommerceBackend.entities.concretes.Customer;

public class GoogleManagerAdapter implements LoginService{

	@Override
	public void login(Customer customer) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.loginwithGoogle(customer.getemail());
		
	}

}
