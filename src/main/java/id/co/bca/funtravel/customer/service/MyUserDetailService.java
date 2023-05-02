package id.co.bca.funtravel.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import id.co.bca.funtravel.customer.model.CustomerModel;
import id.co.bca.funtravel.customer.model.MyUserDetailModel;
import id.co.bca.funtravel.customer.repository.CustomerRepository;

public class MyUserDetailService implements UserDetailsService {
    
    @Autowired
    private CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // email as username
        CustomerModel user = repository.findCustomerByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("No customer found!");
        }

        return new MyUserDetailModel(user);
    }
}
