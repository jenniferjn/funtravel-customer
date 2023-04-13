package id.co.bca.funtravel.customer.controller;

import id.co.bca.funtravel.customer.dto.CustomerDTO;
import id.co.bca.funtravel.customer.model.CustomerModel;
import id.co.bca.funtravel.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("")
    public @ResponseBody CustomerModel getCustomerById(@RequestParam("id") Integer customerId) {
        return service.getCustomerById(customerId);
    }

    @PostMapping("add")
    public @ResponseBody Object addNewCustomer(@RequestBody CustomerDTO customer) {
        return service.insert(customer);
    }

    @PutMapping("update")
    public @ResponseBody Object updateCustomer(@RequestBody CustomerDTO customer, @RequestParam("id") Integer customerId) {
        return service.update(customer, customerId);
    }

    @DeleteMapping("delete")
    public @ResponseBody Object deleteCustomer(@RequestParam("id") Integer customerId) {
        return service.delete(customerId);
    }
}
