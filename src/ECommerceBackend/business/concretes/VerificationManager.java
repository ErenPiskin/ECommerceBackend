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
		System.out.println(customer.getemail() + " Kullanıcısına Doğrulama mail'i gönderildi" );
	}

	@Override
	public void verifyEmail(Customer customer) {
		System.out.println(customer.getemail() + " Başarıyla doğrulandı");
		
		
	}

	@Override
	public boolean checkVerifyAccount(Customer customer) {
		
		if(verificatedEmails.contains(customer)) {
			return true;
		}
		return false;
	}

}
