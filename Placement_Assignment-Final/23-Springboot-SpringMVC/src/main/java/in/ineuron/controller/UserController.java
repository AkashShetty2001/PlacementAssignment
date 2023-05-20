package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ineuron.model.User;
import in.ineuron.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping(value = "/")
	public String getWel() {
		return "index";
	}

	@GetMapping(value = "/login")
	public String getLoginPage() {
		return "login";
	}

	@GetMapping(value = "/regfrom")
	public String getForm() {
		return "form";
	}

	@PostMapping(value = "/reg")
	public String registerUser(User user, Model model) {

		Integer id = service.registerUser(user);

		if (id != null) {
			model.addAttribute("id", id);
			return "success";
		}

		return "fail";
	}

	@PostMapping(value = "/auth")
	public String authUser(String email, String password, Model model) {

		String status = service.authUser(email, password);

		System.out.println(status);
		
		if (status.equalsIgnoreCase("success")) {
			model.addAttribute("email", email);
			return "successLogin";
		} else if (status.equalsIgnoreCase("wrongpassword")) {
			return "wrongPass";
		}

		return "failLogin";
	}

}