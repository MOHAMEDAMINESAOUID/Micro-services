package org.sid.bankaccountservice8.Web;

import org.sid.bankaccountservice8.Service.AccountService;
import org.sid.bankaccountservice8.Service.AccountServiceImpl;
import org.sid.bankaccountservice8.dto.BankAccountRepositoryDTO;
import org.sid.bankaccountservice8.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice8.entites.BankAccount;
import org.sid.bankaccountservice8.mappers.AccountMapper;
import org.sid.bankaccountservice8.repositorires.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private AccountService accountService;
    private AccountMapper accountMapper;
    private BankAccountRepository bankAccountRepository;
    public AccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository =bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper =accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return  bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts{id}")
    public BankAccount bankAccounts(@PathVariable String id ){
        return  bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountRepositoryDTO save(@RequestBody BankAccountRequestDTO requestDTO){
    return accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public  BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreateAt()!=null)   account.setCreateAt(new Date().getTime());
        if(bankAccount.getType()!=null)  account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return  bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts{id}")
    public void  deleteAccount(@PathVariable String id ){
         bankAccountRepository.deleteById(id);
    }
}
