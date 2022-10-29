package org.sid.bankaccountservice8.Service;

import org.sid.bankaccountservice8.dto.BankAccountRepositoryDTO;
import org.sid.bankaccountservice8.dto.BankAccountRequestDTO;

public interface AccountService  {
        BankAccountRepositoryDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountRepositoryDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
