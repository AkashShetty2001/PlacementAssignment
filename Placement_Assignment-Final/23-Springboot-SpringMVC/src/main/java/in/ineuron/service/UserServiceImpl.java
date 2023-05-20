package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IUserDao;
import in.ineuron.model.User;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao repo;
	

	@Override
	public Integer registerUser(User user) {

		User user2 = repo.save(user);
		
		return user2.getUserId();
	}


	@Override
	public String authUser(String email, String password) {
		
		User user = repo.findByEmail(email);
		
		if (user!=null) {
			if (user.getPassword().equals(password)) {
				return "success";
			}else {
				return "wrongpassword";
			}
		}
		
		return "fail";
	}
	
	

}