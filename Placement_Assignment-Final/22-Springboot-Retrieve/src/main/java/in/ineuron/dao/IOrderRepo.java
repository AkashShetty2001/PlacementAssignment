package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Orders;

public interface IOrderRepo extends JpaRepository<Orders, Integer> {

}
