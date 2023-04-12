package id.co.bca.funtravel.customer.service;

import id.co.bca.funtravel.customer.model.Customer;

public interface CustomerService {

    void insert(Customer customer);

    void update(Customer customer);

    void delete(Integer customerId);

    Customer getCustomerById(Integer customerId);
}
