package net.chris.customerservice.web;

import net.chris.customerservice.entities.Customer;
import net.chris.customerservice.repository.CustomerRespository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    private CustomerRespository customerRespository;

    public CustomerRestController(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRespository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerId(@PathVariable Long id){
        return customerRespository.findById(id).get();
    }
}
