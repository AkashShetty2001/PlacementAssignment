package in.ineuron.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import in.ineuron.model.Orders;
import in.ineuron.model.Users;
import in.ineuron.service.IOrdersService;
import in.ineuron.service.IUserService;

@Controller
public class UserOrderController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IOrdersService orderService;

	public void registerUser() {

		Users user = new Users();

		user.setFirstName("Salam");
		;
		user.setLastName("Ansari");
		user.setAddres("MI");

		Orders orders = new Orders();

		orders.setFood("vadaPav");
		orders.setTime(LocalDateTime.now());
		orders.setUser(user);

		user.setOrder(List.of(orders));

		Integer id = userService.registerUser(user);

		if (id != null) {
			System.out.println("Employee Registration is Successfull with id :: " + id);
		} else {
			System.out.println("Registration Failed");
		}
	}

	public void giveOrder() {

		Users user = new Users();

		user.setFirstName("Balam");
		user.setLastName("Jhingur");
		user.setAddres("Mumbai");
		;

		Orders orders = new Orders();

		orders.setFood("ice cream");
		orders.setTime(LocalDateTime.now());
		orders.setUser(user);

		Integer id = orderService.order(orders);

		if (id != null) {
			System.out.println("Order Placed Successfully with id :: " + id);
		} else {
			System.out.println("Failed to place");
		}

	}

}
