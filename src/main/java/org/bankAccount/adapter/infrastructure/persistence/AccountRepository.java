package org.bankAccount.adapter.infrastructure.persistence;

import org.bankAccount.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
