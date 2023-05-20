package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.User;

public interface IUserDao  extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	
}