package id.co.bca.funtravel.customer;

import id.co.bca.funtravel.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("")
    public @ResponseBody Object getCustomerById(@RequestParam("id") Integer userId) {
        return service.getCustomerById(userId);
    }

    @PostMapping("add")
    public @ResponseBody Object addNewCustomer() {
        return null;
    }

    @PutMapping("update")
    public @ResponseBody Object updateCustomer() {
        return null;
    }

    @DeleteMapping("delete")
    public @ResponseBody Object deleteCustomer() {
        return null;
    }
}
