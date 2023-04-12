package id.co.bca.funtravel.customer.service;

import id.co.bca.funtravel.customer.model.Customer;
import id.co.bca.funtravel.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public void insert(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void delete(Integer customerId) {
        repository.deleteById(customerId);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return repository.findCustomerById(customerId);
    }
}
