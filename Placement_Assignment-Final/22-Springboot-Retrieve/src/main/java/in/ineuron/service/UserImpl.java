package in.ineuron.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IUserRepo;
import in.ineuron.model.Users;


@Service
public class UserImpl implements IUserService {
	
	@Autowired
	private IUserRepo userRepo;

	@Override
	public Integer registerUser(Users user) {
		Users saveUser = userRepo.save(user);

		return saveUser.getUserId();
	}
	


}
