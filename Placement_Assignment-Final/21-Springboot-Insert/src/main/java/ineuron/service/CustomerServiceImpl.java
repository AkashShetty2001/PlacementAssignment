package ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ineuron.dao.ICustomerDao;
import ineuron.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerservice {

	@Autowired
	private ICustomerDao repo;

	@Override
	public String saveCustomer(Customer customer) {

		Customer savecustomer = null;
		if (customer != null) {
			savecustomer=repo.save(customer);
		}
		return savecustomer !=null ? "Customer Data got inserted with " + savecustomer : "customer Insertion failed";
	}

}
