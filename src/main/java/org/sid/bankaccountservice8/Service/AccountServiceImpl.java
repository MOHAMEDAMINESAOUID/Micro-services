package org.sid.bankaccountservice8.Service;

import org.sid.bankaccountservice8.dto.BankAccountRepositoryDTO;
import org.sid.bankaccountservice8.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice8.entites.BankAccount;
import org.sid.bankaccountservice8.mappers.AccountMapper;
import org.sid.bankaccountservice8.repositorires.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountRepositoryDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date().getTime())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
       BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountRepositoryDTO bankAccountRepositoryDTO = accountMapper.fromBankAccount(saveBankAccount);
        
        return bankAccountRepositoryDTO;
    }
    @Override
    public BankAccountRepositoryDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(id)
                .createAt(new Date().getTime())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountRepositoryDTO bankAccountRepositoryDTO = accountMapper.fromBankAccount(saveBankAccount);

        return bankAccountRepositoryDTO;
    }
}
