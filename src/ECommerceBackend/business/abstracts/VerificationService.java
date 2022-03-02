package ECommerceBackend.business.abstracts;

import ECommerceBackend.entities.concretes.Customer;

public interface VerificationService {
	
	void sendToVerifyEmail(Customer customer);
	void verifyEmail(Customer customer);
	boolean checkVerifyAccount(Customer customer);

}
