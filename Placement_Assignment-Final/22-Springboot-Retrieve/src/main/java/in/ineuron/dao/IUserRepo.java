package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import in.ineuron.model.Users;

public interface IUserRepo extends JpaRepository<Users, Integer> {

}
