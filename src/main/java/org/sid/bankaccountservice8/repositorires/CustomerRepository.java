package org.sid.bankaccountservice8.repositorires;

import org.sid.bankaccountservice8.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {


}
