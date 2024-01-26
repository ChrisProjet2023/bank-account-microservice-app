package net.chris.accountservice.web;

import net.chris.accountservice.clients.CustomerRestClient;
import net.chris.accountservice.entities.BankAccount;
import net.chris.accountservice.model.Customer;
import net.chris.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository accountRespository;
    private final CustomerRestClient customerRestClient;
    public AccountRestController(BankAccountRepository accountRespository, CustomerRestClient customerRestClient){
        this.accountRespository = accountRespository;
        this.customerRestClient =  customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){

        List<BankAccount> accountList  = accountRespository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));

        });
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountId(@PathVariable  String id){

        BankAccount bankAccount =  accountRespository.findById(id).get();
        //recupérer les informations du client dans la base de customer avec open feign
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return  bankAccount;
    }


}
