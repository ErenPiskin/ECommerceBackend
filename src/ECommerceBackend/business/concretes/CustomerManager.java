package ECommerceBackend.business.concretes;

import ECommerceBackend.business.abstracts.CustomerCheckService;
import ECommerceBackend.business.abstracts.CustomerService;
import ECommerceBackend.business.abstracts.VerificationService;
import ECommerceBackend.core.concretes.GoogleManagerAdapter;
import ECommerceBackend.dataAccess.abstracts.CustomerDao;
import ECommerceBackend.entities.concretes.Customer;



public class CustomerManager implements CustomerService{
	
	
	private CustomerCheckService customerCheckService;
	private VerificationService verificationService;
	private CustomerDao customerDao;
	private GoogleManagerAdapter googleManagerAdapter;
	
	

	public CustomerManager(CustomerCheckService customerCheckService,VerificationService verificationService, CustomerDao customerDao,GoogleManagerAdapter googleManagerAdapter) {
		super();
		this.customerCheckService = customerCheckService;
		this.verificationService = verificationService;
		this.customerDao = customerDao;
		this.googleManagerAdapter = googleManagerAdapter;
	}

	@Override
	public void signUp(Customer customer) {
		if(customerCheckService.isValid(customer)) {
			verificationService.sendToVerifyEmail(customer);
			verificationService.verifyEmail(customer);
			googleManagerAdapter.login(customer);
			customerDao.add(customer);

		}
		else {
			System.out.println("Giri� ba�ar�s�z, L�tfen bilgilerinizi kontrol ediniz");
		}
		
		
	}

	@Override
	public void logIn(Customer customer) {
		if(verificationService.checkVerifyAccount(customer)) {
			System.out.println("Ba�ar�l�, Sisteme giri� yap�ld�");
		}
		else {
			System.out.println("Ba�ar�s�z, Sisteme giri� yap�lamad�");
		}
		
	}

}
