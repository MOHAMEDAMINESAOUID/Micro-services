package org.sid.bankaccountservice8.mappers;

import org.sid.bankaccountservice8.dto.BankAccountRepositoryDTO;
import org.sid.bankaccountservice8.entites.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountRepositoryDTO fromBankAccount(BankAccount bankAccount){
        BankAccountRepositoryDTO bankAccountRepositoryDTO=new BankAccountRepositoryDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountRepositoryDTO);
        return bankAccountRepositoryDTO;
    }
}
