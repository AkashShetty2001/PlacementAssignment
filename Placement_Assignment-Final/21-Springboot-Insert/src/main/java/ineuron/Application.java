package ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import ineuron.model.Customer;
import ineuron.service.ICustomerservice;

@SpringBootApplication
public class Application {
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		ICustomerservice service = context.getBean(ICustomerservice.class);
		Customer customer = new Customer();
		customer.setFirst_name("Salam");
		customer.setLast_name("Ansari");
		customer.setEmail("salamansari444@gmail.com");
		String saveCustomer = service.saveCustomer(customer);
		System.out.println(saveCustomer);
	}

}
