package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IOrderRepo;
import in.ineuron.model.Orders;

@Service
public class OrderServiceImpl implements IOrdersService {

	@Autowired
	private IOrderRepo orderRepo;

	@Override
	public Integer order(Orders orders) {
		return orderRepo.save(orders).getOrderId();
	}

}
