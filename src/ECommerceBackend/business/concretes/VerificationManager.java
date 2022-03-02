package ECommerceBackend.business.concretes;

import java.util.ArrayList;
import java.util.List;

import ECommerceBackend.business.abstracts.VerificationService;
import ECommerceBackend.entities.concretes.Customer;


public class VerificationManager implements VerificationService{
	
	CustomerCheckManager customerCheckManager;
	
	List<String> verificatedEmails = new ArrayList<String>();

	@Override
	public void sendToVerifyEmail(Customer customer) {
		System.out.println(customer.getemail() + " Kullan�c�s�na Do�rulama mail'i g�nderildi" );
	}

	@Override
	public void verifyEmail(Customer customer) {
		System.out.println(customer.getemail() + " Ba�ar�yla do�ruland�");
		
		
	}

	@Override
	public boolean checkVerifyAccount(Customer customer) {
		
		if(verificatedEmails.contains(customer)) {
			return true;
		}
		return false;
	}

}
