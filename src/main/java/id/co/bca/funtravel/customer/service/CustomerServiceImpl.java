package id.co.bca.funtravel.customer.service;

import id.co.bca.funtravel.customer.dto.CustomerDTO;
import id.co.bca.funtravel.customer.model.CustomerModel;
import id.co.bca.funtravel.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public CustomerModel insert(CustomerDTO dto) {
        CustomerModel model = new CustomerModel();
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setDob(new Date(dto.getDob()));
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setIdNumber(dto.getIdNumber());
        return repository.save(model);
    }

    @Override
    public CustomerModel update(CustomerDTO dto, Integer customerId) {
        CustomerModel model = repository.findCustomerById(customerId);
        model.setId(customerId);
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setIdNumber(dto.getIdNumber());
        return repository.save(model);
    }

    @Override
    public String delete(Integer customerId) {
        try {
            repository.deleteById(customerId);
            return "Successfully deleted customer data!";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete customer data!");
        }
    }

    @Override
    public CustomerModel getCustomerById(Integer customerId) {
        return repository.findCustomerById(customerId);
    }
}
