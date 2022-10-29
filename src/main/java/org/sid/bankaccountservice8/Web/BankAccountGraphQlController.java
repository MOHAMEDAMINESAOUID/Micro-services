package org.sid.bankaccountservice8.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.MapKeyType;
import org.sid.bankaccountservice8.Service.AccountService;
import org.sid.bankaccountservice8.dto.BankAccountRepositoryDTO;
import org.sid.bankaccountservice8.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice8.entites.BankAccount;
import org.sid.bankaccountservice8.entites.Customer;
import org.sid.bankaccountservice8.repositorires.BankAccountRepository;
import org.sid.bankaccountservice8.repositorires.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {


@Autowired
private BankAccountRepository bankAccountRepository;

@Autowired
private AccountService accountService;
@Autowired
private CustomerRepository customerRepository;
@QueryMapping
public List<BankAccount> accountsList(){
    return  bankAccountRepository.findAll();

}

@QueryMapping
    public BankAccount bankAccountById(@Argument String id){
    return  bankAccountRepository.findById(id)
            .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
}
   @MutationMapping
   public BankAccountRepositoryDTO updateAccount(@Argument String id,BankAccountRequestDTO bankAccount){
        return   accountService.updateAccount(id,bankAccount);
   }
    @MutationMapping
    public void deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);

    }
    @QueryMapping
    public List<Customer> customers(){
    return  customerRepository.findAll();
    }
}

/*
record  BankAccountDTO(Double balance,String type, String currency){



}
*/