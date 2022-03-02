package ECommerceBackend.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ECommerceBackend.business.abstracts.CustomerCheckService;
import ECommerceBackend.entities.concretes.Customer;

public class CustomerCheckManager implements CustomerCheckService{
	
	List<String> listOfEmail = new ArrayList<String>();

	@Override
	public boolean checkFirstName(Customer customer) {
		if(customer.getFirstName().isEmpty()) {
			System.out.println("�sim bilgisi bo� b�rak�lamaz!");
			return false;
		}
		else if(customer.getFirstName().length()<2) {
			System.out.println("�sim en az iki karakterden olu�mal�d�r!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(Customer customer) {
		if(customer.getLastName().isEmpty()) {
			System.out.println("Soyisim Bo� B�rak�lamaz!");
			return false;	
		}
		else if(customer.getLastName().length()<2) {
			System.out.println("Soyisim en az iki karakterden olu�mal�d�r!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkEmail(Customer customer) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);  //https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
		
		if (customer.getemail().isEmpty()) {
			System.out.println("Email bilgisi bo� b�rak�lamaz!");
			return false;
		}
		else if(!pattern.matcher(customer.getemail()).find()) {
				System.out.println("Email bilgisi formata uygun de�il.");
				return false;
		}
		
		return true;
		}

	@Override
	public boolean checkPassword(Customer customer) {
		if(customer.getPassword().isEmpty()) {
			System.out.println("�ifre bilgisi bo� b�rak�lamaz!");
			return false;
		}
		else if(customer.getPassword().length()<6) {
			System.out.println("�ifre en az 6 karakterden olu�mal�d�r!");
			return false;
		}
		return true;
	}

	@Override
	public boolean uniqueEmail(Customer customer) {
		if(listOfEmail.contains(customer.getemail())) {
			System.out.println("Bu email ile sistemde bir hesap bulunuyor L�tfen ba�ka bir email deneyiniz");
			return false;
		}
		else {
			listOfEmail.add(customer.getemail());
			return true;
		}
		
	}

	@Override
	public boolean isValid(Customer customer) {
		if(checkFirstName(customer) && checkLastName(customer) && checkEmail(customer) && checkPassword(customer) && uniqueEmail(customer) == true) {
			return true;
		}
	    
		return false;
	}

}
