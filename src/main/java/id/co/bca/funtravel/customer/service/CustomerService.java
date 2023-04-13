package id.co.bca.funtravel.customer.service;

import id.co.bca.funtravel.customer.dto.CustomerDTO;
import id.co.bca.funtravel.customer.model.CustomerModel;

public interface CustomerService {

    CustomerModel insert(CustomerDTO customer);

    CustomerModel update(CustomerDTO customer, Integer customerId);

    String delete(Integer customerId);

    CustomerModel getCustomerById(Integer customerId);
}
