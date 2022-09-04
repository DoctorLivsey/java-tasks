package demo.streamapi.repos;

import java.util.List;

import demo.streamapi.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

	List<Customer> findAll();
}
