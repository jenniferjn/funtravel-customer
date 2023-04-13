package id.co.bca.funtravel.customer.repository;

import id.co.bca.funtravel.customer.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {

    CustomerModel findCustomerById(Integer id);
}
